package main

import java.lang.Error

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

    fun isEnd() = firstPlayer.playGround.allShipSink() || secondPlayer.playGround.allShipSink()

    fun getWinner(): Player {
        return when {
            firstPlayer.playGround.allShipSink() -> secondPlayer
            secondPlayer.playGround.allShipSink() -> firstPlayer
            else -> throw Error("Nobody win")
        }
    }

}