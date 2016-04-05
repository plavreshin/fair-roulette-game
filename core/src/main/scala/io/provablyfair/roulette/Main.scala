package io.provablyfair.roulette

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object Main extends App {

  val nodePort: Option[String] = args.find(_.startsWith("-Dnode.port="))

  // Override the configuration of the port
  val config = ConfigFactory.parseString(s"akka.remote.netty.tcp.port=${nodePort.getOrElse("2551")}")
    .withFallback(ConfigFactory.load())

  implicit val system = {
    val system = ActorSystem("ProvablyFairSystem", config)
    system
  }
}