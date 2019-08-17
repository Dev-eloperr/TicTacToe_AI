import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [][] board = new int[3][3];
        initialise(board);

        int coinToss = (int)(Math.random()*2);

        if (coinToss == 0 ){
            computerPlaysFirst(board); //jackson
        }

        else{
            humanPlaysFirst(board); //dev
        }
    }

    private static void humanPlaysFirst(int[][] board) {
    }

    private static void computerPlaysFirst(int[][] board) {
    }

    private static void initialise(int[][] board) {
        int n = 1;

        SetXY setXY = new SetXY(3);
        for (int i = 0; i < 3 * 3; i++) {
            board[setXY.x][setXY.y] = n++;
            increment(setXY, board);
        }
    }

    private static void display(int[][] magicSquare) {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[0].length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void increment(SetXY setXY, int[][] magicSquare) {
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
}

class SetXY{
    int x;
    int y;
    SetXY(int size){
        x = 0;
        y = size/2;
    }
}

