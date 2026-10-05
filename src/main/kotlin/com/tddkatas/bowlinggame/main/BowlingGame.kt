package org.example.com.tddkatas.bowlinggame.main

class BowlingGame {

    private var rolls = IntArray(21);
    private var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins;
    }
    fun score(): Int {
        var score = 0;
        var frameIndex = 0;
        repeat(10) {
            if(rolls[frameIndex] + rolls[frameIndex+1] == 10){
                score += 10 + rolls[frameIndex+2];
                frameIndex+=2;
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

}
