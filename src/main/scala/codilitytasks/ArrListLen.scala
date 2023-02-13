package codilitytasks

object ArrListLen {
  def solutionWithList(a: Array[Int]): Int = {
    def finder(remainingList: List[Int],index:Int): Int = {
      if(remainingList.last.equals(-1)) remainingList.size else
        finder(remainingList:+(a(index)), a(index))}
    finder(List(a(0)),0)
  }

  def solution(a: Array[Int]): Int = {
    def finder(acc: Int, index: Int): Int = {
      if (a(index).equals(-1)) acc + 1 else
        finder(acc + 1, a(index))
    }
    finder(1, a(0))
  }
}