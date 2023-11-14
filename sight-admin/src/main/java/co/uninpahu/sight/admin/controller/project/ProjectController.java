package co.uninpahu.sight.admin.controller.project;

import co.uninpahu.sight.admin.controller.project.mapper.ProjectMapper;
import co.uninpahu.sight.admin.dto.project.ProjectDto;
import co.uninpahu.sight.admin.dto.project.RequestProjectDto;
import co.uninpahu.sight.admin.repository.project.ProjectService;
import co.uninpahu.sight.admin.services.TimeManagerService;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
@Slf4j
@Validated
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Environment environment;

    @Autowired
    private TimeManagerService timeManagerService;

    @GetMapping("/all")
    public ResponseEntity<?> getProjects() {
        log.info("Inicio consultar proyectos");
        try {
            List<ProjectDto> projects = projectService.getProjects();
            if (!projects.isEmpty()) {
                log.info("Exito consultando proyectos");
                return new ResponseEntity<>(ProjectMapper.buildSuccessResponse(projects), HttpStatus.OK);
            } else {
                log.info("No existen proyectos");
                return new ResponseEntity<>(ProjectMapper.buildResponseEmpty(environment.getProperty("messages.responseEmpty")), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Error consultando los proyectos, detalles: {} ", e.getCause().getMessage());
            return new ResponseEntity<>(ProjectMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.responseErrorFind")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProject(@Valid @RequestBody RequestProjectDto requestProjectDto) {
        log.info("Inicio crear proyecto");
        try {
            Date dateStart = getDates(requestProjectDto.getDateStart());
            Date dateEnd = getDates(requestProjectDto.getDateEnd());
            projectService.create(ProjectMapper.buildRequestCreateProject(requestProjectDto, dateStart, dateEnd));
            log.info("Exito creando el proyecto: {} ", requestProjectDto.getName());
            return new ResponseEntity<>(ProjectMapper.buildResponseSuccessCreate(requestProjectDto, environment.getProperty("messages.responseSuccessCreate")), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error creando el proyecto, detalles: {} ", e.getCause().getMessage());
            return new ResponseEntity<>(ProjectMapper.buildErrorResponse(GenericResponseCodes.ERROR_INTERNO_SERVIDOR,
                    HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("messages.messageResponseErrorCreate")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private Date getDates(String date) {
        return timeManagerService.getFormatDate(date);
    }
}
