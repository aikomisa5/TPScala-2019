package ejercicio2

object Main {
  def main(args: Array[String]): Unit = {
    val cinta= Cinta(List("hola","como","estas"))
    printf(cinta.cinta.head)
  }
}