import org.example.com.tddkatas.bowlinggame.main.BowlingGame
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BowlingGameTests {

    private lateinit var game: BowlingGame
    @BeforeEach
    fun setUp() {
       game = BowlingGame();
    }
    private fun rollMany(n: Int, pins: Int) {
        repeat(n) {
            game.roll(pins);
        }
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
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17,0);
        Assertions.assertEquals(16, game.score())
    }
}