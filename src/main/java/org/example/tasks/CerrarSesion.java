package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Logout.BTN_LOGOUT;

public class CerrarSesion implements Task {

    private static final Logger logger = LoggerFactory.getLogger(CerrarSesion.class);

    public static CerrarSesion delCarrito() {
        return instrumented(CerrarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Cerrando sesión");
        actor.attemptsTo(
                Click.on(BTN_LOGOUT)
        );
        logger.info("Sesión cerrada correctamente");
    }
}
