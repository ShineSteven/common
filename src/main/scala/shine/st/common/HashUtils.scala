package shine.st.common

import scala.language.postfixOps

/**
  * Created by shinest on 2016/9/2.
  */
object HashUtils {
  def sha256(s: String): String = {
    val m = java.security.MessageDigest.getInstance("SHA-256").digest(s.getBytes("UTF-8"))
    m.map("%02x".format(_)).mkString
  }
}
