package codilitytasks

import scala.annotation.unused

object StrSymmetryPoint {
  def solution(s: String): Int = {

  if (s.length == 1) 0 else {
    var center = Math.floor(s.length / 2).toInt

    val left = s.substring(0, center)

    val right = s.substring(center, s.length).reverse
    if (left == right) center else -1
  }
  }
}

