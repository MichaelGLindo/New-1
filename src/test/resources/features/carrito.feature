# language: es
# author: Michael Galindo

Característica: Agregar producto al carrito en DemoBlaze
  Como usuario logueado
  quiero agregar productos al carrito
  para poder realizar una compra

  @carrito @agregar
  Escenario: Agregar un producto
    Dado que el usuario abre DemoBlaze para carrito
    Cuando agrega un producto al carrito
    Entonces el producto deberia quedar agregado

  @carrito @agregar_varios
  Escenario: Agregar varios productos
    Dado que el usuario abre DemoBlaze para carrito
    Cuando agrega varios productos al carrito
    Entonces todos los productos deberian quedar agregados
