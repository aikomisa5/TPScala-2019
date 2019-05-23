import scala.io.Source

object Main {
  def main (args: Array[String]): Unit = {

    try {
      val lines = Source.fromFile("C:/Users/PC/Desktop/automata.txt").getLines.toList
      imprimir(lines)
      
      print("Luego de ejecutar obtenerAlfabeto: " + obtenerAlfabeto(lines))

      //println(input.charAt(1))

    }
    catch{
      case _: Throwable => println ("Ha ocurrido un error al intentar leer el archivo .txt")
    }
    finally{

    }

    //lines.foreach( (c: String) => println(c) )
    @annotation.tailrec
    def imprimir[A](l: List[A]): Unit = {
      if (!l.isEmpty){
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
        val alfa = s.head.split(",")
        
        alfa.foreach((c: String) => if (c.equals("a"))print("Match!: " + c))
        
        alfa
        
        
    }
    



  }

  
}