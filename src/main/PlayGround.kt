package main

import java.lang.Exception

class PlayGround(val width: Int, val height: Int) {

    private val ships = mutableListOf<Ship>()
    private val hits = mutableListOf<Coordinate>()

    fun checkInsertShip(ship: Ship): Boolean {
        return ships.any { it.hasConflict(ship) }
    }
    fun insertShip(ship: Ship) {
        ships.add(ship)
    }
    fun canShoot(coordinate: Coordinate) = !hits.contains(coordinate)

    fun shoot(coordinate: Coordinate): Boolean {
        return if (canShoot(coordinate)) {
            hits.add(coordinate)
            isShip(coordinate)
        } else {
            throw Exception("Is already")
        }
    }

    fun getHits(): List<Coordinate> = hits

    fun isShip(coordinate: Coordinate): Boolean {
        return ships.any { it.isShip(coordinate) }
    }

    fun allShipSink() : Boolean {
        return ships.all { it.isSink(hits) }
    }
}
