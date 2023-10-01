package co.uninpahu.sight.admin.dto;

import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError implements Serializable {
    private GenericResponseMessageResponse messageResponse;
    private List<ResponseErrorList> errors;
}
