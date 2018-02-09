package partyplanner.input

import partyplanner.domain.Party

case class Request(party: Party,
                   numberOfPeople: Int,
                   budget: Double)
