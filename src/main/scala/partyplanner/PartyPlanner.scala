package partyplanner

import partyplanner.domain.{Consumption, Party, Price}
import partyplanner.input.Request
import partyplanner.output.Receipt
import utils.Utils.loadDataFromFile

object PartyPlanner extends App {

  /**
    * PARSING
    *
    * All data is in resources folder: party.txt, price.txt, consumption.txt
    *
    * Use `split` function
    *
    * val arr = "boo:and:foo".split(":") // results to Array("boo", "and", "foo")
    *
    * Access each element by index
    *
    * arr(0) // results to "boo"
    *
    * Don't forget to transform String into Double type when necessary
    *
    * "2".toDouble // 2: Double
    * "a".toDouble // throws an Exception
    */

  /**
    * @return List[Price] containing prices from file in resource
    *         For example for line
    *
    *         "apple;1.5"
    *
    *         price should be Price("apple", 1.5)
    */
  def parsePrices: List[Price] = ???

  /**
    * @return List[Consumption] containing consumptions from file in resource
    *         For example for line
    *
    *         "apple;0.5"
    *
    *         consumption should be Consumption("apple", 0.5)
    */
  def parseConsumptions: List[Consumption] = ???

  /**
    * @return List[Party] containing Party from file in resource
    *         For example for lines
    *
    *         "birthday;coffee"
    *         "birthday;cola"
    *
    *         party should be Party("birthday", List("coffee", "cola"))
    */
  def parseParties: List[Party] = ???

  /**
    * Let's run some tests!
    * Open terminal
    * Go to your project dir : cd FOLDER/partyplanner
    * To run sbt type "sbt"
    * To check if you parsed data run testOnly partyplanner.ParserSuite
    *
    * How did it go?
    */

  /*
  * CALCULATION
  * */

  /**
    * @param parties contains List of parties
    * @return Map[Int, Party] containing parties with indexes.
    *         We need it to have access to available parties we can throw
    *         in different parts of our application.
    *
    *         For example for List(
    *         Party("party1", List("product1")),
    *         Party("party2", List("product2"))
    *         )
    *
    *         we will have Map(
    *         0 -> Party("party1", List("product1")),
    *         1 -> Party("party2", List("product2"))
    *         )
    */
  def getAvailableParties(parties: List[Party]) = ???

  /*
   * step 1. Calculate amount to spend for one person for one product.
   *
   * Input: Price and Consumption
   * Output: value of price multiplied by value of consumption
   *
   * For example
   *
   * Price("apple", 2) and Consumption("apple", 0.1) returns 0.2
   *
   * Price("apple", 2) and Consumption("coffee", 0.1)
   *    returns PartyPlannerException("Price and consumption should be for same product")
   *
   * Price("apple", -2) and Consumption("apple", 0.1)
   *    returns PartyPlannerException("Price or consumption can't be less than zero")
   *
   * */
  def oneProductAmount(p: Price, c: Consumption): Double = ???

  /*
   * step 2. Calculate amount to spend for one person for all products in the party product list.
   *
   * Input: party, prices and consumptions
   * Output: calculate amounts for all the products from the party list for one person and sum them up
   *
   * For example
   *
   * products =  List("apple", "coffee")
   * consumptions = List(
   *                  Consumption("apple", 0.1),
   *                  Consumption("coffee", 0.2),
   *                  Consumption("cola", 0.3)
   *                  )
   * prices = List(
   *            Price("apple", 2),
   *            Price("other", 3),
   *            Price("coffee", 4)
   *            )
   *
   * totalOnePerson = oneProductAmount(for "apple") + oneProductAmount(for "coffee")
   *                = Price * Consumption (for "apple") + Price * Consumption (for "coffee")
   *                = 2 * 0.1 + 4 * 0.2 = 1.0
   * */
  def totalOnePerson(party: Party,
                     prices: List[Price],
                     consumptions: List[Consumption]): Double = ???

  /*
   * step 3. Calculate total for all people for this party
   *
   * Input: totalOnePerson and numberOfPeople
   * Output: multiply total amount to spend for one person for all the products and number of people
   *
   * For example:
   *
   * If amount per one person is 10 and 12 people invited to the party total amount is 120.
   *
   *
   * After all functions implemented we can run:
   *
   * testOnly partyplanner.CalculationSuite
   *
   * If you have any questions ask for help =)
   * */
  def totalAmount(totalOnePerson: Double, numberOfPeople: Int): Double = ???

  /*
   * RECEIPT
   *
   * step 1. Calculate today's date in format "dd MMMM yyyy" ("10 Feb 2018")
   *
   * We can take date from object java.util.Calendar:
   *
   * val todayDate = Calendar.getInstance().getTime // results will be like Fri Feb 09 14:18:59 AEDT 2018

   * You can use SimpleDateFormat to format value of type java.util.Date:
   *
   * val sf = new SimpleDateFormat(YOUR_FORMAT)
   *
   * sf.format(todayDate)
   * */
  def todayDate: String = ???

