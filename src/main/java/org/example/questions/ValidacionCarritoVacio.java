package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionCarritoVacio implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionCarritoVacio.class);

    @Override
    public Boolean answeredBy(Actor actor) {

        String texto = BrowseTheWeb.as(actor)
                .getDriver()
                .findElement(By.id("totalp"))
                .getText();

        boolean vacio = texto.trim().isEmpty() || texto.equals("0");
        logger.info("Validando carrito vacío - Total: {}, Vacío: {}", texto, vacio);

        return vacio;
    }

    public static ValidacionCarritoVacio estaVacio() {
        return new ValidacionCarritoVacio();
    }
}