package co.uninpahu.sight.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorList implements Serializable {
    private String errorCode;
    private String errorDetails;
}
