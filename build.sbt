name := "Akmuze"

version := "0.0.2"

organization := "com.quixoticchris"

organizationName := "Quixotic Chris"

organizationHomepage := Some(url("http://quixotic-chris.com"))

description := "A music quiz website to aid in memorization"

licenses += "MIT" -> url("http://opensource.org/licenses/MIT")

scalaVersion := "2.10.3"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.xerial" % "sqlite-jdbc" % "3.7.2", // SQLite driver
  "com.typesafe.slick" %% "slick" % "2.0.1-RC1" // Slick database API
)     

play.Project.playScalaSettings
