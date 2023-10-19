package co.uninpahu.sight.admin.dto.client;

import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.AbstractGenericResponse;
import co.uninpahu.sight.admin.util.AbstractGenericResponseMessageResponse;
import co.uninpahu.sight.admin.util.GenericResponseCodes;

public class ResponseClientDtoAll extends AbstractGenericResponse<ResponseClientDtoPayloadAll> {
    public ResponseClientDtoAll(GenericResponseCodes genericResponseCodes, ResponseClientDtoPayloadAll data, String message) {
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
