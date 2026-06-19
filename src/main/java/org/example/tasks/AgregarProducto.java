package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.Carrito.BTN_ADD_CART;

public class AgregarProducto implements Task {

    private static final Logger logger = LoggerFactory.getLogger(AgregarProducto.class);
    private String producto;

    public AgregarProducto(String producto) {
        this.producto = producto;
    }

    public static AgregarProducto alCarrito(String producto) {
        return instrumented(AgregarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        logger.info("Navegando a DemoBlaze para agregar producto: {}", producto);

        BrowseTheWeb.as(actor)
                .getDriver()
                .navigate()
                .to("https://www.demoblaze.com");

        Target PRODUCTO = Target.the("Producto " + producto)
                .located(By.linkText(producto));

        actor.attemptsTo(
                WaitUntil.the(PRODUCTO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PRODUCTO)
        );

        logger.info("Producto seleccionado, agregando al carrito...");

        actor.attemptsTo(
                WaitUntil.the(BTN_ADD_CART, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_ADD_CART)
        );

        WebDriverWait wait = new WebDriverWait(
                BrowseTheWeb.as(actor).getDriver(),
                Duration.ofSeconds(10)
        );

        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        logger.info("Alerta confirmación: {}", alert.getText());

        alert.accept();

        logger.info("Producto agregado exitosamente al carrito");
    }
}