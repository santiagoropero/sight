package co.uninpahu.sight.admin.dto.project;

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

    @NotBlank(message = "La fecha inicio del proyecto no puede estar vacía")
    @NotNull(message = "La fecha inicio proyecto no puede estar nula")
    private String dateStart;

    @NotBlank(message = "La fecha fin del proyecto no puede estar vacía")
    @NotNull(message = "La fecha fin del proyecto no puede estar nula")
    private String dateEnd;

    @NotBlank(message = "El estado no puede estar vacío")
    @NotNull(message = "El estado no puede estar nulo")
    @Size(max = 20, message = "El estado debe tener una longitud maxíma de 20 caracteres")
    private String state;
}
