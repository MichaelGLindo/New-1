package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Compra.*;
import static org.example.userinterfaces.Carrito.BTN_CART;

public class ComprarProducto implements Task {

    public static ComprarProducto finalizarCompra(){
        return instrumented(ComprarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(BTN_CART),

                Click.on(BTN_PLACE_ORDER),

                Enter.theValue("Michael").into(TXT_NOMBRE),
                Enter.theValue("Colombia").into(TXT_PAIS),
                Enter.theValue("Bogota").into(TXT_CIUDAD),
                Enter.theValue("123456").into(TXT_TARJETA),
                Enter.theValue("06").into(TXT_MES),
                Enter.theValue("2026").into(TXT_ANIO),

                Click.on(BTN_PURCHASE)
        );
    }
}