package co.com.test.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionRegistro;
import org.example.tasks.AbrirPagina;
import org.example.tasks.RegistrarUsuario;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RegistroStepDefinitions {

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para registro$")
    public void abrirDemoBlaze() {

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^registra usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void registrarUsuario(String usuario, String clave) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarUsuario.conDatos(usuario, clave)
        );
    }

    @Entonces("^el registro deberia ser exitoso$")
    public void validarRegistro() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionRegistro.exitoso())
        );
    }
}