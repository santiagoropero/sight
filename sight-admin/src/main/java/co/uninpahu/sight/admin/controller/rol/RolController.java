package co.uninpahu.sight.admin.controller.rol;

import co.uninpahu.sight.admin.controller.rol.mapper.RolMapper;
import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.dto.rol.ResponseRolDtoAll;
import co.uninpahu.sight.admin.model.dao.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/all")
    public ResponseEntity<ResponseRolDtoAll> getRoles() {
        try {
            List<RolDto> roles = rolService.getRoles();
            if (!roles.isEmpty()) {
                return new ResponseEntity<>(RolMapper.buildResponseSuccess(roles), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(RolMapper.buildResponseEmpty(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
