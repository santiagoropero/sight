package co.uninpahu.sight.admin.repository.person;

import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.repository.person.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> getPersons() {
        return personRepository.findAll()
                .stream()
                .map(response -> PersonMapper.buildPersonEntityToDto(response))
                .collect(Collectors.toList());
    }

    public void create(PersonDto personDto) {
        personRepository.save(PersonMapper.buildPersonDtoToEntity(personDto));
    }
}
