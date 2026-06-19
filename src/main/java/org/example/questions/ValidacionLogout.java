package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.userinterfaces.autenticacion.LABEL_USUARIO;

public class ValidacionLogout implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionLogout.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        Question<String> textoQuestion = Text.of(LABEL_USUARIO);
        String texto = textoQuestion.answeredBy(actor);
        boolean logoutExitoso = texto == null || texto.isEmpty();
        logger.info("Validando logout - Sesión cerrada: {}", logoutExitoso);
        return logoutExitoso;
    }

    public static ValidacionLogout exitoso() {
        return new ValidacionLogout();
    }
}