package main

enum class ShipDirection {
    V, H
}
class ShipSlim(
    private val position: Coordinate,
    private val length: Int,
    private val direction: ShipDirection,
) : Ship {

    override fun isShip(coordinate: Coordinate): Boolean {
        return if (direction == ShipDirection.H) {
            coordinate.x == position.x && (coordinate.y - position.y) >= 0 && (coordinate.y - position.y) < length
        } else {
            coordinate.y == position.y && (coordinate.x - position.x) >= 0 && (coordinate.x - position.x) < length
        }
    }

    override fun isSink(shots: Collection<Coordinate>): Boolean {
        return shots.filter { isShip(it) }.size == length
    }

    override fun getShipCoordinate(): Set<Coordinate> {

        val coordinates = mutableSetOf<Coordinate>()
        if(direction == ShipDirection.H) {
            for (y in 0 .. length) {
                coordinates.add(Coordinate(position.x,position.y + y))
            }
        } else {
            for (x in 0 .. length){
                coordinates.add(Coordinate(position.x + x,position.y))
            }
        }
        return coordinates
    }
}
