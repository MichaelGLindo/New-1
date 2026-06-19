# language: es
# author: Michael Galindo

Característica: Eliminar producto del carrito en DemoBlaze
  Como usuario con productos en el carrito
  quiero eliminar un producto
  para gestionar mi carrito de compras

  @carrito @eliminar
  Escenario: Eliminar un producto
    Dado que el usuario tiene productos en el carrito para eliminar
    Cuando elimina un producto del carrito
    Entonces el producto deberia ser removido

  @carrito @carrito_vacio
  Escenario: Carrito vacío después de eliminar
    Dado que el usuario tiene un producto en el carrito para eliminar
    Cuando elimina el último producto
    Entonces el carrito debería quedar vacío
