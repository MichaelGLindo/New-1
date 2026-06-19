package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionRegistro implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionRegistro.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            Alert alert = BrowseTheWeb.as(actor)
                    .getDriver()
                    .switchTo()
                    .alert();
            String texto = alert.getText();
            alert.accept();
            boolean exitoso = texto != null && texto.contains("Sign up successful");
            logger.info("Validando registro - Mensaje: {}, Exitoso: {}", texto, exitoso);
            return exitoso;
        } catch (Exception e) {
            logger.warn("No se encontró alerta de registro: {}", e.getMessage());
            return false;
        }
    }

    public static ValidacionRegistro exitoso(){
        return new ValidacionRegistro();
    }
}