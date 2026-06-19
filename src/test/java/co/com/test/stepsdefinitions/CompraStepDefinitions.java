package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionAlerta;
import org.example.questions.ValidacionCompra;
import org.example.questions.ValidacionMensajeCompra;
import org.example.tasks.AbrirPagina;
import org.example.tasks.AgregarProducto;
import org.example.tasks.ComprarProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import java.util.Arrays;
import java.util.List;

public class CompraStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CompraStepDefinitions.class);

    private static final List<String> PRODUCTOS = Arrays.asList(
            "Samsung galaxy s6",
            "Nokia lumia 1520",
            "Sony xperia z5"
    );

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario tiene productos en el carrito$")
    public void agregarProductosAlCarrito() {
        String productoSeleccionado =
                PRODUCTOS.get((int) (Math.random() * PRODUCTOS.size()));
        logger.info("Agregando producto al carrito para compra: {}", productoSeleccionado);

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                AgregarProducto.alCarrito(productoSeleccionado)
        );
    }

    @Cuando("^realiza el proceso de compra$")
    public void realizarCompra() {
        logger.info("Iniciando proceso de compra");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ComprarProducto.finalizarCompra()
        );
    }

    @Cuando("^se muestra la confirmación$")
    public void mostrarConfirmacion() {
        logger.info("Esperando confirmación de compra");
        // La confirmacion se muestra automaticamente
    }

    @Cuando("^compra un producto$")
    public void comprarProducto() {
        String productoSeleccionado =
                PRODUCTOS.get((int) (Math.random() * PRODUCTOS.size()));
        logger.info("Comprando producto: {}", productoSeleccionado);

        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(productoSeleccionado),
                ComprarProducto.finalizarCompra()
        );
    }

    @Entonces("^la compra deberia ser exitosa$")
    public void validarCompra() {
        logger.info("Validando que la compra fue exitosa");
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCompra.exitosa(), equalTo(true))
        );
    }

    @Entonces("^deberia visualizar el mensaje \"([^\"]*)\"$")
    public void validarMensajeConfirmacion(String mensajeEsperado) {
        logger.info("Validando mensaje de confirmación: {}", mensajeEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionMensajeCompra.confirmacion(), containsString(mensajeEsperado))
        );
    }

    @Dado("^que el usuario completa la compra$")
    public void completarCompra() {
        String productoSeleccionado =
                PRODUCTOS.get((int) (Math.random() * PRODUCTOS.size()));
        logger.info("Completando compra con producto: {}", productoSeleccionado);

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                AgregarProducto.alCarrito(productoSeleccionado),
                ComprarProducto.finalizarCompra()
        );
    }
}
