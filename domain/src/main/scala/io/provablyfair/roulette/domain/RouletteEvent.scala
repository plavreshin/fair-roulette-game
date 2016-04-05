package io.provablyfair.roulette.domain

import java.time.Instant

sealed trait RouletteEvent

object RouletteEvent {

  case class Started(created: Instant) extends RouletteEvent

  case class BetPlaced(created: Instant) extends RouletteEvent

}
