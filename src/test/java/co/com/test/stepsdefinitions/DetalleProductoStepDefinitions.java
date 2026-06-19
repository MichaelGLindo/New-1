package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.questions.ValidacionDetalleProducto;
import org.example.tasks.AbrirPagina;
import org.example.tasks.AbrirDetalleProducto;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DetalleProductoStepDefinitions {

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre el detalle de un producto$")
    public void abrirDetalleProducto() {
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze(),
                AbrirDetalleProducto.del("Samsung galaxy s6")
        );
    }

    @Cuando("^selecciona un producto de la lista$")
    public void seleccionarProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AbrirDetalleProducto.del("Samsung galaxy s6")
        );
    }

    @Cuando("^se carga la información del producto$")
    public void cargarInformacion() {
        // Espera a que la pagina cargue
    }

    @Entonces("^deberia visualizar la página de detalles$")
    public void validarPaginaDetalle() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidacionDetalleProducto.tieneNombreYPrecio(),
                        equalTo(true)
                )
        );
    }

    @Entonces("^deberia visualizar el nombre y precio correctos$")
    public void validarNombreYPrecio() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionDetalleProducto.tieneNombreYPrecio(), equalTo(true))
        );
    }
}
