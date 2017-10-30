package shine.st.common

import scala.util.Try

/**
  * Created by shinest on 2016/7/2.
  */

object NumberUtils {
  //  def strTo[T](s: String)(f: String => T) = Try {
  //    f(s)
  //  }.toOption

  def strTrans[R](t: String)(implicit f: Transfer.Aux[String, R]): Option[R] = {
    Try {
      f(t)
    }.toOption
  }

  def trans[T, R](t: T)(implicit f: Transfer.Aux[T, R]): R = {
    f(t)
  }

}

trait Transfer[S] {
  type R

  def apply(s: S): R
}

object Transfer {
  type Aux[A0, B0] = Transfer[A0] {type R = B0}

  implicit def strToShort: Aux[String, Short] = new Transfer[String] {
    type R = Short

    def apply(s: String) = s.toShort
  }

  implicit def strToInt: Aux[String, Int] = new Transfer[String] {
    type R = Int

    def apply(s: String) = s.replace("$", "").replace(",", "").toInt
  }

  implicit def strToLong: Aux[String, Long] = new Transfer[String] {
    type R = Long

    def apply(s: String) = s.toLong
  }

  implicit def strToFloat: Aux[String, Float] = new Transfer[String] {
    type R = Float

    def apply(s: String) = s.toFloat
  }

  implicit def strToDouble: Aux[String, Double] = new Transfer[String] {
    type R = Double

    def apply(s: String) = s.toDouble
  }
}

