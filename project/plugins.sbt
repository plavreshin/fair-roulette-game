
resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.9")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.1")

addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.2.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.2")

addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.4")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")


