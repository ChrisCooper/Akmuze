package com.quixoticchris.Akmuze

// Use SQLiteDriver to connect to a SQLite database
import scala.slick.driver.SQLiteDriver.simple._
import com.quixoticchris.Akmuze.Model._

object Hello extends App {
	println("------")
	println("Hey! Running a cool SQLite test.")
	
	// Connect to the database and execute the following block within a session
	Database.forURL("jdbc:sqlite:experiment.db", driver = "org.sqlite.JDBC") withSession {
	implicit session =>
	
	println("------")
	println("Creating tables with these SQL statements:")
	val tables_descriptions = (composers.ddl ++ songs.ddl)
	println(tables_descriptions.createStatements.mkString("\n"))
	tables_descriptions.create

	println("------")
	println("Inserting some data")
	composers += (1, "Franz Xaver Gruber")
	composers += (2, "Radiohead")
	
	songs ++= Seq(
	    (1, "Silent Night", 1),
	    (2, "Subterranean Homesick Alien Night", 2)
	)
	
  }
}
