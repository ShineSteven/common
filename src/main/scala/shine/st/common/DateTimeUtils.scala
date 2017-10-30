package shine.st.common

import java.util.{Date, Locale}

import org.joda.time.format.{DateTimeFormat, DateTimeFormatter, ISODateTimeFormat}
import org.joda.time.{DateTime, DateTimeZone}

import scala.util.Try

/**
  * Created by shinest on 2016/7/9.
  */
object DateTimeUtils {
  val TW_ZONE = DateTimeZone.forID("Asia/Taipei")
  val UTC = DateTimeZone.UTC

  val ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZZ"
  //  val ISOFormatter: DateTimeFormatter = ISODateTimeFormat.dateTimeNoMillis()

  val DATE_PATTERN = "yyyy-MM-dd"
  //  Tuesday, June 28, 2016
  val EN_DATE_PATTERN = "E, MMMM dd, yyyy"


  def now = DateTime.now(UTC)


  def parseDate(text: String, timeZone: DateTimeZone = UTC) = {
    parse(text)(DATE_PATTERN, timeZone)
  }

  def parseEnDate(text: String, timeZone: DateTimeZone = UTC) = {
    parse(text)(EN_DATE_PATTERN, timeZone)
  }

  def parseISO(text: String, timeZone: DateTimeZone = UTC) = {
    parse(text)(ISO8601_PATTERN, timeZone)

  }

  def parse(text: String)(pattern: String, timeZone: DateTimeZone) = {
    Try {
      DateTimeFormat.forPattern(pattern).withZone(timeZone).parseDateTime(text)
    }.toOption
  }


  def formatDate(dateTime: DateTime, timeZone: DateTimeZone = UTC): String = {
    format(dateTime)(DATE_PATTERN, timeZone)
  }

  def formatISO(dateTime: DateTime, timeZone: DateTimeZone = UTC): String = {
    format(dateTime)(ISO8601_PATTERN, timeZone)
  }


  def format(dateTime: DateTime)(pattern: String, timeZone: DateTimeZone): String = {
    Try {
      dateTime.toString(DateTimeFormat.forPattern(pattern).withZone(timeZone))
    }.getOrElse("")
  }

  def javaDateToJodaDateTime(date: Date) = {
    Try {
      new DateTime(date.getTime)
    }.toOption
  }
}
