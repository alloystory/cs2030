public class Face {
    private int[][] _grid;
    public Face(int[][] grid) {
        int size = grid.length;
        this._grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this._grid[i][j] = grid[i][j];
            }
        }
    }

    public Face rotateRight() {
        int size = _grid.length;
        int[][] newGrid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newGrid[j][size - i - 1] = _grid[i][j];
            }
        }
        return new Face(newGrid);
    }

    public Face rotateHalf() {
        return this.rotateRight().rotateRight();
    }

    public Face rotateLeft() {
        return this.rotateRight().rotateHalf();
    }

    public int[][] getGrid() {
        int size = _grid.length;
        int[][] newGrid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newGrid[i][j] = _grid[i][j];
            }
        }
        return newGrid;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[i].length; j++) {
                output.append(String.format("%02d", _grid[i][j]));
            }
            output.append("\n");
        }
        return output.toString();
    }
}