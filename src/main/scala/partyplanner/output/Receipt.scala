package partyplanner.output

import partyplanner.input.Request

case class Receipt(request: Request, totalAmount: Double)
