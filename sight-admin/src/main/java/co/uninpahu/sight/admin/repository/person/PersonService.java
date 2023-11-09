package co.uninpahu.sight.admin.repository.person;

import co.uninpahu.sight.admin.dto.person.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> getPersons() {
        return personRepository.findAll()
                .stream()
                .map()
    }
}
