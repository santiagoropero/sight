package co.uninpahu.sight.admin.repository.project;

import co.uninpahu.sight.admin.dto.project.ProjectDto;
import co.uninpahu.sight.admin.repository.project.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDto> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(response -> ProjectMapper.buildProjectEntityToDto(response))
                .collect(Collectors.toList());
    }

    public void create(ProjectDto projectDto) {
        projectRepository.save(ProjectMapper.buildProjectDtoToEntity(projectDto));
    }

}
