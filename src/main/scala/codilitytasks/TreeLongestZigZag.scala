package codilitytasks

object TreeLongestZigZag {
  class Tree {
    var x = 0
    var l: Tree = null
    var r: Tree = null
  }

 case  class Turn(left:Boolean,right:Boolean, tempAmount:Int,longestZigZag: Int)
  def solution(t: Tree): Int = {

    def calculation(t: Tree, turn:Turn): Int = {
      val  left =  if (t.l == (null)) turn.longestZigZag else calculation(t.l, if(turn.right) Turn(true,false, turn.tempAmount +1, if(turn.tempAmount +1>turn.longestZigZag)turn.tempAmount +1 else turn.longestZigZag) else Turn(true,false, turn.tempAmount, turn.longestZigZag))

   val right = if (t.r == (null)) turn.longestZigZag else calculation(t.r, if(turn.left) Turn(false,true, turn.tempAmount +1, if(turn.tempAmount +1>turn.longestZigZag)turn.tempAmount +1 else turn.longestZigZag) else Turn(false,true, turn.tempAmount, turn.longestZigZag))
      left.max(right)
    }
   calculation(t,Turn(false,false,0,0))
  }

}
