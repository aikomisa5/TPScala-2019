package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  //  val t = transiciones(Estado("A"), 'a')

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    cabezal((inicio._1, Cinta(List())), inicio._2, transiciones(Estado("A"), 'a'))
  }

  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: (Estado, Char, Direccion)): (Estado, Cinta) = {
    if (actual._1.e != new Estado("F")) {
      if (numElems(actual._2.cinta.toList) < numElems(cintaOriginal.cinta.toList)) {
        if (t._3 == Direccion("D")) {
          val nuevaCinta = Cinta(actual._2.cinta ::: List(t._2))
          cabezal((t._1, nuevaCinta), cintaOriginal, t)
        } else if (t._3 == Direccion("I")) {
          val nuevaCinta = Cinta(t._2 :: actual._2.cinta)
          cabezal((t._1, nuevaCinta), cintaOriginal, t)
        }
      } else {
        println("entro en else. Retornar -> " + actual)
        return actual
      }
    }
    println("abajo -> " + actual)
    (Estado("C"), Cinta(List('c')))
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

