package co.uninpahu.sight.admin.controller.client;

import co.uninpahu.sight.admin.controller.client.mapper.ClientMapper;
import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.dto.client.RequestClientDto;
import co.uninpahu.sight.admin.repository.client.ClientService;
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
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private Environment environment;

    @GetMapping("/all")
    public ResponseEntity<?> getClients() {
        log.info("Inicio consultar clientes");
        try {
            List<ClientDto> clients = clientService.getClients();
            if (!clients.isEmpty()) {
                log.info("Exito consultando clientes");
                return new ResponseEntity(ClientMapper.buildSuccessResponse(clients), HttpStatus.OK);
            } else {
                log.info("No existen clientes");
                return new ResponseEntity(ClientMapper.buildResponseEmpty(environment.getProperty("messages.responseEmpty")), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Error consultando los clientes, detalles: {} ", e.getMessage());
            return new ResponseEntity<>(ClientMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.responseErrorFind")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@Valid @RequestBody RequestClientDto requestClientDto) {
        log.info("Inicio crear cliente");
        try {
            clientService.create(ClientMapper.buildRequestCreateClient(requestClientDto));
            log.info("Exito creando el cliente: {} ", requestClientDto.getName());
            return new ResponseEntity<>(ClientMapper.buildResponseSuccessCreate(requestClientDto, environment.getProperty("messages.responseSuccessCreate")), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error creando el cliente, detalles: {} ", e.getMessage());
            return new ResponseEntity<>(ClientMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.messageResponseErrorCreate")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
