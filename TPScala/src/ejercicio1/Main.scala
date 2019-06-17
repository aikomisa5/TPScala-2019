package ejercicio1

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

    try {
      val lines = Source.fromFile("automata.txt").getLines.toList
      imprimirAutomata(lines)

      val alfabeto = obtenerAlfabeto(lines)
      recorrerListaString(alfabeto, "elemento del string: ")

      val cantidadEstado = obtenerCantidadEstados(lines)
      println("La cantidad de estados es: " + cantidadEstado)

      val estadosFinales = obtenerEstadosFinales(lines)
      recorrerListaString(estadosFinales, "Estado final: ")

      val tuplas = obtenerTransicionesEnTuplas(lines)
      recorrerListaTuplas(tuplas.toList, "Transisiones: ")

      println()
      val s = "d"
      println(s + " pertenece al lenguaje: " + procesar(s, alfabeto.mkString))

    } catch {
      case _: Throwable => println("Ha ocurrido un error al intentar leer el archivo .txt")
    } finally {

    }

    def recorrerListaString(w: Array[String], mensaje: String): Unit = {
      if (w.size > 0) {
        println(mensaje + w.head)
        recorrerListaString(w.tail, mensaje)
      }
    }

    def recorrerListaTuplas(w: List[(String, String, String)], mensaje: String): Unit = {
      if (w.size > 0) {
        println(mensaje + w.head)
        recorrerListaTuplas(w.drop(1), mensaje)
      }
    }

    @annotation.tailrec
    def procesar(w: String, alf: String): Boolean = {
      if (w.size == 0)
        return false
      else if (perteneceAlAlfabetoDeInput(w.head, alf))
        return true
      procesar(w.tail, alf)
    }

    @annotation.tailrec
    def perteneceAlAlfabetoDeInput(w: Char, alf: String): Boolean = {
      if (alf.size == 0)
        return false
      else if (alf.head.toString().equals(w.toString()))
        return true
      perteneceAlAlfabetoDeInput(w, alf.tail)
    }

    @annotation.tailrec
    def imprimirAutomata[A](l: List[A]): Unit = {
      if (!l.isEmpty) {
        println(l.head)
        imprimirAutomata(l.tail)
      }
    }

    def obtenerAlfabeto(lista: List[String]): Array[String] = {
      lista.head.split(", ")
    }

    @annotation.tailrec
    def obtenerEstadosFinales(lista: List[String], puntero: Int = 0): Array[String] = {
      if (puntero == 2)
        lista.head.split(", ")
      else
        obtenerEstadosFinales(lista.tail, puntero + 1)
    }

    @annotation.tailrec
    def obtenerCantidadEstados(lista: List[String], puntero: Int = 0): String = {
      if (puntero == 1)
        lista.head
      else
        obtenerCantidadEstados(lista.tail, puntero + 1)
    }

    def obtenerTransicionesEnTuplas(transiciones: List[String], tuplas: List[(String, String, String)] = List[(String, String, String)](), puntero: Int = 0): List[(String, String, String)] = {
      if (puntero >= 3 && !transiciones.isEmpty) {
        val array = transiciones.head.split(" ?[,-]>? ?")
        val tuplasAux = tuplas :+ ((array(0), array(1), array(2)))
        obtenerTransicionesEnTuplas(transiciones.tail, tuplasAux, puntero + 1)
      } else if (puntero >= 3 && transiciones.isEmpty) {
        tuplas
      } else {
        obtenerTransicionesEnTuplas(transiciones.tail, tuplas, puntero + 1)
      }
    }

    //    def seEncuentraEnAlgunaTransicion(c: Char, estadoActual: String): Boolean = {
    //      val lines = Source.fromFile("automata.txt").getLines.toList
    //      val tuplas = obtenerTransicionesEnTuplas(lines)
    //
    //      tuplas.foreach(f => {
    //        if (f._2 == c && f._1 == estadoActual) {
    //          true
    //        }
    //
    //      })
    //
    //      false
    //    }

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