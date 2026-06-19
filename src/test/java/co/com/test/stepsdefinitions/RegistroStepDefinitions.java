package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionAlerta;
import org.example.questions.ValidacionRegistro;
import org.example.tasks.AbrirPagina;
import org.example.tasks.RegistrarUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class RegistroStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(RegistroStepDefinitions.class);

    // Usuario fijo que ya existe en DemoBlaze (registralo manualmente una vez)
    private static final String USUARIO_EXISTENTE = "testfijo123";
    private static final String CLAVE = "123456";

    // Usuario único por timestamp para el escenario de registro exitoso
    private static final String USUARIO_NUEVO = "user_" + System.currentTimeMillis();

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para registro$")
    public void abrirDemoBlaze() {
        logger.info("Abriendo DemoBlaze para registro");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^registra usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void registrarUsuario(String usuario, String clave) {
        // Si viene "usuarioNuevo" del feature, lo reemplaza por uno con timestamp
        String usuarioFinal = usuario.equals("usuarioNuevo") ? USUARIO_NUEVO : usuario;
        logger.info("Registrando usuario: {}", usuarioFinal);
        // Si viene "testfijo123" del feature, usa el fijo
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarUsuario.conDatos(usuarioFinal, clave)
        );
    }

    @Entonces("^el registro deberia ser exitoso$")
    public void validarRegistro() {
        logger.info("Validando registro exitoso");
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionRegistro.exitoso(), equalTo(true))
        );
    }

    @Entonces("^deberia visualizar el mensaje de error \"([^\"]*)\"$")
    public void validarMensajeError(String mensajeEsperado) {
        logger.info("Validando mensaje de error: {}", mensajeEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionAlerta.mensaje(), containsString(mensajeEsperado))
        );
    }
}