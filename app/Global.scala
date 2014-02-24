import play.api.db.DB
import play.api.GlobalSettings

// Use SQLiteDriver to connect to a SQLite database
import scala.slick.driver.SQLiteDriver.simple._
 
import Database.dynamicSession
 
import play.api.Application
import play.api.Play.current
 
 
object Global extends GlobalSettings {
 
override def onStart(app: Application) {
 
  lazy val database = Database.forDataSource(DB.getDataSource())
 
  }
}