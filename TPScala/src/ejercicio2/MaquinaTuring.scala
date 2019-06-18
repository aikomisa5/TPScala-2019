package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  //  val t = transiciones(Estado("A"), 'a')

  def procesar(inicio: (Estado, Cinta), estadosFinales: List[(Estado)]): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    cabezal((inicio._1, Cinta(List(inicio._2.cinta(1)))), inicio._2, transiciones, estadosFinales)
  }

  @annotation.tailrec
  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: Map[(ejercicio2.Estado, Char), (ejercicio2.Estado, Char, ejercicio2.Direccion)], estadosFinales: List[(Estado)], intEst: Int = 0): (Estado, Cinta) = {
    if (intEst < cintaOriginal.cinta.size) {
      if (estadosFinales.size > intEst) {
        if (actual._1 == estadosFinales(intEst)) {
          println("encontro estado final")
          return actual
        }
      }
    }
    println()
    def izqOrDer(dir: Direccion): Cinta = dir match {
      case Direccion("D") => Cinta(actual._2.cinta ::: List(t.head._2._2))
      case Direccion("I") => Cinta(t.head._2._2 :: actual._2.cinta)
    }
    println("actual " + actual.toString())
    if (t.tail.isEmpty) {
      println("retorno por vacio")
      return actual
    }
    cabezal((t.head._2._1, izqOrDer(t.head._2._3)), cintaOriginal, t.tail, estadosFinales, intEst + 1)
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

