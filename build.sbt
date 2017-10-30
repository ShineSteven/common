name := """common"""

version := "2.0.0"

organization := "shine.st"

scalaVersion := "2.12.3"

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.11.60"

libraryDependencies += "joda-time" % "joda-time" % "2.9.9"

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

//libraryDependencies ++= Seq(
// Change this to another test framework if you prefer
//  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
//  "org.scala-lang" % "scala-reflect" % "2.11.8",
//  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
//)


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))