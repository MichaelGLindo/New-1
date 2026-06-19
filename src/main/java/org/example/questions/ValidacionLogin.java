package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.userinterfaces.autenticacion.LABEL_USUARIO;

public class ValidacionLogin implements Question<String> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionLogin.class);

    @Override
    public String answeredBy(Actor actor) {
        Question<String> textoQuestion = Text.of(LABEL_USUARIO);
        String texto = textoQuestion.answeredBy(actor);

        logger.info("Validando login - Usuario visible: [{}]", texto);

        return texto;
    }

    public static ValidacionLogin exitoso() {
        return new ValidacionLogin();
    }
}