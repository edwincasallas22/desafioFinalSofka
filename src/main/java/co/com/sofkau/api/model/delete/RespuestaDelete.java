package co.com.sofkau.api.model.delete;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaDelete {
    private String dataId;
    private String message;
}
