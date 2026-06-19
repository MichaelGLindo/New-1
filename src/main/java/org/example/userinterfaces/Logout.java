package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logout {

    public static final Target BTN_LOGOUT =
            Target.the("Boton Logout")
                    .located(By.id("logout2"));

    public static final Target LABEL_USUARIO =
            Target.the("Usuario logueado")
                    .located(By.id("nameofuser"));
}
