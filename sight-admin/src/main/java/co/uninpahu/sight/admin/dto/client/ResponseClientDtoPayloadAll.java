package co.uninpahu.sight.admin.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseClientDtoPayloadAll implements Serializable {

    private List<ClientDto> clients;
}
