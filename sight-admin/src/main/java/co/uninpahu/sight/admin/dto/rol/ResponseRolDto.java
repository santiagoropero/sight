package co.uninpahu.sight.admin.dto.rol;

import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.AbstractGenericResponse;
import co.uninpahu.sight.admin.util.AbstractGenericResponseMessageResponse;
import co.uninpahu.sight.admin.util.GenericResponseCodes;

public class ResponseRolDto extends AbstractGenericResponse<ResponseRolDtoPayload> {
    public ResponseRolDto(GenericResponseCodes genericResponseCodes, ResponseRolDtoPayload data, String message) {
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
