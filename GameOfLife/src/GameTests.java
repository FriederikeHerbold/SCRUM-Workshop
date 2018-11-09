import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

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
}
