package co.uninpahu.sight.admin.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseProjectPayloadAllDto implements Serializable {
    private List<ProjectDto> projects;
}