  /*
   * step 2. Create a string to print for your client, with all information about the order.
   * Receipt should look like this:

   --------------------
   Birthday party for 10 people

   cake
   balloon
   cola
   icecream
   banana

   TOTAL $37.0
   --------------------
   THANK YOU!
   10 February 2018

   *
   *
   * Input: Receipt
   * Output: String
   *
   * There are plenty of ways to work with string type in Scala.
   *
   * Some tips:
   *
   * "abc".capitalize // Abc
   * "ab" + "cd" // abcd
   * "\n" // new line
   * "-"*3 // ---
   * List("a","b","c","d", "e").mkString("1",",","!") // 1a,b,c,d,e!
   *
   * After all functions implemented we can run:
   *
   * testOnly partyplanner.ReceiptSuite
   *
   * How is it going?
   * */
  def formatReceipt(receipt: Receipt): String = ???

  /*
  * CHAT WITH USER
  *
  * To get data from console we have scala.io.StdIn object with methods for each type.
  * For example to get Int
  *
  * scala.io.StdIn.readInt()
  *
  * This method throws an exception if user types a wrong type.
  * What can we use to catch that Exception?
  *
  * Try `scala.util.Try`
  *
  * Try(call some method that returns "abc").toOption // Option("abc")
  *
  * step 1. Write a function to get number of guests from console
  *
  * Input: from console
  * Output: Option[Int]
  * */
  def getNumberOfPeople: Option[Int] = {
    println("How many people will be at the party?")
    ???
  }

  /*
   * step 2. Write a function to get budget for party from console
   *
   * Input: from console
   * Output: Option[Double]
   * */
  def getBudget: Option[Double] = {
    println("What is your budget for this party?")
    ???
  }

  /*
   * step 3. Write a function to get Party data for party type user picked.
   * Remember, user can make a mistake and ask for a type of a party we don't have.
   *
   * You can use `while` to continue to ask user to pick
   * some type from availableParties value.
   *
   * Use method `.get` on Map[T,U]:
   *
   * val map = Map(1->"a")
   * map.get(1) // Option("a")
   *
   * Input: availableParties Map
   * Output: Option[Party]
   * */
  def getPartyType(availableParties: Map[Int, Party]): Option[Party] = {
    println("\nPlease, pick the type of your party")
    ???
  }

  /*
   * step 4. Write a function to list all parties available.
   *
   * Input: availableParties Map[Int, Party]
   * Output: String
   *
   * For example
   *
   * val availableParties = Map(0 -> Party("p1", List("s")), 1 -> Party("p2",List("a")))
   *
   * result will be: "0 - p1\n1 - p2"
   * */
  def listPartiesWeCanThrow(availableParties: Map[Int, Party]): String = ???

  /*
   * step 5. Write a function to chat with a user and get all data for Request model.
   *
   * Input: availableParties Map[Int, Party]
   * Output: Option[Request]
   *
   * `for` loop and `yield` can be very useful here.
   *
   * Examples
   *
   * example 1.
   *
   * val xs = Array(1, 2, 3, 4, 5)
   * for (x <- xs) yield x * 2 // Array(2, 4, 6, 8, 10)
   *
   *
   * example 2.
   *
   * case class Cat(name: String, age: Int)
   *
   * val optNum = Option(2)
   * val optStr = Option("Ginger")
   *
   * val cat = for {
   *             n <- optStr
   *             a <- optNum
   *           } yield Cat(n,a) // Some(Cat("Ginger", 2))
   * */
  def chatWithClient(availableParties: Map[Int, Party]): Option[Request] = {
    val partiesWeCanThrow = listPartiesWeCanThrow(availableParties)

    println("Hey there, it's a party planner app!\n" +
      "We are offering different types of parties:\n" +
      partiesWeCanThrow +
      "Please, pick the type of your party\n")

    ???
  }

  /*
   * Let's check how you did with chat part!
   * run testOnly partyplanner.ChatWithClientSuite
   *
   * Sooo?
   *
   * PS if you have questions - ask, if you did great - show us,
   * we'll be happy to know how good you are doing!
   * */

  /**
    * PLAN THAT PARTY
    *
    * @param availableParties available parties in Map[Int, Party]
    * @param prices           contains List of prices parsed from price.txt
    * @param consumptions     contains List of consumptions parsed from consumption.txt
    * @return Option[Receipt] when total amount for party is
    *         smaller or equal to budget user provided
    *
    *         Scala has `flatMap` function
    *
    *         Option(2).flatMap{ i => if (i > 0) Some(i) else None } // Some(2)
    *
    *         Option(-2).flatMap{ i => if (i > 0) Some(i) else None } // None
    *
    *         Tip!
    *
    *         We need to make calculations only if we have a Request from User.
    *
    *         `chatWithClient` returns Option[Request]
    *
    *         Having Option[Request] we can use flatMap to return Option[Receipt]
    *
    *         You can find another way to implement that function if you want)
    *
    *         run testOnly partyplanner.PartyPlannerSuite
    *
    *         to check how did it go!
    */
  def plan(availableParties: Map[Int, Party],
           prices: List[Price],
           consumptions: List[Consumption]): Option[Receipt] = ???

  val prices: List[Price] = ???
  val consumptions: List[Consumption] = ???
  val parties: List[Party] = ???
  val availableParties = ???

  /**
    * After all information received from user we can call `plan` and compute response for user.
    * If it returned Option[Receipt] call `formatReceipt`,
    * otherwise response will be "Sorry, the budget isn't not enough to make that party happen."
    *
    * Print that result to console.
    */
  val response = ???

}
