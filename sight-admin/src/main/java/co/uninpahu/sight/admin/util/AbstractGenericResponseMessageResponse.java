package co.uninpahu.sight.admin.util;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractGenericResponseMessageResponse implements Serializable {
    private String timestamp;
    private String responseCode;
    private String responseDetail;
}
