package co.uninpahu.sight.admin.dto.person;

import co.uninpahu.sight.admin.dto.rol.RolDto;
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

    @NotBlank(message = "El correo de la persona no puede estar vacío")
    @NotNull(message = "EL correo de la persona no puede estar nulo")
    @Size(max = 40, message = "El correo de la persona deben tener una longitud maxíma de 40 caracteres")
    private String email;

    @NotBlank(message = "El estado no puede estar vacío")
    @NotNull(message = "El estado no puede estar nulo")
    @Size(max = 20, message = "El estado debe tener una longitud maxíma de 20 caracteres")
    private String state;

    private Integer rol;
}
