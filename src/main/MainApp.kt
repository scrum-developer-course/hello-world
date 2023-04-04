package main

import java.util.Scanner

// Hello World Application

const val PLAYGROUND_SIZE = 9
const val COUNT_OF_SHIPS = 2

private val scanner = Scanner(System.`in`)
fun main() {
    println("Vítejte ve hře LODĚ")
    println()
    println(
        "                __/___            \n" +
            "          _____/______|           \n" +
            "  _______/_____\\_______\\_____     \n" +
            "  \\              < < <       |    \n" +
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
    )
    println()
    println("Zadej velikost pole: ")
    // TODO - uncomment
//    val size = scanner.nextInt()
    val size = PLAYGROUND_SIZE

    val playGround = PlayGround(size, size)
    DrawGame.draw(playGround)

    val columns = listOf(4, 5)
    val rows = listOf(2, 6)
    val lengths = listOf(3, 2)
    val directions = listOf("V", "H")

    for (x in 0 until COUNT_OF_SHIPS) {
        println("Zadej loď $x")
        println("Zadej souřadnici pro sloupec")
//        val column = scanner.nextInt() - 1
        val column = columns[x] - 1
        println("Zadej souřadnici pro řádek")
//        val row = scanner.nextInt() - 1
        val row = rows[x] - 1
        println("Zadej délku lodě")
//        val length = scanner.nextInt()
        val length = lengths[x]
        println("Zadej směr ${ShipDirection.H.name} nebo ${ShipDirection.V.name}")
//        val direction = scanner.next()
        val direction = directions[x]
        playGround.insertShip(ShipSlim(Coordinate(row, column), length, ShipDirection.valueOf(direction)))
        DrawGame.draw(playGround)
    }

    while (true) {
        println("Zadej souradnice pro vystrel")
        println("Zadej sloupec")
        val column = scanner.nextInt() - 1
        println("Zadej řádek")
        val row = scanner.nextInt() - 1
        val isHit = playGround.shoot(Coordinate(row, column))
        DrawGame.draw(playGround)
        if (isHit) {
            println("Vaše lod byla zasazena")
        } else {
            println("Vedle")
        }
    }
}
