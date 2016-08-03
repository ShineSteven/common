package shine.st.common

import java.util.{Date, Locale}

import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

import scala.util.Try

/**
  * Created by shinest on 2016/7/9.
  */
object DateTimeUtils {
  val DATE_HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss"
  val DATE_PATTERN = "yyyy-MM-dd"
  //  Tuesday, June 28, 2016
  val EN_DATE_PATTERN = "E, MMMM dd, yyyy"

  val dateHourFormatter = DateTimeFormat.forPattern(DATE_HOUR_PATTERN)
  val dateFormatter = DateTimeFormat.forPattern(DATE_PATTERN)
  //  english locale
  val enDateFormatter = DateTimeFormat.forPattern(EN_DATE_PATTERN).withLocale(Locale.ENGLISH)

  private def getFormatter(pattern: String) = {
    pattern match {
      case DATE_HOUR_PATTERN => dateHourFormatter
      case DATE_PATTERN => dateFormatter
      case EN_DATE_PATTERN => enDateFormatter
      case p => DateTimeFormat.forPattern(p)
    }
  }

  def parse(text: String)(pattern: String) = {
    Try {
      getFormatter(pattern).parseDateTime(text)
    }.toOption
  }

  def parseDate(text: String) = {
    parse(text)(DATE_PATTERN)
  }

  def parseDateHour(text: String) = {
    parse(text)(DATE_HOUR_PATTERN)
  }

  def parseEnDate(text: String) = {
    parse(text)(EN_DATE_PATTERN)
  }

  def formatDateHour(dateTime: Option[DateTime]): String = {
    format(dateTime)(DATE_HOUR_PATTERN)
  }

  def formatDateHour(dateTime: DateTime): String = {
    format(dateTime)(DATE_HOUR_PATTERN)
  }

  def format(dateTime: Option[DateTime])(pattern: String): String = {
    dateTime.map { d =>
      format(d)(pattern)
    }.getOrElse("")
  }

  def format(dateTime: DateTime)(pattern: String): String = {
    Try {
      dateTime.toString(getFormatter(pattern))
    }.getOrElse("")
  }

  def getDateTimeOptFromDate(date: Date) = {
    Try {
      new DateTime(date.getTime)
    }.toOption
  }
}
