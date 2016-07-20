package shine.st.common

import org.joda.time.format.DateTimeFormat

/**
  * Created by shinest on 2016/7/9.
  */
object DateTimeUtils {
  val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd")
}
