package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetalleProducto {

    public static final Target NOMBRE_PRODUCTO =
            Target.the("Nombre del producto")
                    .located(By.cssSelector("h2.name"));

    public static final Target PRECIO_PRODUCTO =
            Target.the("Precio del producto")
                    .located(By.cssSelector("h3.price-container"));

    public static final Target DESCRIPCION_PRODUCTO =
            Target.the("Descripcion del producto")
                    .located(By.id("more-information"));
}
