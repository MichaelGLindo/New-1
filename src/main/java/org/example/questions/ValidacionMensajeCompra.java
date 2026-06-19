package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.example.userinterfaces.Compra.MENSAJE_CONFIRMACION;

public class ValidacionMensajeCompra implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MENSAJE_CONFIRMACION)
                .answeredBy(actor);
    }

    public static ValidacionMensajeCompra confirmacion() {
        return new ValidacionMensajeCompra();
    }
}