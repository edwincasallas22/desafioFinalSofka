package screenplay.steps;

import co.com.sofkau.api.model.data.OkrData;
import co.com.sofkau.api.model.kr.RespuestaKr;
import co.com.sofkau.api.model.okr.NewOkr;
import co.com.sofkau.api.model.okr.RespuestaOkr;
import co.com.sofkau.api.model.task.PostRequest;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;

public class OkrSteps {

    Actor actor = Actor.named("EdwinQA");
    EnvironmentVariables variables;
    @Before
    public void setup() {
        actor.whoCan(CallAnApi.at(variables.getProperty("baseurl")));
    }

    @Cuando("se tiene la informacion de un nuevo OKR para crearlo")
    public void seTieneLaInformacionDeUnNuevoOKRParaCrearlo() {
        actor.attemptsTo(PostRequest.withData(variables.getProperty("pathUser"), OkrData.getNewOkr()));
    }

    @Entonces("se crea un OKR exitosamente")
    public void seCreaUnOKRExitosamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(201)));

        RespuestaOkr respuestaOkr = SerenityRest.lastResponse()
                .jsonPath().getObject("", RespuestaOkr.class);
        assertThat(respuestaOkr).hasNoNullFieldsOrProperties();
        SerenityRest.lastResponse().print();
    }

    @Cuando("se tiene la informacion de un nuevo KR para crearlo")
    public void seTieneLaInformacionDeUnNuevoKRParaCrearlo() {
        actor.attemptsTo(PostRequest.withData(variables.getProperty("pathUserKr"), OkrData.getNewKr()));

    }

    @Entonces("se crea un KR exitosamente")
    public void seCreaUnKRExitosamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(201)));
        RespuestaKr respuestaKr = SerenityRest.lastResponse().jsonPath().getObject("", RespuestaKr.class);
        assertThat(respuestaKr).hasNoNullFieldsOrProperties();
        SerenityRest.lastResponse().print();
    }
}
