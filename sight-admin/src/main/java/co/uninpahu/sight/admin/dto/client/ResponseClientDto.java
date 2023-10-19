package co.uninpahu.sight.admin.dto.client;

import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.AbstractGenericResponse;
import co.uninpahu.sight.admin.util.AbstractGenericResponseMessageResponse;
import co.uninpahu.sight.admin.util.GenericResponseCodes;

public class ResponseClientDto extends AbstractGenericResponse<ResponseClientDtoPayload> {

    public ResponseClientDto(GenericResponseCodes genericResponseCodes, ResponseClientDtoPayload data, String message) {
        super(
                AbstractGenericResponseMessageResponse
                        .builder()
                        .timestamp(new TimeManagerService().getInstantIsoFormat())
                        .responseCode(genericResponseCodes.getValue())
                        .responseDetail(genericResponseCodes.getDescription())
                        .build(),
                data,
                message
        );
    }
}
