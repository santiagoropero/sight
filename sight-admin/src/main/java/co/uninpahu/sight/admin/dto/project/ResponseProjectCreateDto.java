package co.uninpahu.sight.admin.dto.project;

import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.AbstractGenericResponse;
import co.uninpahu.sight.admin.util.AbstractGenericResponseMessageResponse;
import co.uninpahu.sight.admin.util.GenericResponseCodes;

public class ResponseProjectCreateDto extends AbstractGenericResponse<ResponseProjectPayloadCreateDto> {

    public ResponseProjectCreateDto(GenericResponseCodes genericResponseCodes, ResponseProjectPayloadCreateDto data, String message) {
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
