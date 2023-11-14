package co.uninpahu.sight.admin.dto.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponsePersonPayloadCreateDto implements Serializable {
    private Integer numberIdentification;
    private String names;
    private String lastNames;
    private String email;
    private String state;
}
