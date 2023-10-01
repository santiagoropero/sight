package co.uninpahu.sight.admin.model.dao.rol;

import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.model.dao.rol.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;


    public List<RolDto> getRoles() {
        return rolRepository.findAll()
                .stream()
                .map(response -> RolMapper.buildRolEntitytoRolDto(response))
                .collect(Collectors.toList());
    }

    public void save(RolDto rolDto) {
        rolRepository.save(RolMapper.buildRolDTOtoRolEntity(rolDto));
    }

}
