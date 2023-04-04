package main

import kotlin.math.abs

interface Ship {

    fun isShip(coordinate: Coordinate): Boolean

    fun isSink(shots: Collection<Coordinate>): Boolean

    fun getShipCoordinate(): Set<Coordinate>

    fun hasConflict(ship: Ship): Boolean {
        return !getShipCoordinate().any { currentCoordinate ->
            ship.getShipCoordinate().any {
                abs(it.y-currentCoordinate.y)<=1 && abs(it.x - currentCoordinate.x) <= 1
            }
        }
    }
}
