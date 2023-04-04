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
        return getShipCoordinate().all { shots.contains(it) }
    }

    override fun getShipCoordinate(): Set<Coordinate> {

        val coordinates = mutableSetOf<Coordinate>()
        if(direction == ShipDirection.H) {
            for (y in 0 until length) {
                coordinates.add(Coordinate(position.x,position.y + y))
            }
        } else {
            for (x in 0 until length){
                coordinates.add(Coordinate(position.x + x,position.y))
            }
        }
        return coordinates
    }

    override fun hasConflict(x: Int, y: Int): Boolean {
        return when {
            position.x > x && position.y > y -> false
            direction == ShipDirection.H -> (position.x + length) <= x
            else -> (position.y + length) <= y
        }
    }
}
