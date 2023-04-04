import main.*
import org.testng.annotations.Test
import kotlin.random.Random

class TestPlayGround {

    @Test
    fun insertShip() {
        val size = 9
        val playGround = PlayGround(size, size)
        playGround.insertShip(ShipSlim(Coordinate(3,2),2, ShipDirection.V))
        playGround.insertShip(ShipSlim(Coordinate(1,8),1, ShipDirection.H))
        assert(playGround.getShips().size == 2)
    }

    @Test
    fun insertRandomShip() {
        val size = 9
        val playGround = PlayGround(size, size)
        playGround.insertShip(ShipSlim(
            position = Coordinate(
                Random.nextInt(1, size),
                Random.nextInt(1, size)
            ),
            length = Random.nextInt(1, 4),
            direction = if (Random.nextBoolean()) ShipDirection.H else ShipDirection.V
        ))
        playGround.insertShip(ShipSlim(
            position = Coordinate(
                Random.nextInt(1, size),
                Random.nextInt(1, size)
            ),
            length = Random.nextInt(1, 4),
            direction = if (Random.nextBoolean()) ShipDirection.H else ShipDirection.V
        ))
        assert(playGround.getShips().size == 2)
    }

}
