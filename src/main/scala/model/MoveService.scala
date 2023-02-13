package model



import types.Board


object MoveService {
  val WinCount = 3

  def whoseTurn(game: InProgress[Board]): Move =
    game.board.flatMap(_.flatten).foldLeft((0, 0)) {
      case ((x, o), X) => (x + 1, o)
      case ((x, o), O) => (x, o + 1)
    } match {
      case (x, o) if x - o <= 0 => X
      case _ => O
    }

  def whoWon(game: Finished[Board]): Option[Move] =
    (for {
      x <- 0 until game.board.size
      y <- 0 until game.board(0).size
      curr <- game.board(x)(y)
      if won_?(game.board, curr, x, y)
    } yield Some(curr)) find (_.isDefined) getOrElse None

  def playerAt(game: Game[Board], p: Position): Option[Move] = game.board(p.x)(p.y)

  def placeMove(board: Board, p: Position, m: Move) =
    board.updated(p.x, board(p.x).updated(p.y, Some(m)))

  private def won_?(board: Board, m: Move, x: Int, y: Int): Boolean =
    won_?(horizMoves(board, x, y), m) || won_?(vertMoves(board, x, y), m) ||
      won_?(diagRightMoves(board, x, y), m) || won_?(diagRightMoves(board, x, y), m)

  private def won_?(moves: Seq[Option[Move]], m: Move): Boolean = moves.foldLeft(List(0)) {
    case (count :: rest, Some(`m`)) => count + 1 :: rest
    case (counts, _) => 0 :: counts
  }.max >= WinCount

def horizMoves(board: Board, x: Int, y: Int) = for (xx <- x until board.size) yield board(xx)(y)

def vertMoves(board: Board, x: Int, y: Int) = for (yy <- y until board(x).size) yield board(x)(yy)

def diagRightMoves(board: Board, x: Int, y: Int) =
    for ((xx, yy) <- (x until board.size) zip (y until board(x).size)) yield board(xx)(yy)

}
