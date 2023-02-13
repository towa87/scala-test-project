package codilitytasks

object ParityDegree {
  def solution(n: Int): Int = {
    def calculatePower(acc:Int,n:Int): Int = {
    if (n%2 ==1) acc else calculatePower(acc+1,n/2)
  }
  calculatePower(0,n)
  }
}

