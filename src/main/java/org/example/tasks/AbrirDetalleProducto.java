package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.DetalleProducto.NOMBRE_PRODUCTO;

public class AbrirDetalleProducto implements Task {

    private static final Logger logger = LoggerFactory.getLogger(AbrirDetalleProducto.class);
    private String nombreProducto;

    public AbrirDetalleProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static AbrirDetalleProducto del(String nombreProducto) {
        return instrumented(AbrirDetalleProducto.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Abriendo detalle del producto: {}", nombreProducto);

        Target PRODUCTO = Target.the("Producto " + nombreProducto)
                .located(By.linkText(nombreProducto));

        actor.attemptsTo(
                Click.on(PRODUCTO),
                WaitUntil.the(NOMBRE_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
        );

        logger.info("Detalle del producto cargado: {}", nombreProducto);
    }
}