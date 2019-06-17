package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  //  val t = transiciones(Estado("A"), 'a')

  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    cabezal((inicio._1, Cinta(List())), inicio._2, transiciones(Estado("A"), 'a'))
  }

  @annotation.tailrec
  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: (Estado, Char, Direccion)): (Estado, Cinta) = {
    if (actual._1.e == new Estado("F"))
      return actual
    if (numElems(actual._2.cinta.toList) == numElems(cintaOriginal.cinta.toList))
      return actual
    def izqOrDer(dir: Direccion): Cinta = dir match {
      case Direccion("D") => Cinta(actual._2.cinta ::: List(t._2))
      case Direccion("I") => Cinta(t._2 :: actual._2.cinta)
    }
    cabezal((t._1, izqOrDer(t._3)), cintaOriginal, t)
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

