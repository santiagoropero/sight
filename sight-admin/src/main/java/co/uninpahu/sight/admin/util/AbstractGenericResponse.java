package co.uninpahu.sight.admin.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractGenericResponse<T> {
    private AbstractGenericResponseMessageResponse messageResponse;
    private T data;
    private String message;
}
