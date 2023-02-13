package codilitytasks

import scala.annotation.tailrec

object BinaryGap {
  def solution(n: Int): Int = {

    def calculations(binaryValues: Vector[Int], intValue: Int, binaryGap: (Int, Int)): Int = {
      if (intValue >= 1) {
        val reminder = intValue % 2
        val updatedBinaryGap = if (binaryValues.contains(1)) {
          reminder match {
            case 1 => (binaryGap._1, 0)
            case 0 => {
              val tempBinaryGap = (binaryGap._2 + 1)
              if (binaryGap._1 < tempBinaryGap) (tempBinaryGap, tempBinaryGap)
              else (binaryGap._1, tempBinaryGap)
            }
          }
        } else binaryGap
        calculations(binaryValues :+ reminder, (intValue - reminder) / 2, updatedBinaryGap)
      }
      else if (intValue.equals(1)) {
        binaryGap._1
      }
      else if (binaryValues.size.equals(binaryGap._1)) 0 else
        binaryGap._1
    }

    calculations(Vector.empty, n, (0, 0))
  }

  def solve(n: Int): Int = {
    val input_seq =
      Integer.toBinaryString(n).zipWithIndex.filter(_._1 == '1').map(_._2)
    getGep(input_seq, input_seq.size - 1, 0)
  }

  @tailrec
  def getGep(input_seq: IndexedSeq[Int], idx: Int, gap: Int): Int = {
    if (idx == 0) {
      if (gap == 0) 0 else gap - 1
    } else {
      val now_gap = input_seq(idx) - input_seq(idx - 1)
      if (now_gap > gap) getGep(input_seq, idx - 1, now_gap)
      else getGep(input_seq, idx - 1, gap)
    }
  }

}
