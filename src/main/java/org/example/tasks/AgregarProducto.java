package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Carrito.BTN_ADD_CART;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AgregarProducto implements Task {

    private String producto;

    public AgregarProducto(String producto) {
        this.producto = producto;
    }

    public static AgregarProducto alCarrito(String producto) {
        return instrumented(AgregarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target PRODUCTO = Target.the("Producto")
                .located(By.linkText(producto));

        actor.attemptsTo(
                Click.on(PRODUCTO),
                Click.on(BTN_ADD_CART)
        );

        try {
            Thread.sleep(2000);

            BrowseTheWeb.as(actor)
                    .getDriver()
                    .switchTo()
                    .alert()
                    .accept();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}