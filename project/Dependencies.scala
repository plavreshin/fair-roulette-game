import sbt.Keys._
import sbt._

object Dependencies {
  val configVersion = "1.3.0"
  val akkaVersion = "2.4.3"
  val scalatestVersion = "2.2.6"
  val sprayVersion = "1.3.3"

  val libsResolvers = Seq(
    "dnvriend at bintray" at "http://dl.bintray.com/dnvriend/maven",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  )

  private val config = "com.typesafe" % "config" % configVersion
  private val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion exclude("org.scala-lang", "scala-library") withSources()
  private val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion exclude("org.slf4j", "slf4j-api") exclude("org.scala-lang", "scala-library")
  private val akkaPersistence = "com.typesafe.akka" %% "akka-persistence" % akkaVersion withSources()
  private val akkaPersistenceJdbc = "com.github.dnvriend" %% "akka-persistence-jdbc" % "2.2.16" % "compile" withSources()
  private val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion withSources()
  private val akkaClusterSharding = "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion withSources()
  private val akkaClusterTools = "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion withSources()

  private val hikariCp = "com.zaxxer" % "HikariCP" % "2.4.3"
  private val postgres = "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
  private val slick = "com.typesafe.slick" %% "slick" % "3.1.1" withSources()
  private val slicPg = "com.github.tminglei" %% "slick-pg" % "0.12.0" withSources()
  private val slickPgJoda = "com.github.tminglei" %% "slick-pg_joda-time" % "0.12.0"
  private val slickPgPlayJson = "com.github.tminglei" %% "slick-pg_play-json" % "0.12.0"
  private val slickJodaMapper = "com.github.tototoshi" %% "slick-joda-mapper" % "2.1.0"
  private val jodaTime = "joda-time" % "joda-time" % "2.9.1"
  private val jodaConvert = "org.joda" % "joda-convert" % "1.8"
  private val slickHikari = "com.typesafe.slick" %% "slick-hikaricp" % "3.1.1"

  private val redisScala = "com.github.etaty" %% "rediscala" % "1.6.0"

  private val logBackClassic = "ch.qos.logback" % "logback-classic" % "1.1.3"
  private val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

  private val mockito = "org.mockito" % "mockito-all" % "1.10.19" % "test"
  private val scalaTest = "org.scalatest" %% "scalatest" % scalatestVersion % "test"
  private val akkaTestKitMulti = "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion % "test"
  private val akkaTestKitSimple = "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"

  val coreDependencies = Seq(
    config,
    akkaActor,
    akkaSlf4j,
    akkaPersistence,
    akkaPersistenceJdbc,
    akkaCluster,
    akkaClusterSharding,
    akkaClusterTools,
    hikariCp,
    postgres,
    jodaTime,
    jodaConvert,
    redisScala,
    logBackClassic,
    scalaLogging,
    mockito,
    scalaTest)

  val engineDependencies = Seq(
    config,
    akkaActor,
    akkaSlf4j,
    akkaPersistence,
    akkaPersistenceJdbc,
    akkaCluster,
    akkaClusterSharding,
    akkaClusterTools,
    logBackClassic,
    scalaLogging,
    mockito,
    scalaTest)

  val domainDependencies = Seq(
    config,
    mockito,
    scalaTest)
}
