package org.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Categoria {

    public static Target categoriaPorNombre(String nombre) {
        return Target.the("Categoria " + nombre)
                .located(By.linkText(nombre));
    }

    public static final Target LISTA_PRODUCTOS =
            Target.the("Lista de productos")
                    .located(By.cssSelector(".card-title"));
}
