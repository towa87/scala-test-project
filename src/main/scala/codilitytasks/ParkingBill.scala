package codilitytasks

import javax.print.attribute.DateTimeSyntax

object ParkingBill {
  def solution(e: String ,l: String):Int =
  {
    import java.time.LocalDateTime
    import java.time.temporal.ChronoUnit

    val    parsedStart = e.split(':')
    val    parsedEnd=l.split(':')
    val start=   LocalDateTime.of(1,1,1,parsedStart(0).toInt,parsedStart(1).toInt)
    val stop = LocalDateTime.of(1,1,1,parsedEnd(0).toInt,parsedEnd(1).toInt)
    val test=  ChronoUnit.MINUTES.between(start,stop)
    val hours =  (test/60) +(if(test.toDouble%60>0) 1 else 0) -1
    if (hours>0) { (hours*4) + 5}.toInt else 5
  }

  def main(args: Array[String]): Unit = {
  {
println(solution("10:00", "13:21"))
  }
}}
