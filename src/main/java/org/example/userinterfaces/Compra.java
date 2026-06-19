package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Compra {

    public static final Target BTN_PLACE_ORDER =
            Target.the("Place Order")
                    .located(By.xpath("//button[contains(text(),'Place Order')]"));

    public static final Target TXT_NOMBRE =
            Target.the("Nombre")
                    .located(By.id("name"));

    public static final Target TXT_PAIS =
            Target.the("Pais")
                    .located(By.id("country"));

    public static final Target TXT_CIUDAD =
            Target.the("Ciudad")
                    .located(By.id("city"));

    public static final Target TXT_TARJETA =
            Target.the("Tarjeta")
                    .located(By.id("card"));

    public static final Target TXT_MES =
            Target.the("Mes")
                    .located(By.id("month"));

    public static final Target TXT_ANIO =
            Target.the("Año")
                    .located(By.id("year"));

    public static final Target BTN_PURCHASE =
            Target.the("Comprar")
                    .located(By.xpath("//button[contains(text(),'Purchase')]"));

    public static final Target MENSAJE_CONFIRMACION =
            Target.the("mensaje de confirmacion")
                    .located(By.xpath("//div[contains(@class,'sweet-alert')]//h2"));
}