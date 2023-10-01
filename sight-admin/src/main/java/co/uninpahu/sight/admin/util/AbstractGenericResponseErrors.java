package co.uninpahu.sight.admin.util;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AbstractGenericResponseErrors implements Serializable {
    private String errorDetail;
}
