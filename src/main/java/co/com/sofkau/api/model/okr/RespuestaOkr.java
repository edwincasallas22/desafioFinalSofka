package co.com.sofkau.api.model.okr;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaOkr {
    private String dataId;
    private String message;

}
