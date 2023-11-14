package co.uninpahu.sight.admin.dto.person;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponsePersonPayloadAllDto implements Serializable {
    private List<PersonDto> persons;
}
