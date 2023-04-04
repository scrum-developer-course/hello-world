package main

class Game(
    val firstPlayer: Player,
    val secondPlayer: Player
) {
    fun getActualPlayer(): Player {
        return if(firstPlayer.playGround.getHits().size > secondPlayer.playGround.getHits().size){
            secondPlayer
        } else {
            firstPlayer
        }
    }
}