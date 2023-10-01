package co.uninpahu.sight.admin.dto.rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseRolPayloadAll implements Serializable {
    private List<RolDto> roles;
}
