name := """helper"""

version := "1.0-SNAPSHOT"

organization := "org.helper"

scalaVersion := "2.11.7"
publishTo := Some(Resolver.file("file", new File(baseDirectory.value + "/" + "libexec")))
lazy val helper = (project in file(".")).enablePlugins(PlayScala)
libraryDependencies ++= Seq(
  javaJpa,
  ws,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.hibernate" % "hibernate-core" % "4.3.6.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "org.hibernate" % "hibernate-c3p0" % "4.3.6.Final",
  "org.apache.jena" % "jena-arq" % "2.9.3",
  "com.restfb" % "restfb" % "1.6.11",
  "com.typesafe.play" %% "play-mailer" % "5.0.0",
  "org.webjars" % "bootstrap" % "3.3.6"
)


routesGenerator := InjectedRoutesGenerator