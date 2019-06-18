package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  def procesar(inicio: (Estado, Cinta), estadosFinales: List[(Estado)]): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    cabezal((inicio._1, Cinta(List())), inicio._2, transiciones, estadosFinales) //(inicio._1, Cinta(List(inicio._2.cinta(1))))
  }

  @annotation.tailrec
  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: Map[(ejercicio2.Estado, Char), (ejercicio2.Estado, Char, ejercicio2.Direccion)], estadosFinales: List[(Estado)], punteroEstado: Int = 0): (Estado, Cinta) = {
    if (t.size == 0) {
      println("retorno por vacio - " + t)
      return actual
    }

    println("actual              - " + actual._1.toString())
    println("estadosFinales.size - " + estadosFinales.size)
    println("punteroEstado       - " + punteroEstado)
    if (punteroEstado <= estadosFinales.size - 1) {
      println("estadoFinal         - " + estadosFinales(punteroEstado))
      println(actual._1)
      if (actual._1 == estadosFinales(punteroEstado)) {
        println("\nencontro estado final")
        return actual
      }
    }

    def izqOrDer(dir: Direccion): Cinta = dir match {
      case Direccion("D") => Cinta(actual._2.cinta ::: List(t.head._2._2))
      case Direccion("I") => Cinta(t.head._2._2 :: actual._2.cinta)
    }
    cabezal((t.head._2._1, izqOrDer(t.head._2._3)), cintaOriginal, t.tail, estadosFinales, punteroEstado + 1)
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

