package co.uninpahu.sight.admin.repository.client.mapper;

import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.entity.client.Client;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ClientMapper {

    public static ClientDto buildClientEntityToDto(Client client) {
        return ClientDto
                .builder()
                .idClient(client.getIdClient())
                .name(client.getName())
                .state(client.getState())
                .build();
    }

    public static Client buildClientDtoToEntity(ClientDto clientDto) {
        return Client
                .builder()
                .idClient(clientDto.getIdClient())
                .name(clientDto.getName())
                .state(clientDto.getState())
                .build();
    }
}
