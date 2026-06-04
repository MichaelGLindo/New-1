# language: es
# author: Michael Galindo

Característica: Inicio de sesión en DemoBlaze
  Como usuario registrado
  quiero iniciar sesión en la aplicación
  para poder acceder a mi cuenta

  @autenticacion
  Escenario: Login exitoso
    Dado que el usuario abre DemoBlaze para login
    Cuando ingresa usuario "MichaelG" y clave "1023970970."
    Entonces deberia visualizar el mensaje de bienvenida

