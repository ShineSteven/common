package shine.st.common.akka

/**
  * Created by stevenfanchiang on 2016/7/19.
  */
object Message {

  case object End

  case object EndComplete

  case object Check

  case class Wait(waitSecond:Long)
}
