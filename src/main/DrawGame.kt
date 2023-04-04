package main

class DrawGame {

    companion object {
        fun draw(playGround: PlayGround){
            print("   ")
            for(x in 1 ..  playGround.width){
                print( " $x ")
            }
            println()
            print("   ")
            for(x in 1 ..  playGround.width){
                print( "---")
            }
            println()
            for(x in 0 until  playGround.width){
                print(x+1)
                print(" |")
                for (y in 0 until  playGround.height){
                    val shot = Coordinate(x,y)
                    val isShip = playGround.isShip(Coordinate(x,y))
                    when{
                        playGround.getHits().contains(shot) && isShip ->  {
                            print(" X ")
                        }
                        playGround.getHits().contains(shot) && !isShip ->  {
                            print(" 0 ")
                        }
                        playGround.isShip(Coordinate(x,y)) ->print(" 1 ")
                        else -> print(" . ")
                    }

                }
                println()
            }
        }
    }
}