class MagicSquare {
    /**
     * a class which makes a magic square
     * @param board
     */
    void initialise(int[][] board) {
        int n = 1;

        SetXY setXY = new SetXY(3);
        for (int i = 0; i < 3 * 3; i++) {
            board[setXY.x][setXY.y] = n++;
            increment(setXY, board);
        }
        display(board);
    }

    private void display(int[][] magicSquare) {
        /**
         * sets the gui to display the magic square
         */
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < magicSquare[0].length; j++) {
                int k = j+1 +(i*3);
                switch (k){
                        case 1: Main.b.button1.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 2: Main.b.button2.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 3: Main.b.button3.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 4: Main.b.button4.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 5: Main.b.button5.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 6: Main.b.button6.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 7: Main.b.button7.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 8: Main.b.button8.setText(Integer.toString(magicSquare[i][j]));
                        break;
                        case 9: Main.b.button9.setText(Integer.toString(magicSquare[i][j]));
                        break;
                }
                System.out.print( magicSquare[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private void increment(SetXY setXY, int[][] magicSquare) {
        /**
         * a function which runs diagonally across the matrix
         */
        int x = setXY.x;
        int y = setXY.y;
        x--;
        y++;

        if (x < 0) {
            x = magicSquare.length - 1;
        }
        if (y > magicSquare[0].length - 1) {
            y = 0;
        }
        if (magicSquare[x][y] != 0) {
            setXY.x++;
            return;
        }

        setXY.x = x;
        setXY.y = y;
    }

    class SetXY {
        /**
         * a utility class to intelligently use x and y to manipulate the magic square
         */
        int x;
        int y;

        SetXY(int size) {
            x = 0;
            y = size / 2;
        }
    }
}
