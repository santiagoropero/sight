package co.uninpahu.sight.admin.dto.project;

import co.uninpahu.sight.admin.util.StateEnum;
import co.uninpahu.sight.admin.util.constraints.ValueOfDate;
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
public class RequestProjectDto implements Serializable {

    @NotBlank(message = "El nombre del proyecto no puede estar vacío")
    @NotNull(message = "El nombre del proyecto no puede estar nulo")
    @Size(max = 60, message = "El nombre del proyecto debe tener una longitud maxíma de 60 caracteres")
    private String name;

    private Integer client;

    private Integer person;

    @ValueOfDate(message = "La fecha inicio no tiene el formato correcto")
    private String dateStart;

    @ValueOfDate(message = "La fecha fin no tiene el formato correcto")
    private String dateEnd;

    @ValueOfEnum(enumClass = StateEnum.class, message = "Los valores permitidos para el estado son: ACTIVO, INACTIVO")
    private String state;
}
