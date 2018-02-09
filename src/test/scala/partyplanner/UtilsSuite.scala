package partyplanner

import partyplanner.utils.Utils
import util.TestUtil

class UtilsSuite extends TestUtil {

  test("get price data") {
    assert(Utils.loadDataFromFile("/price.txt") ==
      List("banana;2", "cola;1.5", "balloon;0.1"))
    light = 1
  }

  test("get party data") {
    assert(Utils.loadDataFromFile("/party.txt") ==
      List("birthday;cake", "birthday;balloon", "corporate;coffee", "corporate;fish"))
    light = 1
  }

  test("get consumption data") {
    assert(Utils.loadDataFromFile("/consumption.txt") ==
      List("banana;0.2", "cake;0.01", "cola;1"))
    light = 1
  }
}
