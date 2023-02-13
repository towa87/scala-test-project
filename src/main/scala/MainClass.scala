
import model.GameService.{createGame, move}
import model.MoveService.{horizMoves, whoWon, whoseTurn}
import model._
import model.types.Board

import scala.io.Source
import scala.util.control.Breaks._
object MainClass {
  def main(args: Array[String]): Unit = {

    val game = createGame(3, 3)

    println("Welcome to Tic Tac Toe!")
    prompt(game)
    breakable {
      Source.stdin.getLines.map(_.split("\\s*,\\s*").toList match {
        case List(x, y) if x.toInt < 3 && y.toInt < 3 => Some(Position(x.toInt, y.toInt))
        case _ => println("Invalid position, should be: x, y"); None
      }).filter(_.isDefined).map(_.get).foldLeft(game: Game[Board]) {
        case (g@InProgress(_), p) =>
          move(g, p) match {
            case game@InProgress(_) => prompt(game)
            case game@Broken(_, problem) => print("Problem: " + problem); prompt(g)
            case game@Finished(_) =>
              println(draw(game) + "\n" + "Game finished, " + whoWon(game) + " won!"); break; game
          }
        case _ => println("Wrong state!"); game
      }
    }

    def draw(game: Game[Board]) = (for (y <- 0 until game.board(0).size) yield horizMoves(game.board, 0, y) map {
      case Some(m) => m.toString
      case None => " "
    } mkString " | ") mkString ("\n" + ("-" * game.board.size).mkString("-+-") + "\n")

    println("Bye!")

    def prompt(game: InProgress[Board]): InProgress[Board] = {
      print("\n" + draw(game) + "\n" + whoseTurn(game) + "> ");
      game
    }
  }
}
