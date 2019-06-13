package ejercicio2

object Main {
  def main(args: Array[String]): Unit = {
    val cinta= Cinta(List('a','a','a','a'))
    printf(cinta.cinta.head.toString())
  }
}