package co.uninpahu.sight.admin.dto.project;

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
public class RequestProjectPersonDto implements Serializable {

    private Integer idPerson;

    @NotBlank(message = "El nombre de la persona no puede estar vacío")
    @NotNull(message = "El nombre de la persona no puede estar nulo")
    @Size(max = 60, message = "El nombre de la persona debe tener una longitud maxíma de 60 caracteres")
    private String name;
}
