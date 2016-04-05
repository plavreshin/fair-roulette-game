package io.provablyfair.roulette.domain

final class GameData(config: GameConfig) {
  def acceptBet(): GameData = this

  def start(): GameData = this
}
