package co.uninpahu.sight.admin.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseMessageResponse implements Serializable {
    private String timestamp;
    private String responseCode;
    private String responseDetail;
}
