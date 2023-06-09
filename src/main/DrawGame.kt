package main

enum class Color(val hex: String) {

    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m")

}

class DrawGame {

    companion object {
        fun draw(playGround: PlayGround, hideShips: Boolean = false) {
            // print column numbers
            print("   ")
            for (x in 1..playGround.width) {
                print(" $x ")
            }
            println()
            print("   ")
            for (x in 1..playGround.height) {
                print("---")
            }
            println()
            // print playground
            for (x in 0 until playGround.width) {
                // row number
                print(x + 1)
                print(" |")
                // playground
                for (y in 0 until playGround.height) {
                    val shot = Coordinate(x, y)
                    val isShip = playGround.isShip(Coordinate(x, y))
                    when {
                        // zasah lodi
                        playGround.getHits().contains(shot) && isShip != null -> {
                            print(Color.ANSI_RED.hex + " X " + Color.ANSI_RESET.hex)
                        }
                        // strela mimo
                        playGround.getHits().contains(shot) && isShip == null -> {
                            print(" 0 ")
                        }

                        playGround.isShip(Coordinate(x, y)) != null -> {
                            if (!hideShips) print(Color.ANSI_YELLOW.hex + " * " + Color.ANSI_RESET.hex)
                            else print(Color.ANSI_BLUE.hex + " ~ " + Color.ANSI_RESET.hex)
                        }

                        else -> print(Color.ANSI_BLUE.hex + " ~ " + Color.ANSI_RESET.hex)
                    }
                }
                println()
            }
        }
    }
}
