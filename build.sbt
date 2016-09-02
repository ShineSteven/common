name := """shinest_common"""

version := "1.0.2.SNAPSHOT"

organization := "shine.st"

scalaVersion := "2.11.8"

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.10.27"

libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies += "joda-time" % "joda-time" % "2.9.4"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies ++= Seq(
  // Change this to another test framework if you prefer
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))