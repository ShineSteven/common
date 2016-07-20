package shine.st.common

import shine.st.common.enums.UnitOfMoney

import scala.util.Try

/**
  * Created by shinest on 2016/7/2.
  */
object NumberUtils {
  def stringToInt(s: String) = Try {
    s.replace(",", "").replace("$", "").toInt
  }.toOption

  def unitsOfMoneyToInt(amount: String) = {
    amount.replace("$", "").split(" ").map { s => stringToInt(s).getOrElse(UnitOfMoney.transformToAmount(s)) }.foldLeft(1) { (a, b) => a * b }
  }
}
