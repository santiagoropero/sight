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
public class RequestProjectClientDto implements Serializable {

    private Integer idClient;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @NotNull(message = "El nombre del cliente no puede estar nulo")
    @Size(max = 40, message = "El nombre del cliente debe tener una longitud maxíma de 40 caracteres")
    private String name;
}