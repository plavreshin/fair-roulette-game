Provably fair roulette
===========================

# Consists of
* PersistentFSM for roulette game engine
* Akka-persistence-jdbc2 journal plugin
* Redis Pub/Sub to receive/dispatch game messages

# Running locally

* Run Main.scala with -Dconfig.resource=local.conf
