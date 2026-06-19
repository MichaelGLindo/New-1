package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionCompra implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionCompra.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String texto = BrowseTheWeb.as(actor)
                    .getDriver()
                    .findElement(By.cssSelector(".sweet-alert h2"))
                    .getText();

            boolean exitosa = texto != null && texto.contains("Thank you for your purchase!");
            logger.info("Validando compra - Mensaje: {}, Exitosa: {}", texto, exitosa);
            return exitosa;
        } catch (Exception e) {
            logger.warn("No se encontró mensaje de confirmación de compra: {}", e.getMessage());
            return false;
        }
    }

    public static ValidacionCompra exitosa(){
        return new ValidacionCompra();
    }
}