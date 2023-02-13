package model
import io.Source
import scala.util.control.Breaks.{break, breakable}

object TestMain {
  def main(array: Array[String]) = {

    trait Animal{
      def value: String
    }

    val testSample = new Animal {
      override def value:String = "Iam"
    }
    println(testSample.value)

      println("Welcome to Tic Tac Toe!")
      Source.stdin.getLines.foreach{
        case s if s =="1" => break
        case e => println(e)
       }


    println("Bye!")
  }
//def main(args: Array[String]) {
//  for (ln <- io.Source.stdin.getLines) println(ln)
//}
}
