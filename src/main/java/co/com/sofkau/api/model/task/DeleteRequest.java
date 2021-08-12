package co.com.sofkau.api.model.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteRequest implements Task {
    String resource;

    public DeleteRequest(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(resource));
    }
    public static DeleteRequest withResource(String resource){
        return Tasks.instrumented(DeleteRequest.class, resource);
    }

}
