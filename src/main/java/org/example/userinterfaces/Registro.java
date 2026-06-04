package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registro {

    public static final Target BTN_SIGNUP =
            Target.the("Boton Sign Up")
                    .located(By.id("signin2"));

    public static final Target TXT_USUARIO =
            Target.the("Usuario")
                    .located(By.id("sign-username"));

    public static final Target TXT_CLAVE =
            Target.the("Clave")
                    .located(By.id("sign-password"));

    public static final Target BTN_REGISTRAR =
            Target.the("Registrar")
                    .located(By.xpath("//button[contains(text(),'Sign up')]"));
}