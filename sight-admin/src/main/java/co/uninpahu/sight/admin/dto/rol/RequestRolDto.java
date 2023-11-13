package co.uninpahu.sight.admin.dto.rol;

import co.uninpahu.sight.admin.util.StateEnum;
import co.uninpahu.sight.admin.util.constraints.ValueOfEnum;
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
    @Size(max = 40, message = "El nombre del rol debe tener una longitud maxíma de 40 caracteres")
    private String name;

    @ValueOfEnum(enumClass = StateEnum.class, message = "Los valores permitidos para el estado son: ACTIVO, INACTIVO")
    private String state;
}
