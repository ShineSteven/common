package shine.st.common

import java.util.Locale

import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

import scala.util.Try

/**
  * Created by shinest on 2016/7/9.
  */
object DateTimeUtils {
  val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd")
  //  Tuesday, June 28, 2016
  //  english locale
  val enDateFormat = DateTimeFormat.forPattern("E, MMMM dd, yyyy").withLocale(Locale.ENGLISH)

  def parse(text: String)(formatter: DateTimeFormatter): Option[DateTime] = {
    Try {
      formatter.parseDateTime(text)
    }.toOption
  }

  def parseDate(text: String) = {
    parse(text)(dateFormat)
  }


  def parseDateTime(text: String) = {
    parse(text)(dateTimeFormat)
  }

  def parseEnDateTime(text: String) = {
    parse(text)(enDateFormat)
  }
}
