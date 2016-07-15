import play.api._
name := """user"""
version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"



unmanagedJars in Compile += file("I:/Project Spring/playtest/hrmanager/modules/uitl/libexec/org/uitl/uitl_2.11/1.0-SNAPSHOT/uitl_2.11-1.0-SNAPSHOT.jar")
unmanagedJars in Compile += file("I:/Project Spring/playtest/hrmanager/modules/db/target/scala-2.11/db_2.11-1.0-SNAPSHOT.jar")
lazy val user = (project in file(".")).enablePlugins(PlayScala)

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