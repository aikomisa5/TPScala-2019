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

      procesar("Fifito")

      //      pruebaSplit()
      //
      //      val tuplas = obtenerTransicionesEnTuplas(lines)
      //      recorrerString(tuplas, "El valor del elemento es: ")
      //      tuplas.foreach(f => println("El valor del elemento es: " + f))

    } catch {
      case _: Throwable => println("Ha ocurrido un error al intentar leer el archivo .txt")
    } finally {

    }

    def recorrerListaString(w: Array[String], mensaje: String, puntero: Int = 0): Unit = {
      if (w.size > 0) {
        println(mensaje + w.head)
        recorrerListaString(w.tail, mensaje, puntero + 1)
      }
    }

    def procesar(w: String): Boolean = {
      val info = (5, "Juan", false)
      val info2 = info.copy(info._1, info._2, info._3)
      println("Info 2: " + info2)
      true
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

    //    def obtenerTransicionesEnTuplas(transiciones: List[String], tuplas: List[(String, String, String, Boolean)] = List[(String, String, String, Boolean)](), puntero: Int = 0): List[(String, String, String, Boolean)] = {
    //      println("Paso x aca 1")
    //      println("Valor del puntero: " + puntero)
    //      val text = "1, a -> 3"
    //      val words = text.split("[,-]>? ?")
    //
    //      if (puntero >= 3 && !transiciones.isEmpty) {
    //        println("Paso x aca 2")
    //        val array = transiciones.head.split(" ?[,-]>? ?")
    //        println("Paso x aca a")
    //        array.foreach(f => println("Elemento: " + f))
    //        val tuplasAux = tuplas :+ ((array(0), array(1), array(2), false))
    //        println("Paso x aca b")
    //        obtenerTransicionesEnTuplas(transiciones.tail, tuplasAux, puntero + 1)
    //
    //      } else if (puntero >= 3 && transiciones.isEmpty) {
    //        println("Paso x aca 3")
    //        tuplas
    //      } else {
    //        println("Paso x aca 4")
    //        obtenerTransicionesEnTuplas(transiciones.tail, tuplas, puntero + 1)
    //      }
    //
    //      //val a : List[(String,String,String,Boolean)] = List()
    //      //val b = a:+(("x","y","z",true))
    //
    //    }
    //
    //    def pruebaSplit(): Unit = {
    //
    //      //val text = "s: saturday, sunday, solar, selfie";
    //      //val words = text.split("[:,] ");
    //
    //      val text = "1, a -> 3";
    //      val words = text.split("[,-]>? ?")
    //
    //      words.foreach(f => println("Elemento del array: " + f))
    //
    //    }

    //    def proceso(cadena: String): Boolean = {
    //      val lines = Source.fromFile("automata.txt").getLines.toList
    //      val tuplas = obtenerTransicionesEnTuplas(lines)
    //
    //      //procesoRecursivo("1", cadena, tuplas)
    //      true
    //    }

    /*
    def procesoRecursivo(estadoActual : String, cadena : String, transicionesTuplas : List[(String,String,String,Boolean)]) : Boolean = {
      val b = false

      cadena.foreach(f=>{
        b = b + false
      })

      true
    }

    */

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