package ejercicio2

object Main {
  def main(args: Array[String]): Unit = {
    val cinta = Cinta(List('a', 'a', 'a', 'a'))
    val estadosFinales = List(Estado("X"), Estado("Z"))

    val m1 = (Estado("A"), 'a') -> (Estado("B"), 'b', Direccion("D"))
    val m2 = (Estado("B"), 'b') -> (Estado("Z"), 'c', Direccion("D"))
    val m3 = (Estado("Z"), 'c') -> (Estado("D"), 'd', Direccion("D"))
    val m4 = (Estado("D"), 'd') -> (Estado("E"), 'e', Direccion("D"))
    val m5 = (Estado("E"), 'E') -> (Estado("Z"), 'r', Direccion("D"))
    val m = new MaquinaTuring(Map(m1, m2, m3, m4, m5))

    val tupla = (Estado("A"), cinta)
    val procesado = m.procesar(tupla, estadosFinales)

    println("procesado -> " + procesado)
  }
}