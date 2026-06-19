package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.example.userinterfaces.DetalleProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionDetalleProducto implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionDetalleProducto.class);

    @Override
    public Boolean answeredBy(Actor actor) {

        String nombre = Text.of(DetalleProducto.NOMBRE_PRODUCTO)
                .answeredBy(actor);

        String precio = Text.of(DetalleProducto.PRECIO_PRODUCTO)
                .answeredBy(actor);

        boolean valido = nombre != null
                && !nombre.trim().isEmpty()
                && precio != null
                && !precio.trim().isEmpty();

        logger.info("Validando detalle producto - Nombre: {}, Precio: {}, Válido: {}", nombre, precio, valido);

        return valido;
    }

    public static Question<Boolean> tieneNombreYPrecio() {
        return new ValidacionDetalleProducto();
    }
}