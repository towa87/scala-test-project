package codilitytasks

import scala.collection.immutable.Queue

object FirstUnique
  { def solution(a: Array[Int]): Int  ={
    def find(i:Int, q:Queue[Int],s:Set[Int]):Int ={
      if(i==a.length)  (if(q.isEmpty) -1 else q.head)
      else if (!q.contains(a(i)) && !s.contains(a(i))) find(1+i,q.enqueue(a(i)),s)
      else  find(1+i,q.filter(e=>e!=a(i)),s+(a(i)))
    }
   if (a.isEmpty) -1 else find( 0,Queue.empty,Set.empty)
  }}
