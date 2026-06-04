package co.com.test.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionLogin;
import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepsDefinitions {

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para login$")
    public void abrirDemoBlaze() {

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^ingresa usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void login(String usuario, String clave) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(usuario, clave)
        );
    }

    @Entonces("^deberia visualizar el mensaje de bienvenida$")
    public void validarLogin() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidacionLogin.exitoso(),
                        containsString("Welcome")
                )
        );
    }
}