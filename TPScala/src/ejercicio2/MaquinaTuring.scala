//package ejercicio2
//
//  final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {
//
//    // lance el proceso de la maquina y devuelva el estado final de la maquina y la cinta.
//    // unidad lectora que lee y escribe en la cinta y se mueve a la izquierda o derecha
//    def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
//      val actual= inicio
//    	// encargado de escribir símbolos en la cinta y mover la cinta a la izquierda o a la derecha (siempre una celda a la vez)
//      def cabezal(actual: (Estado, Char)): Unit = {
//        if(!Estado.esEstadoFinal){ //entra al loop siempre que no sea un estado final
//          if(Direccion.direccion.equals("D")){ //si la direccion es derecha
//            Cinta.cinta lista= Nil :: Estado //agregar el estado a la derecha
//            // moverse (modifica el actual)
//            cabezal(actual, lista)
//          }
//          else { //direccion izq
//            Cinta.cinta= Estado :: Nil //agregar el estado a la izq
//            //moverse (modifica el actual)
//            cabezal(actual, lista)
//          }
//        }
//        else actual
//      }
//    }
//
//  }
//
