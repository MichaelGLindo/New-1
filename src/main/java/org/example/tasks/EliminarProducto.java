package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.Carrito.BTN_CART;
import static org.example.userinterfaces.Carrito.BTN_DELETE;

public class EliminarProducto implements Task {

    private static final Logger logger = LoggerFactory.getLogger(EliminarProducto.class);

    public static EliminarProducto delCarrito() {
        return instrumented(EliminarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        logger.info("Preparando para eliminar producto del carrito");

        // Cerrar alerta si quedó abierta
        try {
            BrowseTheWeb.as(actor)
                    .getDriver()
                    .switchTo()
                    .alert()
                    .accept();
            logger.info("Alerta previa cerrada");
        } catch (Exception e) {
            logger.debug("No había alerta abierta");
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_CART, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CART)
        );

        logger.info("Carrito abierto, eliminando producto...");

        actor.attemptsTo(
                WaitUntil.the(BTN_DELETE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_DELETE)
        );

        logger.info("Producto eliminado del carrito");
    }
}