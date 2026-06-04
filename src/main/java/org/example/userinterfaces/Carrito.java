package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Carrito {

    public static final Target PRODUCTO =
            Target.the("Producto Samsung")
                    .located(By.linkText("Samsung galaxy s6"));

    public static final Target BTN_ADD_CART =
            Target.the("Agregar carrito")
                    .located(By.linkText("Add to cart"));

    public static final Target BTN_CART =
            Target.the("Carrito")
                    .located(By.id("cartur"));

    public static final Target BTN_DELETE =
            Target.the("Eliminar producto")
                    .located(By.linkText("Delete"));
}