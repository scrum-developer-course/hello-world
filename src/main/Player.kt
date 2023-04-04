package main

data class Player(
    val playerId: String,
    val name: String,
    val width: Int,
    val height: Int,
) {
    val playGround = PlayGround(width, height)
}
