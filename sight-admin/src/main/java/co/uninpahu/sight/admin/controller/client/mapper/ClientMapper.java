package co.uninpahu.sight.admin.controller.client.mapper;

import co.uninpahu.sight.admin.dto.ResponseError;
import co.uninpahu.sight.admin.dto.ResponseErrorList;
import co.uninpahu.sight.admin.dto.client.*;
import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class ClientMapper {

    public static ResponseClientDtoAll buildSuccessResponse(List<ClientDto> clients) {
        return new ResponseClientDtoAll(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseClientDtoPayloadAll
                        .builder()
                        .clients(clients)
                        .build(),
                null
        );
    }

    public static ResponseClientDtoAll buildResponseEmpty(String message) {
        return new ResponseClientDtoAll(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseClientDtoPayloadAll
                        .builder()
                        .clients(new ArrayList<>())
                        .build(),
                message
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

    public static ClientDto buildRequestCreateClient(RequestClientDto requestClientDto) {
        return ClientDto
                .builder()
                .name(requestClientDto.getName())
                .state(requestClientDto.getState())
                .build();
    }

    public static ResponseClientDto buildResponseSuccessCreate(RequestClientDto requestClientDto, String message) {
        return new ResponseClientDto(
                GenericResponseCodes.REGISTRO_EXITOSO,
                ResponseClientDtoPayload
                        .builder()
                        .name(requestClientDto.getName())
                        .state(requestClientDto.getState())
                        .build(),
                message
        );
    }
}
