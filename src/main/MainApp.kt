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
    setPlayerShips(playGroundPlayer)

    val playGroundPC = PlayGround(size, size)
    setPCShips(playGroundPC)

    while (true) {
        println("Zadej souradnice pro vystrel")
        println("Zadej sloupec")
        val column = scanner.nextInt() - 1
        println("Zadej řádek")
        val row = scanner.nextInt() - 1
        val ship = playGroundPC.shoot(Coordinate(row, column))
        val isHit = ship != null
        val isSink = playGroundPC.isSink(ship)
        println("======== MAPA PC ========")
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

fun setPlayerShips(playGround: PlayGround) {
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
        playGround.insertShip(ShipSlim(Coordinate(row, column), length, ShipDirection.valueOf(direction)))
        println("======== MAPA HRÁČE ========")
        DrawGame.draw(playGround)
    }
}

fun setPCShips(playGround: PlayGround) {
    for (x in 0 until COUNT_OF_SHIPS) {
        var validShipPosition: Boolean
        var ship = ShipSlim.buildRandomShip()
        do {
            validShipPosition = playGround.checkInsertShip(ship = ship)
            if (!validShipPosition) {
                ship = ShipSlim.buildRandomShip()
            }
        } while (!validShipPosition)

        playGround.insertShip(ship = ship)
    }
    println("======== MAPA PC ========")
    DrawGame.draw(playGround, true)
}
