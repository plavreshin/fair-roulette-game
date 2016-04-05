
import Dependencies._
import sbt.Keys._
import sbt._
import sbtassembly.AssemblyPlugin.autoImport._
import com.sksamuel.scapegoat.sbt.ScapegoatSbtPlugin.autoImport._

object Build extends Build {

  lazy val commonSettings = Seq(
    organization := "io.provablyfair",
//    version := "0.0.1-rev-" + "git rev-parse HEAD".!!.trim,
    version := "0.0.1",
    scalaVersion := "2.11.8",
    externalResolvers := Dependencies.libsResolvers,
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-Xlint",
      "-Ywarn-dead-code",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
    ),
    crossPaths := false,
    fork in Test := true,
    parallelExecution in Test := false,
    scapegoatVersion := "1.1.0",
    mainClass in assembly := Some("io.provablyfair.roulette.Main")
  )

  lazy val scapegoatSettings = Seq(
    scapegoatVersion := "1.1.1"
  )

  lazy val assemblySettings = Seq(
    assemblyJarName in assembly := "roulette-engine.jar",
    assemblyMergeStrategy in assembly := {
      case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
      case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
      case "reference.conf" => MergeStrategy.concat
      case _ => MergeStrategy.first
    }
  )

  // this is the root project, aggregating all sub projects
  lazy val rouletteEngine = Project(
    id = "rouletteEngine",
    base = file("."),
    // always run all commands on each sub project
    aggregate = Seq(core, engine, domain)
  )
    .dependsOn(core, engine, domain)
    .settings(commonSettings ++ assemblySettings)

  lazy val core = Project(
    id = "core",
    base = file("core")
  ).settings(commonSettings: _*)
    .settings(libraryDependencies ++= coreDependencies)
    .dependsOn(engine, domain)

  lazy val engine = Project(
    id = "engine",
    base = file("engine")
  ).settings(commonSettings: _*)
    .settings(libraryDependencies ++= engineDependencies)
    .dependsOn(domain)

  lazy val domain = Project(
    id = "domain",
    base = file("domain")
  ).settings(commonSettings: _*).settings(libraryDependencies ++= domainDependencies)

}