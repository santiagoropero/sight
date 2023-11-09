package co.uninpahu.sight.admin.dto.person;

import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.entity.rol.Rol;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
public class PersonDto implements Serializable {
    private Long idPerson;

    private String names;

    private String lastNames;

    private String email;

    private String state;

    private RolDto rol;
}
