package util

import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.util.Random.nextInt

trait TestUtil extends FunSuite with BeforeAndAfter {
  var count = 0
  var light = 0
  val intNum = Stream.continually(nextInt(9)).head

  before {
    light = 0
  }

  after {
    count+=1
    ProgressBar.main(Array(count.toString, light.toString, intNum.toString))
  }

}
