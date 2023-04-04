package main

interface Ship {

    fun isShip(coordinate: Coordinate): Boolean

    fun isSink(shots: Collection<Coordinate>): Boolean
}
