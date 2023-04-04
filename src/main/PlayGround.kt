package main


class PlayGround(val width: Int, val height: Int) {

    private val ships = mutableListOf<Ship>()
    private val hits = mutableListOf<Coordinate>()

    fun checkInsertShip(ship: Ship): Boolean {
        return !ship.hasConflict(width,height) && ships.all { !it.hasConflict(ship) }
    }

    fun insertShip(ship: Ship) {
        ships.add(ship)
    }

    fun canShoot(coordinate: Coordinate) = !hits.contains(coordinate)

    fun shoot(coordinate: Coordinate): Ship {
        hits.add(coordinate)
        return isShip(coordinate)
    }

    fun isSink(ship: Ship): Boolean {
        return ship.isSink(hits)
    }

    fun getHits(): List<Coordinate> = hits

    fun isShip(coordinate: Coordinate): Ship {
        return ships.first { it.isShip(coordinate) }
    }

    fun allShipSink(): Boolean {
        return ships.all { it.isSink(hits) }
    }
}
