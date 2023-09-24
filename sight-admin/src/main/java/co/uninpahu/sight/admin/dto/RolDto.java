package co.uninpahu.sight.admin.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RolDto implements Serializable {
    private Long idRol;
    private String name;
    private String state;
}
