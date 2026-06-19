package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionLogout;
import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;
import org.example.tasks.CerrarSesion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LogoutStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(LogoutStepDefinitions.class);

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario ha iniciado sesión en DemoBlaze$")
    public void usuarioLogueado() {
        logger.info("Iniciando sesión en DemoBlaze");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                Autenticarse.conCredenciales("MichaelG", "1023970970.")
        );
    }

    @Cuando("^presiona el botón de cerrar sesión$")
    public void cerrarSesion() {
        logger.info("Presionando botón de cerrar sesión");
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarSesion.delCarrito()
        );
    }

    @Entonces("^deberia cerrarse la sesión correctamente$")
    public void validarLogout() {
        logger.info("Validando cierre de sesión");
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionLogout.exitoso(), equalTo(true))
        );
    }
}
