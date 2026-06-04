package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.example.userinterfaces.autenticacion.LABEL_USUARIO;

public class ValidacionLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return Text.of(LABEL_USUARIO)
                .viewedBy(actor)
                .asString();
    }

    public static ValidacionLogin exitoso(){
        return new ValidacionLogin();
    }
}