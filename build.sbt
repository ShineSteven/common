name := """shinest_common"""

version := "1.0.1.SNAPSHOT"

organization := "shine.st"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.10.27"

libraryDependencies += "commons-io" % "commons-io" % "2.4"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))