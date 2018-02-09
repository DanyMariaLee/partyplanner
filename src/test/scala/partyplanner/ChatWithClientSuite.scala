package partyplanner

import java.io.ByteArrayInputStream

import PartyPlanner.{chatWithClient, getBudget, getNumberOfPeople, getPartyType, listPartiesWeCanThrow}
import partyplanner.domain.Party
import partyplanner.input.Request
import util.TestUtil

class ChatWithClientSuite extends TestUtil {

  test("getBudget") {
    val in1 = new ByteArrayInputStream("1000.5".getBytes)
    val in2 = new ByteArrayInputStream("a".getBytes)

    Console.withIn(in1) {
      assert(getBudget === Some(1000.5))
    }

    Console.withIn(in2) {
      assert(getBudget === None)
    }

    light = 1
  }

  test("getNumberOfPeople") {
    val in1 = new ByteArrayInputStream("1".getBytes)
    val in2 = new ByteArrayInputStream("a".getBytes)

    Console.withIn(in1) {
      assert(getNumberOfPeople === Some(1))
    }

    Console.withIn(in2) {
      assert(getNumberOfPeople === None)
    }

    light = 1
  }

  test("listPartiesWeCanThrow") {
    val availableParties = Map(
      0 -> Party("p1", List("s")),
      1 -> Party("p2", List("a"))
    )
    assert(listPartiesWeCanThrow(availableParties) === "0 - p1\n1 - p2")

    light = 1
  }

  test("getPartyType") {
    val in1 = new ByteArrayInputStream("1".getBytes)
    val in2 = new ByteArrayInputStream("a".getBytes)
    val in3 = new ByteArrayInputStream("2\n3\n1".getBytes)
    val party = Party("Party name", List("product"))
    val avParties = Map(1 -> party)

    Console.withIn(in1) {
      assert(getPartyType(avParties) === Some(party))
    }

    Console.withIn(in2) {
      intercept[NumberFormatException](getPartyType(avParties))
    }

    Console.withIn(in3) {
      assert(getPartyType(avParties) === Some(party))
    }

    light = 1
  }

  test("chatWithClient with all numbers typed right") {
    val in1 = new ByteArrayInputStream("1\n10\n100.5".getBytes)
    val party = Party("Party name", List("product"))
    val avParties = Map(1 -> party)

    Console.withIn(in1) {
      assert(chatWithClient(avParties) === Some(Request(party, 10, 100.5)))
    }

    light = 1
  }

  test("chatWithClient with no budget number accepted") {
    val in1 = new ByteArrayInputStream("1\n10\na".getBytes)
    val party = Party("Party name", List("product"))
    val avParties = Map(1 -> party)

    Console.withIn(in1) {
      assert(chatWithClient(avParties).isEmpty)
    }

    light = 1
  }


}
