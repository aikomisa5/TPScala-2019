package ejercicio2

/*
 * Programar una maquina de Turing determinıstica. Para ello, implementar una clase
 * final class MaquinaTuring(transiciones: Map[(Estado, char), (Estado, char, Direccion)])
 * que tenga una funcion def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)
 * que lance el proceso de la maquina y devuelva el estado final de la maquina y la cinta.
 * Estado, Cinta, Direccion deben ser clases definidas por ustedes que representen esa idea en la maquina de Turing.
 * La maquina puede construirse en memoria, como parte del codigo de casos de test, no esnecesario leer un archivo.
 */
  final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

    // lance el proceso de la maquina y devuelva el estado final de la maquina y la cinta.
    // unidad lectora que lee y escribe en la cinta y se mueve a la izquierda o derecha
    def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
      // encargado de escribir símbolos en la cinta y mover la cinta a la izquierda o a la derecha (siempre una celda a la vez)

      val actual= inicio
      def cabezal(): Unit = {
        if(!Estado.esEstadoFinal){
          if(Direccion.direccion.equals("D"){ //si la direccion es derecha
            Cinta.cinta= Nil :: Estado
            // moverse
            cabezal()
          }
          else { //direccion izq
            Cinta.cinta= Estado :: Nil
            moverse
            cabezal()
          }
        }
        else actual
      }
    }

  }

