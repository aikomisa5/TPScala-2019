package ejercicio2

final abstract class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  /*
   * Programar una maquina de Turing determinıstica. Para ello, implementar una clase
   * final class MaquinaTuring(transiciones: Map[(Estado, char), (Estado, char, Direccion)])
   * que tenga una funcion def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)
   * que lance el proceso de la maquina y devuelva el estado final de la maquina y la cinta.
   * Estado, Cinta, Direccion deben ser clases definidas por ustedes que representen esa idea en la maquina de Turing.
   * La maquina puede construirse en memoria, como parte del codigo de casos de test, no esnecesario leer un archivo.
   */

  /*
   * contruir cinta (con tantos casilleros)
   * llenar celdas con alfabeto
   * estado en blanco inicialmente
   * elaborar conjunto de estados finales
   * tabla de reglas de funcionamiento? Direccion?
   * unidad lectora que lee y escribe en la cinta y se mueve a la izquierda o derecha
   */

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) => {

  }

}

class Cinta {
  /*
   * esta compuesta por casilleros o celdas (o de estados?)
   */
}

class Estado {
  /*
   * estadoInicial
   * estadoFinal
   */
}

class Direccion { //trancicion
  /*
   * estado
   * simboloDeCinta
   * tupla(p, Y, D) 	p estado	Y simboloCinta	D direccion (L R)
   */
}