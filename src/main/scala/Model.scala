package com.quixoticchris.Akmuze

// Use SQLiteDriver to connect to a SQLite database
import scala.slick.driver.SQLiteDriver.simple._

object Model {

	// COMPOSERS
	class Composer(tag: Tag) extends Table[(Int, String)](tag, "COMPOSERS") {
		def id = column[Int]("COMPOSER_ID", O.PrimaryKey)
		def name = column[String]("NAME")
		
		// Every table needs a * projection with the same type as the table's type parameter
		def * = (id, name)
	}
	val composers = TableQuery[Composer]
	
	
	
	// SONGS
	class Song(tag: Tag) extends Table[(Int, String, Int)](tag, "SONGS") {
		def id = column[Int]("SONG_ID", O.PrimaryKey)
		def title = column[String]("TITLE")
		def composerID = column[Int]("COMPOSER_ID")
		
		// Every table needs a * projection with the same type as the table's type parameter
		def * = (id, title, composerID)
	}
	val songs = TableQuery[Song]
	
	def in_db_session(f: Int => Any) : Unit = {
		print("Test")
	}
	
}