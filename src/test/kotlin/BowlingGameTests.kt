import org.example.com.tddkatas.bowlinggame.main.BowlingGame
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BowlingGameTests {

    private lateinit var game: BowlingGame
    @BeforeEach
    fun setUp() {
       game = BowlingGame()
    }
    private fun rollMany(n: Int, pins: Int) {
        repeat(n) {
            game.roll(pins)
        }
    }
    private fun rollSpare() {
        game.roll(5)
        game.roll(5)
    }
    @Test
    fun gutterBallTest(){
        rollMany(20, 0)
        Assertions.assertEquals(0, game.score())
    }

    @Test
    fun allOnesTest(){
        rollMany(20, 1)
        Assertions.assertEquals(20, game.score())
    }

    @Test
    fun testOneSpare(){
        rollSpare()
        game.roll(3)
        rollMany(17,0)
        Assertions.assertEquals(16, game.score())
    }



    @Test
    fun testOneStrike(){
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(16, 0)
        Assertions.assertEquals(24, game.score())
    }

    private fun rollStrike() {
        game.roll(10)
    }
}