package co.uninpahu.sight.admin.dto.client;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ClientDto implements Serializable {

    private Long idClient;
    private String name;
    private String state;
}
