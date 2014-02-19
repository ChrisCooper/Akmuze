name := "Akmuze"

version := "1.0"

scalaVersion := "2.10.3"


// Custom task key for printing an encouraging message
lazy val encourage = taskKey[Unit]("Just help things along")

encourage := { println("You can do it!!") }
