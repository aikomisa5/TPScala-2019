package test

class testMaquinaTuring extends UnitSpec {
  val cinta = ejercicio2.Cinta(List('a', 'a', 'a', 'a'))
  val estadosFinales = List(ejercicio2.Estado("X"), ejercicio2.Estado("Z"))

  val m1 = (ejercicio2.Estado("A"), 'a') -> (ejercicio2.Estado("B"), 'b', ejercicio2.Direccion("D"))
  val m2 = (ejercicio2.Estado("B"), 'b') -> (ejercicio2.Estado("Z"), 'c', ejercicio2.Direccion("D"))
  val m3 = (ejercicio2.Estado("Z"), 'c') -> (ejercicio2.Estado("D"), 'd', ejercicio2.Direccion("D"))
  val m4 = (ejercicio2.Estado("D"), 'd') -> (ejercicio2.Estado("E"), 'e', ejercicio2.Direccion("D"))
  val m5 = (ejercicio2.Estado("E"), 'E') -> (ejercicio2.Estado("Z"), 'r', ejercicio2.Direccion("D"))
  val m = new ejercicio2.MaquinaTuring(Map(m1, m2, m3, m4, m5))

  val tupla = (ejercicio2.Estado("A"), cinta)
  val procesado = m.procesar(tupla, estadosFinales)

  println("procesado -> " + procesado)
  it should "el procesar debe dar false por no ser estado inicial" in {
    assert(procesado.toString().equals("(Estado(Z),Cinta(List(a, r)))"))
  }
}