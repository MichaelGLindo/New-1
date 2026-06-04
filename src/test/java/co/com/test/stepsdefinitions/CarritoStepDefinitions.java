package co.com.test.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.tasks.AbrirPagina;
import org.example.tasks.AgregarProducto;

public class CarritoStepDefinitions {

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para carrito$")
    public void abrirDemoBlaze() {

        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^agrega un producto al carrito$")
    public void agregarProducto() {

        String[] productos = {
                "Samsung galaxy s6",
                "Nokia lumia 1520",
                "Sony xperia z5",
                "HTC One M9",
                "Sony vaio i5"
        };

        String productoSeleccionado =
                productos[(int) (Math.random() * productos.length)];

        System.out.println("Producto seleccionado: " + productoSeleccionado);

        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(productoSeleccionado)
        );
    }

    @Entonces("^el producto deberia quedar agregado$")
    public void validarProducto() {

    }
}