package co.uninpahu.sight.admin.dto.client;

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
public class RequestClientDto implements Serializable {
    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @NotNull(message = "El nombre del cliente no puede estar nulo")
    @Size(max = 40, message = "El nombre del cliente debe tener una longitud maxíma de 40 caracteres")
    private String name;

    @NotBlank(message = "El estado no puede estar vacío")
    @NotNull(message = "El estado no puede estar nulo")
    @Size(max = 20, message = "El estado debe tener una longitud maxíma de 20 caracteres")
    private String state;
}
