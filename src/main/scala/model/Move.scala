package model

sealed trait Move

case object O extends Move

case object X extends Move