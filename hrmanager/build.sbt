name := """hrmanager"""

version := "1.0-SNAPSHOT"
unmanagedJars in Compile += file("D:/DOCUMENT/playtest/hrmanager/packages/pkg_db/target/scala-2.11/pkg_db_2.11-1.0-SNAPSHOT.jar")
unmanagedJars in Compile += file("D:/DOCUMENT/playtest/hrmanager/packages/helper/target/scala-2.11/helper_2.11-1.0-SNAPSHOT.jar")


lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .aggregate(pkg_admin,pkg_user,pkg_db,helper)
  .dependsOn(pkg_admin,pkg_user,pkg_db,helper)

scalaVersion := "2.11.7"

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


// db Portal
lazy val helper = project.in(file("packages/helper"))

// db Portal
lazy val pkg_db = project.in(file("packages/pkg_db"))
  .enablePlugins(PlayScala)
  .dependsOn(helper)
  .aggregate(helper)

// Admin Portal
lazy val pkg_admin = project.in(file("packages/pkg_admin"))
  .enablePlugins(PlayScala)
  .dependsOn(pkg_db,helper)
  .aggregate(pkg_db,helper)
// User Portal
lazy val pkg_user = project.in(file("packages/pkg_user"))
  .enablePlugins(PlayScala)
  .dependsOn(pkg_db,helper)
  .aggregate(pkg_db,helper)

routesGenerator := InjectedRoutesGenerator