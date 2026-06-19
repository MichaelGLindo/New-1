package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.autenticacion.*;

public class Autenticarse implements Task {

    private static final Logger logger = LoggerFactory.getLogger(Autenticarse.class);
    private String usuario;
    private String clave;

    public Autenticarse(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static Autenticarse conCredenciales(String usuario,String clave){
        return instrumented(Autenticarse.class,usuario,clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Autenticando usuario: {}", usuario);
        actor.attemptsTo(

                Click.on(BOTON_LOGIN),

                Enter.theValue(usuario)
                        .into(CAMPO_USUARIO),

                Enter.theValue(clave)
                        .into(CAMPO_CLAVE),

                Click.on(BOTON_INGRESAR)
        );
        logger.info("Autenticación completada para: {}", usuario);
    }
}