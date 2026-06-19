# language: es
# author: Michael Galindo

Característica: Cierre de sesión en DemoBlaze
  Como usuario logueado
  quiero cerrar sesión
  para salir de mi cuenta de forma segura

  @logout @exitoso
  Escenario: Logout exitoso
    Dado que el usuario ha iniciado sesión en DemoBlaze
    Cuando presiona el botón de cerrar sesión
    Entonces deberia cerrarse la sesión correctamente
