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
                .objective("Prueba QA EDWIN")
                .title("Otro Okr mas")
                .managerId("abcde")
                .verticalId("abcde")
                .build();

    }
    public static  NewKr getNewKr(){
        return NewKr.builder()
                .idOkr("abcd")
                .managerName("Edwin")
                .managerEmail("edwin@gamil.com")
                .startDate("2020/08/05")
                .endDate("2020/08/08")
                .loadValue(10)
                .title("probando")
                .description("lorep ipsum")
                .progress(77)
                .build();
    }

}
