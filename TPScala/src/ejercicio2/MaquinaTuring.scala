package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
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
    inicio
  }

}

