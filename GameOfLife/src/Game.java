public class Game {

    public boolean[][] getField() {
        return field;
    }

    private boolean[][] field;
    private int width = 20;
    private int height = 20;


    Game(int width, int height) {
        this.width = width;

        this.height = height;
        crateField();
    }



    public void crateField() {
        field = new boolean[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                field[x][y] = ((Math.random()) < 0.5);
            }
        }
    }

    public boolean[][] nextStep(boolean[][] field) {
        boolean[][] nextGenField = new boolean[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                nextGenField[x][y] = isAliveInNextGen(getGridAtIndex(field, x, y));
            }
        }
        return nextGenField;
    }
    public void nextGen() {
        field = nextStep(field);
    }

    public int wrap(int index, int count) {
        return Math.abs(index) % count;
    }

    public boolean[][] getGridAtIndex(boolean[][] field, int x, int y) {
        boolean[][] grid = {
        {
                field[wrap(x - 1, width)][wrap(y - 1, height)],
                field[wrap(x - 1, width)][wrap(y, height)],
                field[wrap(x - 1, width)][wrap(y + 1, height)],
        }, {
                field[wrap(x, width)][wrap(y - 1, height)],
                field[wrap(x, width)][wrap(y, height)],
                field[wrap(x, width)][wrap(y + 1, height)],
        }, {
                field[wrap(x + 1, width)][wrap(y - 1, height)],
                field[wrap(x + 1, width)][wrap(y, height)],
                field[wrap(x + 1, width)][wrap(y + 1, height)],
        },
        };
        return grid;
    }

    static public boolean isAliveInNextGen(boolean[][] grid) {
        boolean isCenterAlive = grid[1][1];
        int aliveNeighbours = countAliveNeighbours(grid);
        // alive
        if (isCenterAlive) {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                return false;
            }
            return true;
            // dead
        } else {
            if (aliveNeighbours == 3) {
                return true;
            }
            return false;
        }
    }

    static public int countAliveNeighbours(boolean[][] grid) {
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
