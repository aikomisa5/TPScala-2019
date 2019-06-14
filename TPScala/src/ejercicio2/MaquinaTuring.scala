package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  val t = transiciones(Estado("A"), 'a')

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    val p = cabezal((inicio._1, Cinta(List())), inicio._2, t)
    println("p " + p._2)
    p
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: (Estado, Char, Direccion)): (Estado, Cinta) = {
    //si no es estado final
    if (numElems(actual._2.cinta.toList) < numElems(cintaOriginal.cinta.toList)) {
      if (t._3 == Direccion("D")) {
        val nuevaCinta = Cinta(actual._2.cinta ::: List(t._2))
        cabezal((t._1, nuevaCinta), cintaOriginal, t)
      } else if (t._3 == Direccion("I")) {
        val nuevaCinta = Cinta(t._2 :: actual._2.cinta)
        cabezal((t._1, nuevaCinta), cintaOriginal, t)
      }
    }
    println("despues de if " + actual._2)
    return (actual._1, actual._2)
  }

  //-----------------------------------------------------------------------------------------------------------------------
  //    val nuevacinta = inicio._2
  //    def cabezal(actual: (Estado, Char)): Unit = {
  //      def estadosFinales(actual: (Estado, Char), l: List[(Estado)]): Unit = { // para reccorrer los estados finales
  //        if (!l.isEmpty) {
  //          if (!actual._1.equals(l.head)) { // si no es un estado final
  //            transiciones.keys
  //
  //          }
  //          estadosFinales(actual, l.tail)
  //        }
  //      }

  //-----------------------------------------------------------------------------------------------------------------------
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
  //    }

}

