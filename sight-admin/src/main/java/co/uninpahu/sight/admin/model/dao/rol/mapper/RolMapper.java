package co.uninpahu.sight.admin.model.dao.rol.mapper;

import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.model.entity.rol.Rol;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RolMapper {

    public static RolDto buildRolEntitytoRolDto(Rol rol) {
        return RolDto
                .builder()
                .idRol(rol.getIdRol())
                .name(rol.getName())
                .state(rol.getState())
                .build();
    }

    public static Rol buildRolDTOtoRolEntity(RolDto rolDto) {
        return Rol
                .builder()
                .idRol(rolDto.getIdRol())
                .name(rolDto.getName())
                .state(rolDto.getState())
                .build();
    }
}
