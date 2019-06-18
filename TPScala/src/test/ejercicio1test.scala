package test

class ejercicio1test extends UnitSpec {

  val m1 = ejercicio1.Main.procesar("aaabaa", "abcd", List("1", "2", "3"), List(("1", "a", "3"), ("3", "b", "1"), ("1", "a", "4")))
  println("procesar1: " + m1)
  it should "el procesar debe dar true " in {
    assert(m1 == true)
  }

  val m2 = ejercicio1.Main.procesar("aaabaca", "abcd", List("1", "2", "3"), List(("1", "a", "3"), ("3", "b", "1"), ("1", "a", "4")))
  println("procesar2: " + m2)
  it should "el procesar debe dar false " in {
    assert(m2 == false)
  }

  val m3 = ejercicio1.Main.procesar("ac", "abcd", List("1", "2", "3"), List(("1", "a", "3"), ("3", "b", "1"), ("1", "a", "4")))
  println("procesar3: " + m3)
  it should "el procesar debe dar false por no ser estado final" in {
    assert(m3 == false)
  }

  val m4 = ejercicio1.Main.procesar("caaa", "abcd", List("1", "2", "3"), List(("1", "a", "3"), ("3", "b", "1"), ("1", "a", "4")))
  println("procesar4: " + m4)
  it should "el procesar debe dar false por no ser estado inicial" in {
    assert(m4 == false)
  }
}