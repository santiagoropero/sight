package co.uninpahu.sight.admin.controller.rol.mapper;

import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.dto.rol.ResponseRolDtoAll;
import co.uninpahu.sight.admin.dto.rol.ResponseRolPayloadAll;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RolMapper {

    public static ResponseRolDtoAll buildResponseSuccess(List<RolDto> roles) {
        return new ResponseRolDtoAll(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseRolPayloadAll
                        .builder()
                        .roles(roles)
                        .build(),
                null
        );
    }

    public static ResponseRolDtoAll buildResponseEmpty() {
        return new ResponseRolDtoAll(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseRolPayloadAll
                        .builder()
                        .roles(new ArrayList<>())
                        .build(),
                "No se encuentran registros en la base datos"
        );
    }
}
