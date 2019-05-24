import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

    try {
      val lines = Source.fromFile("automata.txt").getLines.toList
      imprimir(lines)

      val alfabeto = obtenerAlfabeto(lines)
      println(alfabeto.foreach((c: String) => println("Elemento del alfabeto: " + c)))
      
      val cantidadEstado = obtenerCantidadEstados(lines)
      println("La cantidad de estados es: " + cantidadEstado)
      
      val estadosFinales = obtenerEstadosFinales(lines)
      println(estadosFinales.foreach((c: String) => println("Estado final: " + c)))

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

    def obtenerAlfabeto(lista: List[String]): Array[String] = {
      //Hago un split del string ubicado en el head de la lista del alfabeto
      val alfa = lista.head.split(", ")

      //Retorno alfa
      alfa
    }
    
    @annotation.tailrec
    def obtenerEstadosFinales(lista: List[String], puntero: Int = 0): Array[String] = {
      if (puntero == 2)
        lista.head.split(", ")
      else
        obtenerEstadosFinales(lista.tail, puntero+1)
    }
    
    @annotation.tailrec
    def obtenerCantidadEstados(lista: List[String], puntero: Int = 0): String = {
      if (puntero == 1)
        lista.head
      else
        obtenerCantidadEstados(lista.tail, puntero+1)
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
  }

}