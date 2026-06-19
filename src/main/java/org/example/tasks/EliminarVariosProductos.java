package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Carrito.BTN_CART;
import static org.example.userinterfaces.Carrito.BTN_DELETE;

import java.util.List;

public class EliminarVariosProductos implements Task {

    private static final Logger logger = LoggerFactory.getLogger(EliminarVariosProductos.class);
    private int cantidad;

    public EliminarVariosProductos(int cantidad) {
        this.cantidad = cantidad;
    }

    public static EliminarVariosProductos delCarrito(int cantidad) {
        return instrumented(EliminarVariosProductos.class, cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Eliminando {} productos del carrito", cantidad);
        actor.attemptsTo(Click.on(BTN_CART));

        for (int i = 0; i < cantidad; i++) {
            logger.info("Eliminando producto {} de {}", i + 1, cantidad);
            actor.attemptsTo(Click.on(BTN_DELETE));
        }

        logger.info("Todos los productos eliminados del carrito");
    }
}
