package ejercicio2

object Main {
  def main(args: Array[String]): Unit = {
    val cinta = Cinta(List('a', 'a', 'a', 'a'))
    val estadosFinales = List(Estado("X"), Estado("Z"))

    val m = new MaquinaTuring(Map((Estado("A"), 'a') -> (Estado("Z"), 'b', Direccion("D"))))

    val tupla = (Estado("A"), cinta)
    val procesado = m.procesar(tupla, estadosFinales)

    println("procesado -> " + procesado)
  }
}