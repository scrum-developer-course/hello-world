package main

class PlayGround(val width: Int,val height: Int ) {

    private val ships = mutableListOf<Ship>()
    private val hits = mutableListOf<Coordinate>()
    fun insertShip(ship: Ship){
        ships.add(ship)
    }

    fun shoot(coordinate: Coordinate): Boolean {
        return if(!hits.contains(coordinate)){
            hits.add(coordinate)
            isShip(coordinate)
        } else false
    }

    fun getHits(): List<Coordinate>  = hits

    fun isShip(coordinate: Coordinate): Boolean {
        return ships.any { it.isShip(coordinate) }
    }
}