public class Game {
    static public boolean isAliveInNextGen(boolean[][] grid) {
        boolean isCenterAlive = grid[1][1];
        return !(countAliveNeighbours(grid) <2);
    }

   static public int countAliveNeighbours(boolean[][] grid){
       int aliveNeighbours = 0;
       for (int x = 0; x < 3; x++) {
           for (int y = 0; y < 3; y++) {
               if (x != 1 || y != 1) {
                   if (grid[x][y]) {
                       aliveNeighbours++;
                   }
               }
           }
       }
       return aliveNeighbours;
   }
}
