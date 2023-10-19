package co.uninpahu.sight.admin.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseClientDtoPayload implements Serializable {
    private ClientDto client;
}
