package co.uninpahu.sight.admin.controller.project.mapper;

import co.uninpahu.sight.admin.dto.ResponseError;
import co.uninpahu.sight.admin.dto.ResponseErrorList;
import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.dto.project.*;
import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@UtilityClass
public class ProjectMapper {

    public static ResponseProjectAllDto buildSuccessResponse(List<ProjectDto> projects) {
        return new ResponseProjectAllDto(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseProjectPayloadAllDto
                        .builder()
                        .projects(projects)
                        .build(),
                null
        );
    }

    public static ResponseProjectAllDto buildResponseEmpty(String message) {
        return new ResponseProjectAllDto(
                GenericResponseCodes.CONSULTA_EXITOSA,
                ResponseProjectPayloadAllDto
                        .builder()
                        .projects(new ArrayList<>())
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
    
    
    public static ProjectDto buildRequestCreateProject(RequestProjectDto requestProjectDto, Date dateStart, Date dateEnd) {
        return ProjectDto
                .builder()
                .name(requestProjectDto.getName())
                .startDate(dateStart)
                .endDate(dateEnd)
                .state(requestProjectDto.getState())
                .client(
                        ClientDto
                                .builder()
                                .idClient(Long.valueOf(requestProjectDto.getClient().getIdClient()))
                                .name(requestProjectDto.getClient().getName())
                                .build()
                )
                .person(
                        PersonDto
                                .builder()
                                .idPerson(Long.valueOf(requestProjectDto.getPerson().getIdPerson()))
                                .names(requestProjectDto.getPerson().getName())
                                .build()
                )
                .build();
    }

    public static ResponseProjectCreateDto buildResponseSuccessCreate(RequestProjectDto requestProjectDto, String message) {
        return new ResponseProjectCreateDto(
                GenericResponseCodes.REGISTRO_EXITOSO,
                ResponseProjectPayloadCreateDto
                        .builder()
                        .name(requestProjectDto.getName())
                        .client(requestProjectDto.getClient().getName())
                        .person(requestProjectDto.getPerson().getName())
                        .startDate(requestProjectDto.getDateStart())
                        .endDate(requestProjectDto.getDateEnd())
                        .state(requestProjectDto.getState())
                        .build(),
                message
        );
    }
}
