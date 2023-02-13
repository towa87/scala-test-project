package codilitytasks

object CountConformingBitmasks {
  def count(d: Int) = {
    scala.math.pow(2, (0 until  30).map(index=> if (((d >> index) & 1) == 0 ) 1 else 0).sum).asInstanceOf[Int]
  }
  def solution(a: Int, b: Int, c: Int): Int = {
   List(a, b, c).map(count).sum- count(a | c) - count(b | c) - count(b | a) + count(a | c | b)
}
}

