package co.com.sofkau.api.model.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;

public class PatchRequest implements Task {

    String resource;
    Object requestBody;

    public PatchRequest(String resource, Object requestBody) {
        this.resource = resource;
        this.requestBody = requestBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(resource));
    }
    public static PatchRequest withData(String resource, Object requestBody) {
        return Tasks.instrumented(PatchRequest.class, resource, requestBody);
    }

}
