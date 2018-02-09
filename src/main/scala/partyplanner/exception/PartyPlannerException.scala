package partyplanner.exception

import scala.util.control.NoStackTrace

class PartyPlannerException(msg: String) extends NoStackTrace {
  override def getMessage: String = msg
}
