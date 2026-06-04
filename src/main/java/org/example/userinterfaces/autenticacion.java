package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class autenticacion {

    public static final Target BOTON_LOGIN =
            Target.the("Boton Login")
                    .located(By.id("login2"));

    public static final Target CAMPO_USUARIO =
            Target.the("Campo Usuario")
                    .located(By.id("loginusername"));

    public static final Target CAMPO_CLAVE =
            Target.the("Campo Clave")
                    .located(By.id("loginpassword"));

    public static final Target BOTON_INGRESAR =
            Target.the("Boton Ingresar")
                    .located(By.xpath("//button[contains(text(),'Log in')]"));

    public static final Target LABEL_USUARIO =
            Target.the("Usuario logueado")
                    .located(By.id("nameofuser"));
}