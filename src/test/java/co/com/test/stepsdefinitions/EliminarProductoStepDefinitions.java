package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionCarritoVacio;
import org.example.tasks.AbrirPagina;
import org.example.tasks.AgregarProducto;
import org.example.tasks.EliminarProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class EliminarProductoStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(EliminarProductoStepDefinitions.class);

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario tiene productos en el carrito para eliminar$")
    public void agregarProductoParaEliminar() {
        logger.info("Agregando producto para eliminar");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                AgregarProducto.alCarrito("Samsung galaxy s6")
        );
    }

    @Cuando("^elimina un producto del carrito$")
    public void eliminarProducto() {
        logger.info("Eliminando producto del carrito");
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarProducto.delCarrito()
        );
    }

    @Entonces("^el producto deberia ser removido$")
    public void validarProductoEliminado() {
        logger.info("Validando que el producto fue removido");
        // Validación de que el producto fue eliminado
    }

    @Dado("^que el usuario tiene un producto en el carrito para eliminar$")
    public void agregarUnProductoParaEliminar() {
        logger.info("Agregando un producto para eliminar");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                AgregarProducto.alCarrito("Samsung galaxy s6")
        );
    }

    @Cuando("^elimina el último producto$")
    public void eliminarUltimoProducto() {
        logger.info("Eliminando último producto del carrito");
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarProducto.delCarrito()
        );
    }

    @Entonces("^el carrito debería quedar vacío$")
    public void validarCarritoVacio() {
        logger.info("Validando que el carrito quedó vacío");
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCarritoVacio.estaVacio(), equalTo(true))
        );
    }
}
