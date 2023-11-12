package co.uninpahu.sight.admin.repository.project.mapper;

import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.dto.person.PersonDto;
import co.uninpahu.sight.admin.dto.project.ProjectDto;
import co.uninpahu.sight.admin.dto.rol.RolDto;
import co.uninpahu.sight.admin.entity.client.Client;
import co.uninpahu.sight.admin.entity.person.Person;
import co.uninpahu.sight.admin.entity.project.Project;
import co.uninpahu.sight.admin.entity.rol.Rol;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProjectMapper {
    
    public static ProjectDto buildProjectEntityToDto(Project project) {
        return ProjectDto
                .builder()
                .idProject(project.getIdProject())
                .name(project.getName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .state(project.getState())
                .client(
                        ClientDto
                                .builder()
                                .idClient(project.getClient().getIdClient())
                                .name(project.getClient().getName())
                                .state(project.getClient().getState())
                                .build()   
                )
                .person(
                        PersonDto
                                .builder()
                                .idPerson(project.getPerson().getIdPerson())
                                .names(project.getPerson().getNames())
                                .lastNames(project.getPerson().getLastNames())
                                .email(project.getPerson().getEmail())
                                .state(project.getPerson().getState())
                                .rol(
                                        RolDto
                                                .builder()
                                                .idRol(project.getPerson().getRol().getIdRol())
                                                .name(project.getPerson().getRol().getName())
                                                .state(project.getPerson().getRol().getState())
                                                .build()
                                )
                                .build()
                )
                .build();
    }

    public static Project buildProjectDtoToEntity(ProjectDto projectDto) {
        return Project
                .builder()
                .idProject(projectDto.getIdProject())
                .name(projectDto.getName())
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .state(projectDto.getState())
                .client(
                        Client
                                .builder()
                                .idClient(projectDto.getClient().getIdClient())
                                .build()
                )
                .person(
                        Person
                                .builder()
                                .idPerson(projectDto.getPerson().getIdPerson())
                                .build()
                )
                .build();
    }
}
