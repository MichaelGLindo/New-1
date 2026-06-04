package co.com.test.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.tasks.AbrirPagina;
import org.example.tasks.AgregarProducto;
import org.example.tasks.ComprarProducto;

public class CompraStepDefinitions {

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para compra$")
    public void abrirDemoBlaze() {

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^compra un producto$")
    public void comprarProducto() {

        String[] productos = {
                "Samsung galaxy s6",
                "Nokia lumia 1520",
                "Sony xperia z5"
        };

        String productoSeleccionado =
                productos[(int) (Math.random() * productos.length)];

        System.out.println("Producto seleccionado: " + productoSeleccionado);

        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(productoSeleccionado),
                ComprarProducto.finalizarCompra()
        );
    }

    @Entonces("^la compra deberia ser exitosa$")
    public void validarCompra() {

    }
}