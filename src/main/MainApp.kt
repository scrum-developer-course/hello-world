package main

import java.util.Scanner

// Hello World Application

private val scanner = Scanner(System.`in`)
fun main() {
    val playGround = PlayGround(9, 9)
    DrawGame.draw(playGround)

    for (x in 1..2) {
        println("Zadej loď $x")
        println("Zadej souřadnici pro sloupec")
        val column = scanner.nextInt() - 1
        println("Zadej souřadnici pro řádek")
        val row = scanner.nextInt() - 1
        println("Zadej délku lodě")
        val length = scanner.nextInt()
        println("Zadej směr ${ShipDirection.H.name} nebo ${ShipDirection.V.name}")
        val direction = scanner.next()
        playGround.insertShip(ShipSlim(Coordinate(row, column), length, ShipDirection.valueOf(direction)))
        DrawGame.draw(playGround)
    }

    for (x in 1..4) {
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
