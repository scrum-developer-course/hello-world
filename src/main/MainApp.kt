package main

import kotlin.random.Random
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

    val playGroundPlayer = PlayGround(size, size)
//    println("Mapa hráče")
//    DrawGame.draw(playGroundPlayer)

    val columns = listOf(4, 5)
    val rows = listOf(2, 6)
    val lengths = listOf(3, 2)
    val directions = listOf("V", "H")

    for (x in 0 until COUNT_OF_SHIPS) {
        println("Zadej loď ${x + 1}")
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
        playGroundPlayer.insertShip(ShipSlim(Coordinate(row, column), length, ShipDirection.valueOf(direction)))
        println("======== MAPA HRÁČE ========")
        DrawGame.draw(playGroundPlayer)
    }

    val playGroundPC = PlayGround(size, size)
    println("Mapa PC")

    for (x in 0 until COUNT_OF_SHIPS) {
        playGroundPC.insertShip(
            ship = ShipSlim(
                position = Coordinate(
                    Random.nextInt(1, PLAYGROUND_SIZE),
                    Random.nextInt(1, PLAYGROUND_SIZE)
                ),
                length = Random.nextInt(1, 4),
                direction = if (Random.nextBoolean()) ShipDirection.H else ShipDirection.V
            )
        )
    }
    println("======== MAPA PC ========")
    DrawGame.draw(playGroundPC, true)

    while (true) {
        println("Zadej souradnice pro vystrel")
        println("Zadej sloupec")
        val column = scanner.nextInt() - 1
        println("Zadej řádek")
        val row = scanner.nextInt() - 1
        val isHit = playGroundPlayer.shoot(Coordinate(row, column))
        DrawGame.draw(playGroundPlayer)
        if (isHit) {
            println("Vaše lod byla zasazena")
        } else {
            println("Vedle")
        }
    }
}
