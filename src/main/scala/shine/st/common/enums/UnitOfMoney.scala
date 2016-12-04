package shine.st.common.enums

import shine.st.common.NumberUtils

/**
  * Created by shinest on 2016/7/2.
  */

object UnitOfMoney {

  private[this] val all = List(Million)

  sealed abstract class Unit(val display: String, val amount: Int)

  case object Million extends Unit("million", 1000000)

  def transformToAmount(unit: String) = {
    val lowerUnit = unit.toLowerCase
    all.filter(u => lowerUnit.contains(u.display)) match {
      case head :: tail => head.amount
      case Nil => 0
    }
  }

  def toInt(amount: String) = {
    amount.replace("$", "").replace(",", "").split(" ").map { s => NumberUtils.strTrans[Int](s).getOrElse(transformToAmount(s)) }.foldLeft(1) { (a, b) => a * b }
  }
}
