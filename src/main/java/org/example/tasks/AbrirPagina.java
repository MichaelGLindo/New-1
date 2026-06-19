package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.userinterfaces.Inicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPagina implements Task {

    private static final Logger logger = LoggerFactory.getLogger(AbrirPagina.class);
    private Inicio inicio;

    public static AbrirPagina demoBlaze() {
        return instrumented(AbrirPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Abriendo DemoBlaze");
        actor.attemptsTo(
                Open.browserOn(inicio)
        );
    }
}