#language: es
Característica: Servicio POST crear OKR

  Escenario: Creacion exitosa de un OKR
  Cuando se tiene la informacion de un nuevo OKR para crearlo
  Entonces se crea un OKR exitosamente

  Escenario: Creacion exitosa de un KR
    Cuando se tiene la informacion de un nuevo KR para crearlo
    Entonces se crea un KR exitosamente

  Escenario: Eliminacion exitosa de un KR
    Cuando se tiene la informacion de un KR para eliminar
    Entonces se elimino un KR exitosamente

  Escenario: Eliminacion exitosa de un OKR
    Cuando se tiene la informacion de un OKR para eliminar
    Entonces se elimino un OKR exitosamente

  Escenario: Llamado exitoso de los OKR's con sus KR's de un usuario
    Cuando se tiene la informacion para llamar a un OKR y sus OKR's
    Entonces se llama exitosamente el OKR con sus KR's
