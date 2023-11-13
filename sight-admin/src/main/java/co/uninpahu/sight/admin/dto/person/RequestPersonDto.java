package co.uninpahu.sight.admin.dto.person;

import co.uninpahu.sight.admin.util.StateEnum;
import co.uninpahu.sight.admin.util.constraints.ValueOfEmail;
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
public class RequestPersonDto implements Serializable {

    @NotBlank(message = "El número de documento de la persona no puede estar vacío")
    @NotNull(message = "El número de documento de la persona no puede estar nulo")
    @Size(max = 20, message = "El número de documento de la persona debe tener una longitud maxíma de 20 caracteres")
    private String numberIdentification;

    @NotBlank(message = "Los nombres de la persona no pueden estar vacíos")
    @NotNull(message = "Los nombres de la persona no pueden estar nulos")
    @Size(max = 60, message = "Los nombres de la persona deben tener una longitud maxíma de 60 caracteres")
    private String names;

    @NotBlank(message = "Los apellidos de la persona no pueden estar vacíos")
    @NotNull(message = "Los apellidos de la persona no pueden estar nulos")
    @Size(max = 60, message = "Los apellidos de la persona deben tener una longitud maxíma de 60 caracteres")
    private String lastNames;

    @ValueOfEmail
    private String email;

    @ValueOfEnum(enumClass = StateEnum.class, message = "Los valores permitidos para el estado son: ACTIVO, INACTIVO")
    private String state;

    private Integer rol;
}
