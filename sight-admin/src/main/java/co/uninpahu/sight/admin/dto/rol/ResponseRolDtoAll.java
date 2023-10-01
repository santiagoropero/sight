package co.uninpahu.sight.admin.dto.rol;

import co.uninpahu.sight.admin.util.AbstractGenericResponse;
import co.uninpahu.sight.admin.util.AbstractGenericResponseMessageResponse;
import co.uninpahu.sight.admin.util.GenericResponseCodes;

public class ResponseRolDtoAll extends AbstractGenericResponse<ResponseRolPayloadAll> {


    public ResponseRolDtoAll(GenericResponseCodes genericResponseCodes, ResponseRolPayloadAll data, String message) {
        super(
                AbstractGenericResponseMessageResponse
                        .builder()
                        .timestamp(null)
                        .responseCode(genericResponseCodes.getValue())
                        .responseDetail(genericResponseCodes.getDescription())
                        .build(),
                data,
                message
        );
    }
}
