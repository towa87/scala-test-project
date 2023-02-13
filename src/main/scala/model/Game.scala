package model

abstract class Game[T](val board: T)

case class InProgress[T](override val board: T) extends Game[T](board)

case class Finished[T](override val board: T) extends Game[T](board)

case class Broken[T](override val board: T, val problem: String) extends Game[T](board)