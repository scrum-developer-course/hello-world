import main.Coordinate
import main.ShipDirection
import main.ShipSlim
import org.testng.annotations.Test
class TestShip {

    @Test
    fun testShipVertical(){
        val ship = ShipSlim(Coordinate(3,2),2, ShipDirection.V)
        assert(ship.getShipCoordinate().contains(Coordinate(3,2)))
        assert(ship.getShipCoordinate().contains(Coordinate(4,2)))
        assert(ship.getShipCoordinate().size == 2)
    }

    @Test
    fun testShipHorizontal(){
        val ship = ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        assert(ship.getShipCoordinate().contains(Coordinate(3,2)))
        assert(ship.getShipCoordinate().contains(Coordinate(3,3)))
        assert(ship.getShipCoordinate().size == 2)
    }

    @Test
    fun testShipOverlay(){
        val ship1 = ShipSlim(Coordinate(3,2),2, ShipDirection.V)
        val ship2= ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        assert(ship1.hasConflict(ship2))
    }

    @Test
    fun testShipOverlay2(){
        val ship1 = ShipSlim(Coordinate(5,2),2, ShipDirection.H)
        val ship2= ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        assert(!ship1.hasConflict(ship2))
    }

    @Test
    fun testShipOverlay3(){
        val ship1 = ShipSlim(Coordinate(4,2),2, ShipDirection.H)
        val ship2= ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        assert(ship1.hasConflict(ship2))
    }


    @Test
    fun testShipOverlay4(){
        val ship1 = ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        val ship2= ShipSlim(Coordinate(4,2),2, ShipDirection.H)
        assert(ship1.hasConflict(ship2))
    }

    @Test
    fun testShipOverlay5(){
        val ship1 = ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        val ship2= ShipSlim(Coordinate(5,2),2, ShipDirection.H)
        assert(!ship1.hasConflict(ship2))
    }

    @Test
    fun testShipOverlay6(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.H)
        val ship2= ShipSlim(Coordinate(2,4),2, ShipDirection.V)
        assert(ship1.hasConflict(ship2))
    }

    @Test
    fun testShipOverlay7(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.H)
        assert(ship1.hasConflict(3,3))
    }

    @Test
    fun testShipOverlay8(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.H)
        assert(!ship1.hasConflict(5,5))
    }

    @Test
    fun testShipOverlay9(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.H)
        assert(!ship1.hasConflict(5,5))
    }

    @Test
    fun testShipOverlay10(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.V)
        assert(!ship1.hasConflict(5,5))
    }

    @Test
    fun testShipOverlay11(){
        val ship1 = ShipSlim(Coordinate(3,3),2, ShipDirection.V)
        assert(ship1.hasConflict(4,4))
    }

}