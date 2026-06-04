#language: es
# author: Michael Galindo

Característica: Registro usuario

  Escenario: Registro exitoso

    Dado que el usuario abre DemoBlaze para registro
    Cuando registra usuario "usuarioNuevo" y clave "123456"
    Entonces el registro deberia ser exitoso