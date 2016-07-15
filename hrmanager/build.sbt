name := """hrmanager"""

version := "1.0-SNAPSHOT"
unmanagedJars in Compile += file("I:/Project Spring/playtest/hrmanager/modules/uitl/libexec/org/uitl/uitl_2.11/1.0-SNAPSHOT/uitl_2.11-1.0-SNAPSHOT.jar")
unmanagedJars in Compile += file("I:/Project Spring/playtest/hrmanager/modules/db/target/scala-2.11/db_2.11-1.0-SNAPSHOT.jar")

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .aggregate(admin,user,db,uitl)
  .dependsOn(admin,user,db,uitl)

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
lazy val uitl = project.in(file("modules/uitl"))

// db Portal
lazy val db = project.in(file("modules/db"))
  .enablePlugins(PlayScala)
  .dependsOn(uitl)
  .aggregate(uitl)

// Admin Portal
lazy val admin = project.in(file("modules/admin"))
  .enablePlugins(PlayScala)
  .dependsOn(db,uitl)
  .aggregate(db,uitl)
// User Portal
lazy val user = project.in(file("modules/user"))
  .enablePlugins(PlayScala)
  .dependsOn(db,uitl)
  .aggregate(db,uitl)


// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
//PlayKeys.devSettings += ("play.http.router", "admin.Routes")
//PlayKeys.devSettings += ("play.http.router", "user.Routes")
//PlayKeys.devSettings += ("play.http.router", "db.Routes")
//PlayKeys.devSettings += ("play.http.router", "uitl.Routes")
//PlayKeys.externalizeResources := false

routesGenerator := InjectedRoutesGenerator