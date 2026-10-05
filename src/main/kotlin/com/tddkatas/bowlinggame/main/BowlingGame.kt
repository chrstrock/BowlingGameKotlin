package org.example.com.tddkatas.bowlinggame.main

class BowlingGame {

    private var rolls = IntArray(21)
    private var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }
    fun score(): Int {
        var score = 0
        var frameIndex = 0
        repeat(10) {
            if(isStrike(frameIndex)) // strike
            {
                score += 10 + strikeBonus(frameIndex)
                frameIndex++
            }
            else if(isSpare(frameIndex)){
                score += 10 + spareBonus(frameIndex)
                frameIndex+=2
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex + 1]
                frameIndex += 2
            }
        }
        return score
    }

    private fun strikeBonus(frameIndex: Int):Int =  rolls[frameIndex + 1] + spareBonus(frameIndex)

    private fun spareBonus(frameIndex: Int): Int = rolls[frameIndex + 2]

    private fun isStrike(frameIndex: Int): Boolean = rolls[frameIndex] == 10


    private fun isSpare(frameIndex: Int): Boolean = rolls[frameIndex] + rolls[frameIndex + 1] == 10

}
