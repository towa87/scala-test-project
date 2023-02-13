package codilitytasks

import scala.collection.immutable.Queue


object CountBoundedSlices {

  def apply(k:Int, a:Array[Int]):Int = {
    def calculation(i: Int, queue: Queue[Int], acc: Int): Int = {
      if(a.length-i<1||1000000000== acc)acc else {
  if (queue.nonEmpty && Math.abs(a(i) - queue.last) > k) calculation(i+1,Queue(a(i)),acc+1)
      else  {
     val updatedQ = queue.dropWhile(j => (Math.abs(a(i) - j) > k)).enqueue(a(i))
     calculation(i+1,updatedQ,acc+updatedQ.length)}
    }
    }
    calculation(0,Queue.empty,0)
  }

  def main(args: Array[String]): Unit = {
    val a = Array[Int](3,5,6,7,3)
    println( CountBoundedSlices(2, a))
  }
}