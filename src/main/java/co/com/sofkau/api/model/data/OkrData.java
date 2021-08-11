package co.com.sofkau.api.model.data;


import co.com.sofkau.api.model.kr.NewKr;
import co.com.sofkau.api.model.okr.NewOkr;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;

public class OkrData {
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());

    public static NewOkr getNewOkr() {
        return NewOkr.builder()
                .objective(faker.name().fullName())
                .title(faker.name().fullName())
                .managerId(faker.name().fullName())
                .verticalId(faker.name().fullName())
                .build();

    }
    public static  NewKr getNewKr(){
        return NewKr.builder()
                .idOkr("abcd")
                .managerName("Edd")
                .managerEmail("edwin@gamil.com")
                .startDate("2020/08/05")
                .endDate("2020/08/08")
                .loadValue(10)
                .title("probando")
                .description("lorep ipsum")
                .progress(10)
                .build();
    }

}
