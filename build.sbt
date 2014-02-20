name := "Akmuze"

version := "0.0.2"

organization := "com.quixoticchris"

organizationName := "Quixotic Chris"

organizationHomepage := Some(url("http://quixotic-chris.com"))

description := "A music quiz website to aid in memorization"

licenses += "MIT" -> url("http://opensource.org/licenses/MIT")

scalaVersion := "2.10.3"

scalacOptions += "-deprecation"



libraryDependencies ++= List(
	"com.typesafe.slick" %% "slick" % "2.0.1-RC1",
	"org.xerial" % "sqlite-jdbc" % "3.7.2"
	)



// Custom task key for printing an encouraging message
lazy val encourage = taskKey[Unit]("Just help things along")

encourage := { println("You can do it!!") }
