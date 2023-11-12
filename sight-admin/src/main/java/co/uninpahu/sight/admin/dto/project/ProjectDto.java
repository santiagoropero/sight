package co.uninpahu.sight.admin.dto.project;

import co.uninpahu.sight.admin.dto.client.ClientDto;
import co.uninpahu.sight.admin.dto.person.PersonDto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class ProjectDto implements Serializable {

    private Long idProject;

    private String name;

    private Date startDate;

    private Date endDate;

    private String state;

    private ClientDto client;

    private PersonDto person;
}
