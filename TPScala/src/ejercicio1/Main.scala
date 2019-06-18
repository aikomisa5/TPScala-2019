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

      println()
      val s = "aaabacaa"
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
      if (!proximoCorrespondienteAEstado(w, tuplasTransiciones, tuplasTransiciones))
        return false
      return true
      procesar(w.tail, alf, estadosFinales, tuplasTransiciones, puntero + 1)
    }

    @annotation.tailrec
    def primeroEstadoInicialUno(w: String, tuplasTransiciones: List[(String, String, String)]): Boolean = {
      if (tuplasTransiciones.size == 0)
        return false
      if (w(0).toString().equals(tuplasTransiciones.head._2)) // si el primer elem es igual a el de la transaccion
        if (tuplasTransiciones.head._1.toString().equals(1.toString()))
          return true
      primeroEstadoInicialUno(w, tuplasTransiciones.tail)
    }

    @annotation.tailrec
    def proximoCorrespondienteAEstado(w: String, tuplaOriginal: List[(String, String, String)], tuplasTransiciones: List[(String, String, String)], charAcatual: Int = 0, estadoActual: Int = 1): Boolean = {
      if (tuplasTransiciones.size == 0)
        return false
      if (w.size == charAcatual)
        return true

      val c1 = w(charAcatual).toString().equals(tuplasTransiciones.head._2)
      val c2 = tuplasTransiciones.head._1.toString().equals(estadoActual.toString())
      def cambiarEstado(c: Boolean): List[(String, String, String)] = c match {
        case true  => tuplaOriginal.tail
        case false => tuplasTransiciones
      }

      println(w(charAcatual).toString())
      println(tuplasTransiciones.head._2)
      println(tuplasTransiciones.head._1.toString())
      println(estadoActual.toString())
      println(c1 && c2)
      println()

      proximoCorrespondienteAEstado(w, tuplaOriginal, cambiarEstado(!c1 && c2), charAcatual + 1, tuplasTransiciones.head._3.toInt)
    }

    //      def cambiarTrans(t: Boolean): List[(String, String, String)] = t match {
    //        case true  => tuplaOriginal
    //        case false => tuplasTransiciones.tail
    //      }

    //    @annotation.tailrec
    //    def proximoCorrespondienteAEstado(w: String, t: List[(String, String, String)], eActual: String = "0", destinos: List[(String)]): Boolean = {
    //      if (w.size == 0)
    //        return false
    //      val d1 = ObtenerDestinosEstado(w, t, destinos)
    //      val d2 = ObtenerDestinosEstado(w(1).toString(), t, destinos)
    //      if (d1 contains d2)
    //        return true
    //      proximoCorrespondienteAEstado(w.tail, t, "1", d1)
    //    }
    //
    //    @annotation.tailrec
    //    def ObtenerDestinosEstado(w: String, t: List[(String, String, String)], d: List[(String)]): List[(String)] = {
    //      if (t.size == 0)
    //        return d
    //      def agregarDestinos(c: Boolean): List[(String)] = c match {
    //        case true  => d ::: List(t.head._3)
    //        case false => d
    //      }
    //      ObtenerDestinosEstado(w.tail, t.tail, agregarDestinos(w.head.toString().equals(t.head._2)))
    //    }

    //    @annotation.tailrec
    //    def proximoCorrespondienteAEstado(w: String, tuplasTransiciones: List[(String, String, String)], estadoActual: String = "0"): Boolean = {
    //      println()
    //      if (tuplasTransiciones.size == 0) {
    //        return false
    //      }
    //      println("estadoActual " + w(estadoActual.toInt).toString())
    //      println("tuplahead2   " + tuplasTransiciones.head._2)
    //      if (w(estadoActual.toInt).toString().equals(tuplasTransiciones.head._2)) {
    //        println("tuplahead1   " + tuplasTransiciones.head._1.toString())
    //        println("estadoActual " + estadoActual.toString())
    //        if (!tuplasTransiciones.head._1.toString().equals(estadoActual.toString())) {
    //          println("entro")
    //          return false
    //        }
    //      }
    //      proximoCorrespondienteAEstado(w, tuplasTransiciones.tail, tuplasTransiciones.head._3)
    //    }

    //    @annotation.tailrec
    //    def proximoCorrespondienteAEstado(w: String, tuplaOriginal: List[(String, String, String)], tuplasTransiciones: List[(String, String, String)], puntero: Int = 0): Boolean = {
    //      if (tuplasTransiciones.size == 0)
    //        return false
    //      if (w.length() == puntero)
    //        return true
    //      println()
    //      val condicion = w(puntero).toString().equals(tuplasTransiciones.head._2)
    //      //      println("string      " + w(puntero).toString())
    //      //      println("cabezatupla " + tuplasTransiciones.head._2)
    //      //      println("tuplas      " + tuplasTransiciones.mkString)
    //      //      println("condicion   " + condicion)
    //      //      if (!condicion)
    //      //        return false
    //      def cambiarTrans(t: Boolean): List[(String, String, String)] = t match {
    //        case true  => tuplaOriginal
    //        case false => tuplasTransiciones.tail
    //      }
    //      def cambiarPuntero(c: Boolean): Int = c match {
    //        case true  => puntero + 1
    //        case false => puntero
    //      }
    //      proximoCorrespondienteAEstado(w, tuplaOriginal, cambiarTrans(condicion), cambiarPuntero(condicion))
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