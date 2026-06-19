package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.userinterfaces.Registro.*;

public class RegistrarUsuario implements Task {

    private static final Logger logger = LoggerFactory.getLogger(RegistrarUsuario.class);
    private String usuario;
    private String clave;

    public RegistrarUsuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static RegistrarUsuario conDatos(String usuario, String clave) {
        return instrumented(RegistrarUsuario.class, usuario, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Registrando usuario: {}", usuario);
        actor.attemptsTo(
                Click.on(BTN_SIGNUP),
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_REGISTRAR)
        );
        logger.info("Registro completado para usuario: {}", usuario);
    }
}