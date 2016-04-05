package io.provablyfair.roulette.actor

import akka.persistence.fsm.PersistentFSM
import akka.persistence.fsm.PersistentFSM.FSMState
import io.provablyfair.roulette.actor.RouletteGameActor.GameState
import io.provablyfair.roulette.domain.RouletteEvent.{BetPlaced, Started}
import io.provablyfair.roulette.domain.{GameData, RouletteEvent}

import scala.reflect.{ClassTag, classTag}

class RouletteGameActor extends PersistentFSM[GameState, GameData, RouletteEvent] {
  private val persistentType = self.path.parent.name
  private val gameId = self.path.name

  override implicit def domainEventClassTag: ClassTag[RouletteEvent] = classTag[RouletteEvent]

  override def applyEvent(domainEvent: RouletteEvent, currentData: GameData): GameData = {
    domainEvent match {
      case x: Started => currentData.start()
      case x: BetPlaced => currentData.acceptBet()
    }
  }

  override def persistenceId: String = s"$persistentType-$gameId"

}

object RouletteGameActor {

  sealed trait GameState extends FSMState

  case object NoGame extends GameState {
    override def identifier: String = "NoGame"
  }

  case object BetsOpened extends GameState {
    override def identifier: String = "BetsOpened"
  }

  case object BetsClosed extends GameState {
    override def identifier: String = "BetsClosed"
  }

}
