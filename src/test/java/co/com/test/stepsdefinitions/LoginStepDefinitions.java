package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionAlerta;
import org.example.questions.ValidacionLogin;
import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(LoginStepDefinitions.class);

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para login$")
    public void abrirDemoBlaze() {
        logger.info("Abriendo DemoBlaze para login");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^ingresa usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void login(String usuario, String clave) {
        logger.info("Ingresando credenciales - Usuario: {}", usuario);
        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(usuario, clave)
        );
    }

    @Entonces("^deberia visualizar el mensaje de bienvenida$")
    public void validarLogin() {
        logger.info("Validando mensaje de bienvenida");
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidacionLogin.exitoso(),
                        containsString("Welcome")
                )
        );
    }

    @Entonces("^deberia visualizar el mensaje de error de login \"([^\"]*)\"$")
    public void validarMensajeError(String mensajeEsperado) {
        logger.info("Validando mensaje de error: {}", mensajeEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionAlerta.mensaje(), containsString(mensajeEsperado))
        );
    }
}