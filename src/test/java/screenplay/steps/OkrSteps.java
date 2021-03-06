package screenplay.steps;

import co.com.sofkau.api.model.data.OkrData;
import co.com.sofkau.api.model.delete.RespuestaDelete;
import co.com.sofkau.api.model.get.OkrWithKr;
import co.com.sofkau.api.model.kr.RespuestaKr;
import co.com.sofkau.api.model.okr.NewOkr;
import co.com.sofkau.api.model.okr.RespuestaOkr;
import co.com.sofkau.api.model.task.DeleteRequest;
import co.com.sofkau.api.model.task.GetRequest;
import co.com.sofkau.api.model.task.PatchRequest;
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

    @Cuando("se tiene la informacion de un KR para eliminar")
    public void seTieneLaInformacionDeUnKRParaEliminar() {
        actor.attemptsTo(DeleteRequest.withResource(variables.getProperty("pathDelete").concat("61147bbe6bffc40015cf1b52")));

    }

    @Entonces("se elimino un KR exitosamente")
    public void seEliminoUnKRExitosamente() {

        actor.should(seeThatResponse("ver el código de respuesta", response -> response.statusCode(201)));
        SerenityRest.lastResponse().print();
        RespuestaDelete respuestaDelete = SerenityRest.lastResponse().jsonPath().getObject("", RespuestaDelete.class);
        assertThat(respuestaDelete).hasNoNullFieldsOrProperties();

    }


    @Cuando("se tiene la informacion de un OKR para eliminar")
    public void seTieneLaInformacionDeUnOKRParaEliminar() {
        actor.attemptsTo(DeleteRequest.withResource(variables.getProperty("pathDeleteOKR").concat("6115daae01fb6d0016b166f0")));
    }

    @Entonces("se elimino un OKR exitosamente")
    public void seEliminoUnOKRExitosamente() {
        actor.should(seeThatResponse("ver el código de respuesta", response -> response.statusCode(201)));
        SerenityRest.lastResponse().print();
        RespuestaDelete respuestaDelete = SerenityRest.lastResponse().jsonPath().getObject("", RespuestaDelete.class);
        assertThat(respuestaDelete).hasNoNullFieldsOrProperties();
    }

    @Cuando("se tiene la informacion para llamar a un OKR y sus OKR's")
    public void seTieneLaInformacionParaLlamarAUnOKRYSusOKRS() {
        actor.attemptsTo(GetRequest.withResource(variables.getProperty("pathGet").concat("611573c2a2605b535bfab39a")));
    }

    @Entonces("se llama exitosamente el OKR con sus KR's")
    public void seLlamaExitosamenteElOKRConSusKRS() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        SerenityRest.lastResponse().print();
        OkrWithKr[] okrWithKrs = SerenityRest.lastResponse()
                .jsonPath().getObject("data", OkrWithKr[].class);
      /*  for (int i = 0; i < okrWithKrs.length; i++) {
            assertThat(okrWithKrs[i]).hasNoNullFieldsOrProperties();
       }*/
    }
}
