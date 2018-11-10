import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {
    static Game game;
    @BeforeAll
    static void createGame() {
        game = new Game(4,3);
    }

      @Test
    void testStep() {
          game = new Game(3,4);
        boolean[][] grid1 = {
                {false, false, false,false},
                {true, false, false,false},
                {false, false, false,false},
        };

        boolean[][] grid2 = {
                {false, false, false,false},
                {false, false, false,false},
                {false, false, false,false},
        };

        assertArrayEquals(grid2,game.nextStep(grid1));
    }

}
