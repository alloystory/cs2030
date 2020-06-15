public class Rubik {
    private Face[] _faces;
    public Rubik(int[][][] grid) {
        this._faces = new Face[6];
        for (int i = 0; i < grid.length; i++) {
            _faces[i] = new Face(grid[i]);
        }
    }

    public Rubik(Face[] faces) {
        this._faces = new Face[faces.length];
        for (int i = 0; i < faces.length; i++) {
            this._faces[i] = faces[i];
        }
    }

    // -----------------------------------------------------------------------------------------
    // Level 2
    public Rubik viewRight() {
        Face[] newFaces = new Face[_faces.length];
        newFaces[0] = _faces[0].rotateRight();
        newFaces[1] = _faces[2];
        newFaces[2] = _faces[3];
        newFaces[3] = _faces[5].rotateHalf();
        newFaces[4] = _faces[4].rotateLeft();
        newFaces[5] = _faces[1].rotateHalf();
        return new Rubik(newFaces);
    }

    public Rubik viewUp() {
        Face[] newFaces = new Face[_faces.length];
        newFaces[0] = _faces[5];
        newFaces[1] = _faces[1].rotateRight();
        newFaces[2] = _faces[0];
        newFaces[3] = _faces[3].rotateLeft();
        newFaces[4] = _faces[2];
        newFaces[5] = _faces[4];
        return new Rubik(newFaces);
    }

    public Rubik viewDown() {
        return this.viewUp().viewUp().viewUp();
    }

    public Rubik viewLeft() {
        return this.viewRight().viewRight().viewRight();
    }

    // -----------------------------------------------------------------------------------------
    // Level 3
    public Rubik frontfaceRight() {
        Face[] newFaces = new Face[_faces.length];
        int[][] topGrid = _faces[0].getGrid();
        int[][] leftGrid = _faces[1].rotateRight().getGrid();
        int[][] rightGrid = _faces[3].rotateLeft().getGrid();
        int[][] botGrid = _faces[4].rotateHalf().getGrid();
        int[] temp = topGrid[topGrid.length - 1];
        topGrid[topGrid.length - 1] = leftGrid[leftGrid.length - 1];
        leftGrid[leftGrid.length - 1] = botGrid[botGrid.length - 1];
        botGrid[botGrid.length - 1] = rightGrid[rightGrid.length - 1];
        rightGrid[rightGrid.length - 1] = temp;
        
        newFaces[0] = new Face(topGrid);
        newFaces[1] = new Face(leftGrid).rotateLeft();
        newFaces[2] = _faces[2].rotateRight();
        newFaces[3] = new Face(rightGrid).rotateRight();
        newFaces[4] = new Face(botGrid).rotateHalf();
        newFaces[5] = _faces[5];
        return new Rubik(newFaces);
    }
    
    public Rubik frontfaceHalf() {
        return this.frontfaceRight().frontfaceRight();
    }

    public Rubik frontfaceLeft() {
        return this.frontfaceHalf().frontfaceRight();
    }
    
    public Rubik rightfaceRight() {
        return this.viewRight().frontfaceRight().viewLeft();
    }
    
    public Rubik rightfaceLeft() {
        return this.viewRight().frontfaceLeft().viewLeft();
    }
    
    public Rubik rightfaceHalf() {
        return this.viewRight().frontfaceHalf().viewLeft();
    }
    
    public Rubik leftfaceRight() {
        return this.viewLeft().frontfaceRight().viewRight();
    }
    
    public Rubik leftfaceLeft() {
        return this.viewLeft().frontfaceLeft().viewRight();
    }
    
    public Rubik leftfaceHalf() {
        return this.viewLeft().frontfaceHalf().viewRight();
    }
    
    public Rubik upfaceRight() {
        return this.viewUp().frontfaceRight().viewDown();
    }
    
    public Rubik upfaceLeft() {
        return this.viewUp().frontfaceLeft().viewDown();
    }
    
    public Rubik upfaceHalf() {
        return this.viewUp().frontfaceHalf().viewDown();
    }
    
    public Rubik downfaceRight() {
        return this.viewDown().frontfaceRight().viewUp();
    }
    
    public Rubik downfaceLeft() {
        return this.viewDown().frontfaceLeft().viewUp();
    }
    
    public Rubik downfaceHalf() {
        return this.viewDown().frontfaceHalf().viewUp();
    }
    
    public Rubik backfaceRight() {
        return this.viewDown().viewDown().frontfaceRight().viewUp().viewUp();
    }
    
    public Rubik backfaceLeft() {
        return this.viewDown().viewDown().frontfaceLeft().viewUp().viewUp();
    }
    
    public Rubik backfaceHalf() {
        return this.viewDown().viewDown().frontfaceHalf().viewUp().viewUp();
    }    

    // -----------------------------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int i = 0;
        while (i < _faces.length) {
            String[] faceToString = _faces[i].toString().split("\n");
            if (i < 1 || i > 3) {
                for (String line : faceToString) {
                    output.append("......" + line + "......\n");
                }
                i++;
            } else {
                String[] faceTwoToString = _faces[i + 1].toString().split("\n");
                String[] faceThreeToString = _faces[i + 2].toString().split("\n");
                for (int j = 0; j < faceToString.length; j++) {
                    output.append(faceToString[j] + faceTwoToString[j] + faceThreeToString[j] + "\n");
                }
                i += 3;
            }
        }
        return output.toString();
    }
}
