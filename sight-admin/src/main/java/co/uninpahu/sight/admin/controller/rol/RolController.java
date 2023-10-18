package co.uninpahu.sight.admin.controller.rol;

import co.uninpahu.sight.admin.controller.rol.mapper.RolMapper;
import co.uninpahu.sight.admin.dto.rol.RequestRolDto;
import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.repository.rol.RolService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
@Slf4j
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/all")
    public ResponseEntity<?> getRoles() {
        log.info("Inicio consultar roles");
        try {
            List<RolDto> roles = rolService.getRoles();
            if (!roles.isEmpty()) {
                log.info("Exito consultando los roles");
                return new ResponseEntity<>(RolMapper.buildResponseSuccess(roles), HttpStatus.OK);
            } else {
                log.info("No existen roles");
                return new ResponseEntity<>(RolMapper.buildResponseEmpty(), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Error consultando los roles, detalles: {} ", e.getMessage());
            return new ResponseEntity<>(RolMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, "No es posible consultar los roles"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@Valid @RequestBody RequestRolDto requestRolDto) {
        log.info("Inicio crear rol");
        try {
            rolService.save(RolMapper.buildRequestCreateRol(requestRolDto));
            log.info("Exito creando el rol: {} ", requestRolDto.getName());
            return new ResponseEntity<>(RolMapper.buildSuccessResponseCreate(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error creando el rol, detalles: {} ", e.getMessage());
            return new ResponseEntity<>(RolMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, "No es posible realizar el registro del rol"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
