package co.com.test.stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.example.tasks.AbrirPagina;
import org.example.tasks.AgregarProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CarritoStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CarritoStepDefinitions.class);

    private static final List<String> PRODUCTOS = Arrays.asList(
            "Samsung galaxy s6",
            "Nokia lumia 1520",
            "Sony xperia z5",
            "HTC One M9",
            "Sony vaio i5"
    );

    @Before
    public void configuracion() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario abre DemoBlaze para carrito$")
    public void abrirDemoBlaze() {
        logger.info("Abriendo DemoBlaze para carrito");
        OnStage.theActorCalled("Michael").wasAbleTo(
                AbrirPagina.demoBlaze()
        );
    }

    @Cuando("^agrega un producto al carrito$")
    public void agregarProducto() {
        String productoSeleccionado =
                PRODUCTOS.get((int) (Math.random() * PRODUCTOS.size()));

        logger.info("Agregando producto al carrito: {}", productoSeleccionado);

        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(productoSeleccionado)
        );
    }

    @Cuando("^agrega varios productos al carrito$")
    public void agregarVariosProductos() {
        logger.info("Agregando varios productos al carrito");
        for (String producto : PRODUCTOS) {
            logger.info("Agregando: {}", producto);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    AgregarProducto.alCarrito(producto)
            );
        }
    }

    @Entonces("^el producto deberia quedar agregado$")
    public void validarProducto() {
        logger.info("Validando que el producto quedó agregado");
        // Validacion pendiente
    }

    @Entonces("^todos los productos deberian quedar agregados$")
    public void validarVariosProductos() {
        logger.info("Validando que todos los productos quedaron agregados");
        // Validacion pendiente
    }
}
