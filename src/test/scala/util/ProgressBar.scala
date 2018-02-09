package util

import util.Illuatration.illustration

import scala.Console._
import scala.util.Random

object ProgressBar extends App {

  override def main(args: Array[String]): Unit = {
    val count = args.head.toInt
    val light = args(1).toInt
    val intNum = args(2).toInt
    val timesToSleep = List(50, 100)

    val testInProgress = s"TEST No $count IN PROGRESS "
    val sign = if (light == 1) s"${RESET}${GREEN}$testInProgress${RESET}"
    else s"${RESET}${RED}$testInProgress${RESET}"

    print(s"\n$sign           ")
    Thread.sleep(10)

    (1 to 11).foreach(_ => print("\b"))

    for (i <- 1 to 10) {

      val time = Random.shuffle(timesToSleep).head
      val pic = illustration(light, intNum)

      print(pic)
      (1 to (10 - i)).foreach(_ => print(" "))

      print(" " + (i * 10) + "%")

      (1 to (15 - i)).foreach(_ => print("\b"))
      Thread.sleep(time)
    }

    println()
  }
}

object Illuatration {

  def illustration(light: Int, ind: Int): String = {


    val noo2 = " (✖╭╮✖) "
    val noo5 = "($╭╮$) "
    val noo4 = "━━━"
    val heartPuls = "v^√\\/♥"
    val heartPuls2 = "√v^√♥"
    val dollar = "[̲̅$̲̅(̲̅1̲̅)̲̅$̲̅]"
    val chess = " ♚ ♛ ♞ "
    val bear = " ˁ(⦿ᴥ⦿)ˀ "
    val puls = "––√\\/"
    val heart = "  ♡  ♡  "
    val mouse = " ~~(__^·> "

    val done = if (light == 1) s"${RESET}${GREEN_B}    ${RESET}"
    else s"${RESET}${RED_B}    ${RESET}"

    val colordollar = if (light == 1) s"${RESET}${BLACK}${GREEN_B}$dollar${RESET}"
    else s"${RESET}${RED_B}$noo5${RESET}"

    val colorheartPuls = if (light == 1) s"${RESET}${GREEN}$heartPuls${RESET}"
    else s"${RESET}${RED}$noo4${RESET}"

    val colorheartPuls2 = if (light == 1) s"${RESET}${GREEN}$heartPuls2${RESET}"
    else s"${RESET}${RED}$noo4${RESET}"

    val colorcards = if (light == 1) s"${RESET}${GREEN_B}${BLACK}[♣]]] ${RESET}"
    else s"${RESET}${RED_B}${BLACK}[♦]]] ${RESET}"

    val colorHeart = if (light == 1) s"${RESET}${BLACK}${GREEN_B}$heart${RESET}"
    else s"${RESET}${RED_B}$heart${RESET}"

    val colorBear = if (light == 1) s"${RESET}${BLACK}${GREEN_B}ˁ(⦿ᴥ⦿)ˀ ${RESET}"
    else s"${RESET}${RED_B}$noo2${RESET}"

    val colorChess = if (light == 1) s"${RESET}${BLACK}${GREEN_B}$chess${RESET}"
    else s"${RESET}${RED_B}$chess${RESET}"

    val colorPuls = if (light == 1) s"${RESET}${BLACK_B}${GREEN}$puls${RESET}"
    else s"${RESET}${RED}━━━${RESET}"

    val colorjake = if (light == 1) s"${RESET}${BLACK}${GREEN_B}ˁ(OᴥO)ˀ ${RESET}"
    else s"${RESET}${RED_B}$noo2${RESET}"

    val colorStar = if (light == 1) s"${RESET}${GREEN}★ ✰ ✰ ${RESET}"
    else s"${RESET}${RED_B}✮✮✮${RESET}"

    val illustrations: Map[Int, String] = List(colorChess, colorheartPuls,
      colorheartPuls2, colorcards, colorHeart, colorBear,colordollar,
      colorPuls, colorjake, colorStar)
      .zipWithIndex.map {
      case (s, i) => i -> s
    }.toMap

    illustrations(ind)
  }
}

