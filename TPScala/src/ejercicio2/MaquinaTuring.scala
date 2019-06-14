package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  val t = transiciones(Estado("A"), 'a')

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    val p = cabezal((inicio._1, Cinta(List())), inicio._2, t)
    println("p " + p._2)
    p
  }

  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: (Estado, Char, Direccion)): (Estado, Cinta) = {
    if (actual._1.e != new Estado("F")) {
      println("elementos cinta nueva " + numElems(actual._2.cinta.toList) +" elementos cinta original "+ numElems(cintaOriginal.cinta.toList))
      if (numElems(actual._2.cinta.toList) < numElems(cintaOriginal.cinta.toList)) {
        if (t._3 == Direccion("D")) {
          println("entro der")
          val nuevaCinta = Cinta(actual._2.cinta ::: List(t._2))
          cabezal((t._1, nuevaCinta), cintaOriginal, t)
        } else if (t._3 == Direccion("I")) {
          println("entro izq")
          val nuevaCinta = Cinta(t._2 :: actual._2.cinta)
          cabezal((t._1, nuevaCinta), cintaOriginal, t)
        }
      } else println("Salir del loop")
    }
    println("despues de if " + actual._2)
    actual
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

