package partyplanner

import partyplanner.PartyPlanner.{getAvailableParties, oneProductAmount, totalAmount, totalOnePerson}
import partyplanner.domain.{Consumption, Party, Price}
import partyplanner.exception.PartyPlannerException
import util.TestUtil

class CalculationSuite extends TestUtil {

  test("getAvailableParties") {
    val parties = List(
      Party("Party1", List("a", "b")),
      Party("Party2", List("b", "c"))
    )

    assert(getAvailableParties(parties) == Map(
      0 -> Party("Party1", List("a", "b")),
      1 -> Party("Party2", List("b", "c"))
    ))

    light = 1
  }

  test("oneProductAmount") {
    val p1 = Price("banana", 10)
    val badPrice = Price("banana", -10)
    val p2 = Price("apple", 10)
    val c1 = Consumption("banana", 0.1)
    val c2 = Consumption("banana", 10)
    val badConsumption = Consumption("banana", -2)

    assert(oneProductAmount(p1, c1) == 1)
    assert(oneProductAmount(p1, c2) == 100)

    assertThrows[PartyPlannerException] {
      oneProductAmount(badPrice, c1)
    }

    assertThrows[PartyPlannerException] {
      oneProductAmount(p1, badConsumption)
    }

    assertThrows[PartyPlannerException] {
      oneProductAmount(p2, c1)
    }

    light = 1
  }

  test("totalOnePerson") {
    val party = Party("Party1", List("apple", "coffee"))
    val prices = List(
      Price("apple", 2),
      Price("other", 3),
      Price("coffee", 4)
    )

    val consumptions = List(
      Consumption("apple", 0.1),
      Consumption("coffee", 0.2),
      Consumption("cola", 0.3)
    )

    assert(totalOnePerson(party, prices, consumptions) == 1.0)

    light = 1
  }


  test("totalAmount") {
    assert(totalAmount(2, 100) == 200)
    assert(totalAmount(22, 5) == 110)

    light = 1
  }
}
