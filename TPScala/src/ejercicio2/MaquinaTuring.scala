package ejercicio2

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]) {

  def procesar(inicio: (Estado, Cinta), estadosFinales: List[(Estado)]): (Estado, Cinta) = {
    val cantElementosCinta = numElems(inicio._2.cinta.toList)
    cabezal((inicio._1, Cinta(List())), inicio._2, transiciones, estadosFinales) //(inicio._1, Cinta(List(inicio._2.cinta(1))))
  }

  @annotation.tailrec
  def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: Map[(ejercicio2.Estado, Char), (ejercicio2.Estado, Char, ejercicio2.Direccion)], estadosFinales: List[(Estado)], punteroEstado: Int = 0): (Estado, Cinta) = {
    println("actual - " + actual)
    if (t.size == 0) {
      println("\nretorno por vacio - " + t)
      return actual
    }
    val c = punteroEstado <= estadosFinales.size - 1
    if (c) {
      println(actual._1)
      println(estadosFinales(punteroEstado))
      println(actual._1 == estadosFinales(punteroEstado))
      if (actual._1 == estadosFinales(punteroEstado)) {
        println("\nencontro estado final")
        return actual
      }
    }
    def cambiarPuntero(c: Boolean): Int = c match {
      case true  => punteroEstado + 1
      case false => 0
    }
    def cambiarActual(c: Boolean): (Estado, Cinta) = c match {
      case true  => actual
      case false => (t.head._2._1, izqOrDer(t.head._2._3))
    }
    def cambiarTrans(c: Boolean): Map[(ejercicio2.Estado, Char), (ejercicio2.Estado, Char, ejercicio2.Direccion)] = c match {
      case true  => t
      case false => t.tail
    }
    def izqOrDer(dir: Direccion): Cinta = dir match {
      case Direccion("D") => Cinta(actual._2.cinta ::: List(t.head._2._2))
      case Direccion("I") => Cinta(t.head._2._2 :: actual._2.cinta)
    }
    cabezal(cambiarActual(c), cintaOriginal, cambiarTrans(c), estadosFinales, cambiarPuntero(c))
  }

  def numElems(l: List[Char]): Int =
    if (l == Nil) 0 else 1 + numElems(l.tail)

}

