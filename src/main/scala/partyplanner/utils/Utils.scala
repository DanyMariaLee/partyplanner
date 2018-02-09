package partyplanner.utils

import java.io.InputStream

object Utils {

  /**
    * @return List[String] containing lines from file with `name`
    *         For example for file name.txt
    *
    *         product1;value1
    *         product2;value2
    *         product3;value3
    *
    *         result will be
    *
    *         List("product1;value1", "product2;value2", "product3;value3")
    *
    * @param name Is the name of a file you want to read (e.g. "price.txt")
    */

  def loadDataFromFile(name: String): List[String] = {
    val stream: InputStream = getClass.getResourceAsStream(name)
    scala.io.Source.fromInputStream(stream).getLines.toList
  }
}
