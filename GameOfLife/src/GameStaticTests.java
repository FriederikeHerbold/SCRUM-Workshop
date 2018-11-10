import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStaticTests {

    @Test
    void testLestThan2Neighbours() {
        boolean[][] gird = {
                {false, false, false},
                {false, true, false},
                {false, false, true},
        };

        assertFalse(Game.isAliveInNextGen(gird));
    }

    @Test
    void testMoreThan3Neighbours() {
        boolean[][] gird = {
                {true, true, true},
                {false, true, false},
                {false, false, true},
        };

        assertFalse(Game.isAliveInNextGen(gird));
    }

    @Test
    void testAllNeighboursAlive() {
        boolean[][] gird = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        assertFalse(Game.isAliveInNextGen(gird));
    }
    @Test
    void testCountNeibours(){
        boolean[][] gird = {
                {false, false, false},
                {false, true, false},
                {false, false, true},
        };
        assertEquals(1,Game.countAliveNeighbours(gird));

        boolean[][]   gird2 = {
                {false, false, false},
                {false, true, false},
                {false, true, true},
        };
        assertEquals(2,Game.countAliveNeighbours(gird2));
    }
    @Test
    void test2Neighbours() {
        boolean[][] gird = {
                {false, false, false},
                {true, true, false},
                {false, false, true},
        };

        assertTrue(Game.isAliveInNextGen(gird));
    }
    @Test
    void test3neighbours() {
        boolean[][] gird = {
                {false, true, false},
                {true, true, false},
                {false, false, true},
        };

        assertTrue(Game.isAliveInNextGen(gird));
    }
    @Test
    void testDesdGetsAlive() {
        boolean[][] gird = {
                {false, true, false},
                {true, false, false},
                {false, false, true},
        };

        assertTrue(Game.isAliveInNextGen(gird));
    }


    @Test
    void testWrap() {
        Game game = new Game();
        assertEquals(0, game.wrap(-2, 2));
        assertEquals(1, game.wrap(-1, 2));
        assertEquals(0, game.wrap(0, 2));
        assertEquals(1, game.wrap(1, 2));
        assertEquals(0, game.wrap(2, 2));

    }
 /*   @Test
    void testStep() {
        boolean[][] gird1 = {
                {false, false, false,false},
                {true, false, false,false},
                {false, false, false,false},
        };

        boolean[][] gird2 = {
                {false, false, false,false},
                {false, false, false,false},
                {false, false, false,false},
        };

        assertEquals(grid2,Game.);
    }
*/

}
