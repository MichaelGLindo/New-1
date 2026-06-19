# language: es
# author: Michael Galindo

Característica: Navegación por categorías en DemoBlaze
  Como usuario
  quiero navegar por las categorías
  para explorar productos por tipo

  @categorias @phones
  Escenario: Categoría Phones
    Dado que el usuario abre DemoBlaze
    Cuando selecciona la categoría "Phones"
    Entonces deberia visualizar la lista de phones

  @categorias @laptops
  Escenario: Categoría Laptops
    Dado que el usuario abre DemoBlaze
    Cuando selecciona la categoría "Laptops"
    Entonces deberia visualizar la lista de laptops
