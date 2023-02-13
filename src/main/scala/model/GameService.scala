package model

import model.Game
import model.MoveService.{placeMove, whoWon, whoseTurn}
import types.Board


object GameService {
  def createGame(width: Int, height: Int): InProgress[Board] = {
    val test = for (x <- 0.until(width)) yield for (y <- 0 until height) yield None
    InProgress(for (x <- 0.until(width)) yield for (y <- 0 until height) yield None)
  }

  def move(game: InProgress[Board], p: Position): Game[Board] =
    (game.board(p.x)(p.y), placeMove(game.board, p, whoseTurn(game))) match {
      case (Some(move), board) => Broken(board, "Position was already taken by " + move)
      case (None, board) if finished_?(board) => Finished(board)
      case (None, board) => InProgress(board)
    }

  def finished_?(board: Board) =
    board.flatMap(_.flatten).size == board.size * board(0).size || whoWon(Finished(board)).isDefined
}
