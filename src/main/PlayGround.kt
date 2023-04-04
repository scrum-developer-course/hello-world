package main


class PlayGround(val width: Int, val height: Int) {

    private val ships = mutableListOf<Ship>()
    private val hits = mutableListOf<Coordinate>()

    fun checkInsertShip(ship: Ship): Boolean {
        return !ship.hasConflict(width,height) && ships.all { !it.hasConflict(ship) }
    }

    fun insertShip(ship: Ship) {
        if(checkInsertShip(ship)){
            ships.add(ship)
        } else {
            throw Error("Error")
        }
    }

    fun canShoot(coordinate: Coordinate) = !hits.contains(coordinate)

    fun shoot(coordinate: Coordinate): Ship? {
        hits.add(coordinate)
        return isShip(coordinate)
    }

    fun isSink(ship: Ship?): Boolean {
        return ship?.isSink(hits) ?: false
    }

    fun getHits(): List<Coordinate> = hits

    fun getShips(): List<Ship> = ships

    fun isShip(coordinate: Coordinate): Ship? {
        return ships.find { it.isShip(coordinate) }
    }

    fun allShipSink(): Boolean {
        return ships.all { it.isSink(hits) }
    }
}
