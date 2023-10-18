package co.uninpahu.sight.admin.controller.rol.mapper;

import co.uninpahu.sight.admin.dto.ResponseError;
import co.uninpahu.sight.admin.dto.ResponseErrorList;
import co.uninpahu.sight.admin.dto.rol.*;
import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
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

    public static RolDto buildRequestCreateRol(RequestRolDto requestRolDto) {
        return RolDto
                .builder()
                .name(requestRolDto.getName())
                .state(requestRolDto.getState())
                .build();
    }

    public static ResponseRolDto buildSuccessResponseCreate() {
        return new ResponseRolDto(
                GenericResponseCodes.REGISTRO_EXITOSO,
                ResponseRolDtoPayload
                        .builder()
                        .build(),
                "Se ha creado el rol de forma exitosa."
        );
    }

    public static ResponseError buildErrorResponse(GenericResponseCodes genericResponseCodes, HttpStatus httpStatus, String errorMessage) {
        return ResponseError
                .builder()
                .messageResponse(
                        GenericResponseMessageResponse
                                .builder()
                                .timestamp(new TimeManagerService().getInstantIsoFormat())
                                .responseCode(genericResponseCodes.getValue())
                                .responseDetail(genericResponseCodes.getDescription())
                                .build()
                )
                .errors(
                        Collections.singletonList(
                                ResponseErrorList
                                        .builder()
                                        .errorCode(String.valueOf(httpStatus.value()))
                                        .errorDetails(errorMessage)
                                        .build()
                        )
                )
                .build();
    }
}
