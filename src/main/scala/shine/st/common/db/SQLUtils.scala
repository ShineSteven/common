package shine.st.common.db

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

import shine.st.common.IOUtils

/**
  * Created by shinest on 16/07/2017.
  */
object SQLUtils extends IOUtils {

  def driver(clazz: String): Any = Class.forName(clazz).newInstance()

  def connect(url: String) = DriverManager.getConnection(url)

  def connect(url: String, account: String, password: String) = DriverManager.getConnection(url, account, password)

  def statement(cmd: String, connection: Connection): PreparedStatement = connection.prepareStatement(cmd)

  def query(statement: PreparedStatement): ResultSet = statement.executeQuery()

  def update(statement: PreparedStatement): Int = statement.executeUpdate()

  def insertBatch[A](url: String)(sql: String)(list: List[A])(p: (A, PreparedStatement) => Unit) = {
    var conn: Connection = null
    var stmt: PreparedStatement = null

    try {
      conn = connect(url)
      stmt = statement(sql, conn)
      for (l <- list) {
        p(l, stmt)
        stmt.addBatch()
        stmt.clearParameters()
      }

      stmt.executeBatch()

    } finally {
      close(stmt)
      close(conn)
    }
  }
}
