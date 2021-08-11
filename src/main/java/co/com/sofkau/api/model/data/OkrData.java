package co.com.sofkau.api.model.data;


import co.com.sofkau.api.model.okr.NewOkr;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;

public class OkrData {
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());

    public static NewOkr getNewUser() {
        return NewOkr.builder()
                .objective(faker.name().fullName())
                .title(faker.name().fullName())
                .managerId(faker.name().fullName())
                .verticalId(faker.name().fullName())
                .build();

    }
}
