# language: es
# author: Michael Galindo

Característica: Validación de detalles del producto en DemoBlaze
  Como usuario
  quiero ver los detalles de un producto
  para verificar su información antes de comprar

  @detalle @abrir
  Escenario: Abrir detalle de producto
    Dado que el usuario abre DemoBlaze
    Cuando selecciona un producto de la lista
    Entonces deberia visualizar la página de detalles

  @detalle @validar
  Escenario: Validar nombre y precio
    Dado que el usuario abre el detalle de un producto
    Cuando se carga la información del producto
    Entonces deberia visualizar el nombre y precio correctos
