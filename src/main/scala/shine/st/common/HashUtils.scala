package shine.st.common

import scala.language.postfixOps
import java.nio.ByteBuffer

import sun.misc.BASE64Encoder

/**
  * Created by shinest on 2016/9/2.
  */
object HashUtils {
  val encoder = new BASE64Encoder()

  def sha256(s: String): String = {
    val m = java.security.MessageDigest.getInstance("SHA-256").digest(s.getBytes("UTF-8"))
    m.map("%02x".format(_)).mkString
  }

  def uuidBase64: String = {
    val uuid = java.util.UUID.randomUUID
    val bb = ByteBuffer.wrap(new Array[Byte](16))
    bb.putLong(uuid.getMostSignificantBits)
    bb.putLong(uuid.getLeastSignificantBits)
    bb.array().foreach(print)
    encoder.encode(bb.array())
  }
}
