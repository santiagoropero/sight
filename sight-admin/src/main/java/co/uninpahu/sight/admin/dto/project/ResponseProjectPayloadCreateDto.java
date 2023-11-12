package co.uninpahu.sight.admin.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseProjectPayloadCreateDto implements Serializable {
    private String name;
    private String client;
    private String person;
    private String startDate;
    private String endDate;
    private String state;

}
