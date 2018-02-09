package partyplanner


import java.io.ByteArrayInputStream

import partyplanner.domain.{Consumption, Party, Price}
import partyplanner.input.Request
import partyplanner.output.Receipt
import util.TestUtil

class PartyPlannerSuite extends TestUtil {

  test("plan a party") {
    val in1 = new ByteArrayInputStream("1\n3\n100".getBytes)
    val in2 = new ByteArrayInputStream("1\n3\n1".getBytes)

    val party = Party("Party name", List("product"))
    val avParties = Map(1 -> party)
    val cs = List(Consumption("product", 0.2))
    val prs = List(Price("product", 10))

    Console.withIn(in1) {
      assert(PartyPlanner.plan(avParties, prs, cs) ===
        Some(
          Receipt(
            Request(
              Party("Party name", List("product")),
              3, 100.0), 6.0)
        )
      )
    }

    Console.withIn(in2) {
      assert(PartyPlanner.plan(avParties, prs, cs) === None)
    }

    light = 1
  }

}
