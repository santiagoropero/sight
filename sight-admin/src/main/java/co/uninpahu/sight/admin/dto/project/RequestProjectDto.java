package co.uninpahu.sight.admin.dto.project;

import co.uninpahu.sight.admin.util.StateEnum;
import co.uninpahu.sight.admin.util.constraints.ValueOfDate;
import co.uninpahu.sight.admin.util.constraints.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Validated
public class RequestProjectDto implements Serializable {

    @NotBlank(message = "El nombre del proyecto no puede estar vacío")
    @NotNull(message = "El nombre del proyecto no puede estar nulo")
    @Size(max = 60, message = "El nombre del proyecto debe tener una longitud maxíma de 60 caracteres")
    private String name;

    @NotNull(message = "La información del cliente no puede estar vacía")
    @Valid
    private RequestProjectClientDto client;

    @NotNull(message = "La información de la persona no puede estar vacía")
    @Valid
    private RequestProjectPersonDto person;

    @ValueOfDate(message = "La fecha inicio no tiene el formato correcto")
    private String dateStart;

    @ValueOfDate(message = "La fecha fin no tiene el formato correcto")
    private String dateEnd;

    @ValueOfEnum(enumClass = StateEnum.class, message = "Los valores permitidos para el estado son: ACTIVO, INACTIVO")
    private String state;
}
