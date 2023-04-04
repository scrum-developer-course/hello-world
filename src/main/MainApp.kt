package main

import kotlin.random.Random
import java.util.Scanner
import kotlin.system.exitProcess

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

    for (x in 0 until COUNT_OF_SHIPS) {
        var validShipPosition: Boolean
        var ship = ShipSlim.buildRandomShip()
        do {
            validShipPosition = playGroundPC.checkInsertShip(ship = ship)
            if (!validShipPosition) {
                ShipSlim.buildRandomShip()
            }
        } while (!validShipPosition)

        playGroundPC.insertShip(ship = ship)
    }
    println("======== MAPA PC ========")
    DrawGame.draw(playGroundPC, true)

    while (true) {
        println("Zadej souradnice pro vystrel")
        println("Zadej sloupec")
        val column = scanner.nextInt() - 1
        println("Zadej řádek")
        val row = scanner.nextInt() - 1
        val ship = playGroundPC.shoot(Coordinate(row, column))
        val isHit = ship != null
        val isSink = playGroundPC.isSink(ship)
        DrawGame.draw(playGroundPC)

        if (isHit && isSink) {
            println("Loď potopena")
        } else if (isHit) {
            println("Zásah")
        } else println("Vedle")

        if (playGroundPC.allShipSink()) {
            println("Vyhrál jsi")
            exitProcess(0)
        }
    }
}
