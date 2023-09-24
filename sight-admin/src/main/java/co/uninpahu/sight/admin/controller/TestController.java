package co.uninpahu.sight.admin.controller;

import co.uninpahu.sight.admin.dto.RolDto;
import co.uninpahu.sight.admin.model.dao.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private RolService rolService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        List<RolDto> roles = rolService.getRoles();
        if (!roles.isEmpty()) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
    }
}
