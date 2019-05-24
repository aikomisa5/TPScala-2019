import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

    try {
      val lines = Source.fromFile("automata.txt").getLines.toList
      imprimir(lines)

      val alfabeto = obtenerAlfabeto(lines)
      print(alfabeto.foreach((c: String) => println("Elemento del alfabeto: " + c)))

    } catch {
      case _: Throwable => println("Ha ocurrido un error al intentar leer el archivo .txt")
    } finally {

    }

    @annotation.tailrec
    def imprimir[A](l: List[A]): Unit = {
      if (!l.isEmpty) {
        println(l.head)
        imprimir(l.tail)
      }
    }

    /*
    def verificarInput (input : String): Boolean = {

    }

    def recursionInput (input : String, i : Int): Boolean = {
      if (i == 0) {
        false
      }
      else{
        recursionInput()
    }

    }
    */

    def obtenerAlfabeto(s: List[String]): Array[String] = {

      //Hago un split del string ubicado en el head de la lista del alfabeto
      val alfa = s.head.split(", ")

      //Retorno alfa
      alfa

    }
  }

}