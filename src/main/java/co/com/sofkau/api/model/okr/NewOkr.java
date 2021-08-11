package co.com.sofkau.api.model.okr;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewOkr {
    private String objective;
    private String title;
    private String managerId;
    private String verticalId;
}
