package shine.st.common

import shine.st.common.enums.OS

/**
  * Created by stevenfanchiang on 2016/4/1.
  */
object OSValidator {
  private[this] val osName = System.getProperty("os.name").toUpperCase()

  def whatOS() = {
    OS.values.filter { os => osName.indexOf(os.toString) >= 0 }.head
  }
}
