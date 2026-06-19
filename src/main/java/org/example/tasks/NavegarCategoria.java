package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.userinterfaces.Categoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarCategoria implements Task {

    private static final Logger logger = LoggerFactory.getLogger(NavegarCategoria.class);
    private String nombreCategoria;

    public NavegarCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public static NavegarCategoria a(String nombreCategoria) {
        return instrumented(NavegarCategoria.class, nombreCategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Navegando a categoría: {}", nombreCategoria);
        actor.attemptsTo(
                Click.on(Categoria.categoriaPorNombre(nombreCategoria))
        );
        logger.info("Navegación a categoría completada: {}", nombreCategoria);
    }
}
