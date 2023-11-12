package co.uninpahu.sight.admin.controller.person.mapper;

import co.uninpahu.sight.admin.dto.ResponseError;
import co.uninpahu.sight.admin.dto.ResponseErrorList;
import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.dto.person.ResponsePersonAllDto;
import co.uninpahu.sight.admin.dto.person.ResponsePersonPayloadAllDto;
import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class PersonMapper {

    public static ResponsePersonAllDto buildSuccessResponse(List<PersonDto> persons) {
        return new ResponsePersonAllDto(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponsePersonPayloadAllDto
                        .builder()
                        .persons(persons)
                        .build(),
                null
        );
    }

    public static ResponsePersonAllDto buildResponseEmpty(String message) {
        return new ResponsePersonAllDto(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponsePersonPayloadAllDto
                        .builder()
                        .persons(new ArrayList<>())
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
}
