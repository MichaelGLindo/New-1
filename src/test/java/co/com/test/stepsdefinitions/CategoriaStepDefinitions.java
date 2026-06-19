package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionCategoria;
import org.example.tasks.AbrirPagina;
import org.example.tasks.NavegarCategoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoriaStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaStepDefinitions.class);

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze$")
    public void abrirDemoBlaze() {
        logger.info("Abriendo DemoBlaze para categorías");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^selecciona la categoría \"([^\"]*)\"$")
    public void seleccionarCategoria(String categoria) {
        logger.info("Seleccionando categoría: {}", categoria);
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarCategoria.a(categoria)
        );
    }

    @Entonces("^deberia visualizar la lista de (.*?)$")
    public void validarCategoria(String tipo) {
        logger.info("Validando lista de productos de categoría: {}", tipo);
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCategoria.muestraProductos(), equalTo(true))
        );
    }
}
