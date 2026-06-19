package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionAlerta implements Question<String> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionAlerta.class);

    @Override
    public String answeredBy(Actor actor) {
        try {
            Alert alert = BrowseTheWeb.as(actor)
                    .getDriver()
                    .switchTo()
                    .alert();
            String texto = alert.getText();
            alert.accept();
            logger.info("Alerta detectada: {}", texto);
            return texto;
        } catch (Exception e) {
            logger.debug("No se encontró alerta: {}", e.getMessage());
            return "";
        }
    }

    public static ValidacionAlerta mensaje() {
        return new ValidacionAlerta();
    }
}
