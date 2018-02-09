package partyplanner

import java.text.SimpleDateFormat
import java.util.Calendar

import partyplanner.PartyPlanner.{formatReceipt, todayDate}
import partyplanner.domain.Party
import partyplanner.input.Request
import partyplanner.output.Receipt
import util.TestUtil

class ReceiptSuite extends TestUtil {

  test("todayDate") {
    val todayTime = Calendar.getInstance().getTime
    val dateFormat = new SimpleDateFormat("dd MMMM yyyy")

    assert(todayDate == dateFormat.format(todayTime))

    light = 1
  }

  test("formatReceipt") {
    val party = Party("Some party", List("coffee", "apples"))
    val req = Request(party, 15, 1000)
    val receipt = Receipt(req, 500)
    val today = todayDate

    assert(formatReceipt(receipt) ==
      "--------------------\n" +
        "Some party party for 15 people\n\n" +
        "coffee\n" +
        "apples\n\n" +
        "TOTAL $500.0\n" +
        "--------------------\n" +
        "THANK YOU!\n" +
        today
    )

    light = 1
  }
}
