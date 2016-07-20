package shine.st.common

import com.typesafe.config.Config

import scala.collection.JavaConversions._

/**
  * Created by shinest on 2016/7/12.
  */
object ConfigUtils {
  def configToMap(config: List[_ <: Config]) = {
    config.flatMap(c => c.entrySet().map { en => (en.getKey, c.getString(en.getKey)) }).toMap
  }
}
