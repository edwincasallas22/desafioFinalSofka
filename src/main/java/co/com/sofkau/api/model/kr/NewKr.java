package co.com.sofkau.api.model.kr;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewKr {
    private String idOkr;
    private String managerName;
    private String managerEmail;
    private String startDate;
    private String endDate;
    private Integer loadValue;
    private String title;
    private String description;
    private Integer progress;
}
