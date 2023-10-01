package co.uninpahu.sight.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericMessageResponse {
    private String timestamp;
    private String responseCode;
    private String responseDetail;
}
