package co.uninpahu.sight.admin.repository.client;

import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.repository.client.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDto> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(response -> ClientMapper.buildClientEntityToDto(response))
                .collect(Collectors.toList());
    }

    public void create(ClientDto clientDto) {
        clientRepository.save(ClientMapper.buildClientDtoToEntity(clientDto));
    }
}
