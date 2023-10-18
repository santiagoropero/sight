package co.uninpahu.sight.admin.dto.rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Validated
public class RequestRolDto implements Serializable {

    @NotBlank(message = "El nombre del rol no puede estar vacío")
    @NotNull(message = "El nombre del rol no puede estar nulo")
//    @Size(max = 3, message = "El nombre del rol debe tener una longitud maxíma de 40 caracteres")
    private String name;

    @NotBlank(message = "El estado no puede estar vacío")
    @NotNull(message = "El estado no puede estar nulo")
    @Size(max = 3, message = "El estado debe tener una longitud maxíma de 20 caracteres")
    private String state;
}
