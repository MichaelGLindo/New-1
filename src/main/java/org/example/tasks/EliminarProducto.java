package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Carrito.BTN_CART;
import static org.example.userinterfaces.Carrito.BTN_DELETE;

public class EliminarProducto implements Task {

    public static EliminarProducto delCarrito() {
        return instrumented(EliminarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CART),
                Click.on(BTN_DELETE)
        );
    }
}