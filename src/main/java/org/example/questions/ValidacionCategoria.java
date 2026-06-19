package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ValidacionCategoria implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionCategoria.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElement> productos = BrowseTheWeb.as(actor)
                .getDriver()
                .findElements(By.cssSelector(".card-title"));

        boolean tieneProductos = productos.size() > 0;
        logger.info("Validando categoría - Productos encontrados: {}, Tiene productos: {}", productos.size(), tieneProductos);

        return tieneProductos;
    }

    public static ValidacionCategoria muestraProductos() {
        return new ValidacionCategoria();
    }
}
