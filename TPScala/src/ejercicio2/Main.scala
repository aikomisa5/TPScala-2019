package ejercicio2

object Main {
  def main(args: Array[String]): Unit = {
    val cinta= Cinta(List('a','a','a','a'))
    printf(cinta.cinta.head.toString())
    val estadosFinales= List(Estado("X"),Estado("Z"))
    
    val m= MaquinaTuring((Estado("A"), 'b'), (Estado("A"), 'b', Direccion("D"))) 
  }
}