package co.uninpahu.sight.admin.dto.rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseRolDtoPayload implements Serializable {
    private RolDto rol;
}
