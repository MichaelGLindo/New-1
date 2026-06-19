# language: es
# author: Michael Galindo

Característica: Registro de usuario en DemoBlaze
  Como usuario nuevo
  quiero registrarme en la aplicación
  para poder acceder a mi cuenta

  @registro @exitoso
  Escenario: Registro exitoso
    Dado que el usuario abre DemoBlaze para registro
    Cuando registra usuario "usuarioNuevo" y clave "123456"
    Entonces el registro deberia ser exitoso

  @registro @usuario_existente
  Escenario: Usuario ya existe
    Dado que el usuario abre DemoBlaze para registro
    Cuando registra usuario "testfijo123" y clave "123456"
    Entonces deberia visualizar el mensaje de error "This user already exist."