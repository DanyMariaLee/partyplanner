package partyplanner

import PartyPlanner.{parseConsumptions, parseParties, parsePrices}
import partyplanner.domain.{Consumption, Party, Price}
import util.TestUtil

class ParserSuite extends TestUtil {

  test("parsePrices") {

    assert(parsePrices === List(
      Price("banana", 2),
      Price("cola", 1.5),
      Price("balloon", 0.1)
    ))
    light = 1
  }

  test("parseConsumptions") {

    assert(parseConsumptions === List(
      Consumption("banana", 0.2),
      Consumption("cake", 0.01),
      Consumption("cola", 1)
    ))
    light = 1
  }

  test("parseParties") {

    assert(parseParties === List(
      Party("birthday", List("cake", "balloon")),
      Party("corporate", List("coffee", "fish"))
    ))
    light = 1
  }
}
