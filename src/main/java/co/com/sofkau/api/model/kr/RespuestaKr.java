package co.com.sofkau.api.model.kr;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaKr {
    private String dataId;
    private String message;
}
