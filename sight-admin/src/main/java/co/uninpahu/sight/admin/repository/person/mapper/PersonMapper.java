package co.uninpahu.sight.admin.repository.person.mapper;

import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.entity.person.Person;
import co.uninpahu.sight.admin.entity.rol.Rol;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {

    public static PersonDto buildPersonEntityToDto(Person person) {
        return PersonDto
                .builder()
                .idPerson(person.getIdPerson())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .email(person.getEmail())
                .state(person.getState())
                .rol(
                        RolDto
                                .builder()
                                .idRol(person.getRol().getIdRol())
                                .name(person.getRol().getName())
                                .state(person.getRol().getState())
                                .build()
                )
                .build();
    }

    public static Person buildPersonDtoToEntity(PersonDto personDto) {
        return Person
                .builder()
                .idPerson(personDto.getIdPerson())
                .names(personDto.getNames())
                .lastNames(personDto.getLastNames())
                .email(personDto.getEmail())
                .state(personDto.getState())
                .rol(
                        Rol
                                .builder()
                                .idRol(personDto.getRol().getIdRol())
                                .name(personDto.getRol().getName())
                                .state(personDto.getRol().getState())
                                .build()
                )
                .build();
    }
}
