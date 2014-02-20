package com.quixoticchris.Akmuze

// Use SQLiteDriver to connect to a SQLite database
import scala.slick.driver.SQLiteDriver.simple._

object Hello extends App {
	println("Hey! Running a cool SQLite test.")
	
	// Definition of the SONGS table
	class Composer(tag: Tag) extends Table[(Int, String)](tag, "COMPOSERS") {
		def id = column[Int]("COMPOSER_ID", O.PrimaryKey)
		def name = column[String]("NAME")
		
		// Every table needs a * projection with the same type as the table's type parameter
		def * = (id, name)
	}
	val composers = TableQuery[Composer]
	
	// Definition of the SONGS table
	class Song(tag: Tag) extends Table[(Int, String, Int)](tag, "SONGS") {
		def id = column[Int]("SONG_ID", O.PrimaryKey)
		def title = column[String]("TITLE")
		def composerID = column[Int]("COMPOSER_ID")
		
		// Every table needs a * projection with the same type as the table's type parameter
		def * = (id, title, composerID)
	}
	val songs = TableQuery[Song]
	
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
