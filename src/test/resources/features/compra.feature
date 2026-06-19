# language: es
# author: Michael Galindo

Característica: Realizar compra en DemoBlaze
  Como usuario con productos en el carrito
  quiero completar la compra
  para adquirir los productos seleccionados

  @compra @exitosa
  Escenario: Compra exitosa
    Dado que el usuario tiene productos en el carrito
    Cuando realiza el proceso de compra
    Entonces la compra deberia ser exitosa

  @compra @confirmacion
  Escenario: Validar mensaje de confirmación
    Dado que el usuario completa la compra
    Cuando se muestra la confirmación
    Entonces deberia visualizar el mensaje "Thank you for your purchase!"
