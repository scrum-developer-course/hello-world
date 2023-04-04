import main.Coordinate
import main.PlayGround
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

    @Test
    fun testShipPlayGround(){
        val playGround = PlayGround(4, 4)
        assert(!playGround.checkInsertShip(ShipSlim(Coordinate(3,3),2, ShipDirection.V)))
    }

    @Test
    fun testShipPlayGround1(){
        val playGround = PlayGround(5, 5)
        assert(playGround.checkInsertShip(ShipSlim(Coordinate(3,3),2, ShipDirection.V)))
    }

    @Test
    fun testShipPlayGround2(){
        val playGround = PlayGround(5, 5)
        playGround.insertShip(ShipSlim(Coordinate(3,3),2, ShipDirection.H))
        assert(!playGround.checkInsertShip(ShipSlim(Coordinate(3,3),2, ShipDirection.V)))
    }

    @Test
    fun testShipHits(){
        val ship = ShipSlim(Coordinate(3,2),2, ShipDirection.H)
        val hits = listOf(Coordinate(3,2),Coordinate(3,3))
        assert(ship.isSink(hits))
    }

    @Test
    fun testShipHits2(){
        val ship = ShipSlim(Coordinate(3,2),3, ShipDirection.H)
        val hits = listOf(Coordinate(3,2),Coordinate(3,3))
        assert(!ship.isSink(hits))
    }

    @Test
    fun testPlayground() {
        val playGround = PlayGround(9, 9)
        playGround.insertShip(ShipSlim(Coordinate(3,2),2, ShipDirection.H))
        playGround.insertShip(ShipSlim(Coordinate(5,6),2, ShipDirection.V))
        playGround.shoot(Coordinate(3,2))
        playGround.shoot(Coordinate(3,3))
        playGround.shoot(Coordinate(5,6))
        assert(!playGround.allShipSink())
    }


    @Test
    fun testPlayground2() {
        val playGround = PlayGround(9, 9)
        playGround.insertShip(ShipSlim(Coordinate(3,2),2, ShipDirection.H))
        playGround.insertShip(ShipSlim(Coordinate(5,6),2, ShipDirection.V))
        playGround.shoot(Coordinate(3,2))
        playGround.shoot(Coordinate(3,3))
        playGround.shoot(Coordinate(5,6))
        playGround.shoot(Coordinate(6,6))
        assert(playGround.allShipSink())
    }
    @Test
    fun testPlayground3() {
        val playGround = PlayGround(9, 9)
        playGround.insertShip(ShipSlim(Coordinate(3, 2), 2, ShipDirection.H))
        playGround.insertShip(ShipSlim(Coordinate(5, 6), 2, ShipDirection.V))
        assert(playGround.isShip(Coordinate(3, 3)) != null)
        assert(playGround.isShip(Coordinate(1, 1)) == null)
        assert(playGround.isShip(Coordinate(5, 6)) != null)

    }
}