package io.provablyfair.roulette.domain

sealed trait RouletteCommand

object RouletteCommand {

  case object Start extends RouletteCommand

  case object PlaceBet extends RouletteCommand

}
