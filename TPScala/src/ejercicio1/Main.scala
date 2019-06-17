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

      val tuplasTransiciones = obtenerTransicionesEnTuplas(lines)
      recorrerListaTuplas(tuplasTransiciones.toList, "Transiciones: ")

      val s = "dababa"
      println(s + " pertenece al lenguaje: " + procesar(s, alfabeto.mkString, estadosFinales.toList, tuplasTransiciones))

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
    def procesar(w: String, alf: String, estadosFinales: List[(String)], tuplasTransiciones: List[(String, String, String)], puntero: Int = 0): Boolean = {
      if (w.size == 0)
        return false
      if (!perteneceAlAlfabetoDeInput(w.head, alf))
        return false
      if (!ultimoElemEstadoFinal(w, estadosFinales, tuplasTransiciones))
        return false
      if (!primeroEstadoInicialUno(w, tuplasTransiciones))
        return false
      //      if (!proximoCorrespondienteAEstado(w, tuplasTransiciones))
      //        return false
      return true
      procesar(w.tail, alf, estadosFinales, tuplasTransiciones, puntero + 1)
    }

    @annotation.tailrec
    def primeroEstadoInicialUno(w: String, tuplasTransiciones: List[(String, String, String)]): Boolean = {
      println()
      if (tuplasTransiciones.size == 0)
        return false
      if (w(0).toString().equals(tuplasTransiciones.head._2)) // si el primer elem es igual a el de la transaccion
        if (tuplasTransiciones.head._1.toString().equals(1.toString()))
          println("retornar false")
      return true
      primeroEstadoInicialUno(w, tuplasTransiciones.tail)
    }

    @annotation.tailrec
    def proximoCorrespondienteAEstado(w: String, tuplasTransiciones: List[(String, String, String)], puntero: Int = 0): Boolean = {
      if (tuplasTransiciones.size == 0)
        return false
      if (w.length() == puntero)
        return true
      println()
      val condicion = w(puntero).toString().equals(tuplasTransiciones.head._2)
      println("w puntero   " + w(puntero).toString())
      println("cabezatupla " + tuplasTransiciones.head._2)
      println("condicion   " + condicion)
      //      if (!condicion)
      //        return false
      def cambiarTrans(t: Boolean): List[(String, String, String)] = t match {
        case true  => tuplasTransiciones
        case false => tuplasTransiciones.tail
      }
      def cambiarPuntero(c: Boolean): Int = c match {
        case true  => puntero + 1
        case false => puntero
      }
      proximoCorrespondienteAEstado(w, cambiarTrans(condicion), cambiarPuntero(condicion))
    }

    //    @annotation.tailrec
    //    def cabezal(actual: (Estado, Cinta), cintaOriginal: Cinta, t: (Estado, Char, Direccion)): (Estado, Cinta) = {
    //      if (actual._1.e == new Estado("F"))
    //        return actual
    //      if (numElems(actual._2.cinta.toList) == numElems(cintaOriginal.cinta.toList))
    //        return actual
    //      def izqOrDer(dir: Direccion): Cinta = dir match {
    //        case Direccion("D") => Cinta(actual._2.cinta ::: List(t._2))
    //        case Direccion("I") => Cinta(t._2 :: actual._2.cinta)
    //      }
    //      cabezal((t._1, izqOrDer(t._3)), cintaOriginal, t)
    //    }

    @annotation.tailrec
    def ultimoElemEstadoFinal(w: String, estadoFinal: List[(String)], tuplasTransiciones: List[(String, String, String)]): Boolean = {
      if (tuplasTransiciones.size == 0)
        return false
      if (w(w.length() - 1).toString().equals(tuplasTransiciones.head._2))
        if (estadoFinal.filter(_.equals(tuplasTransiciones.head._3)) != List())
          return true
      ultimoElemEstadoFinal(w, estadoFinal, tuplasTransiciones.tail)
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
  }

}