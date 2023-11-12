package co.uninpahu.sight.admin.controller.person;

import co.uninpahu.sight.admin.controller.person.mapper.PersonMapper;
import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.dto.person.RequestPersonDto;
import co.uninpahu.sight.admin.repository.person.PersonService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private Environment environment;

    @GetMapping("/all")
    public ResponseEntity<?> getPersons() {
        log.info("Inicio consultar personas");
        try {
            List<PersonDto> persons = personService.getPersons();
            if (!persons.isEmpty()) {
                log.info("Exito consultando personas");
                return new ResponseEntity(PersonMapper.buildSuccessResponse(persons), HttpStatus.OK);
            } else {
                log.info("No existen personas");
                return new ResponseEntity(PersonMapper.buildResponseEmpty(environment.getProperty("messages.responseEmpty")), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Error consultando las personas, detalles: {} ", e.getCause().getMessage());
            return new ResponseEntity<>(PersonMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.responseErrorFind")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@Valid @RequestBody RequestPersonDto requestPersonDto) {
        log.info("Inicio crear persona");
        try {
            personService.create(PersonMapper.buildRequestCreatePerson(requestPersonDto));
            log.info("Exito creando la persona con la identificacion: {} ", requestPersonDto.getNumberIdentification());
            return new ResponseEntity<>(PersonMapper.buildResponseSuccessCreate(requestPersonDto, environment.getProperty("messages.responseSuccessCreate")), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error creando la persona, detalles: {} ", e.getMessage());
            return new ResponseEntity<>(PersonMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.messageResponseErrorCreate")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
