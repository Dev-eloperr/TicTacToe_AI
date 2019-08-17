import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int [][] board = new int[3][3];
    static ArrayList<Integer> computerList = new ArrayList<>();
    static ArrayList<Integer> humanList = new ArrayList<>();

    public static void main(String[] args) {
        initialise(board);
        display(board);
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
        move1();
        updateBoardUI();
        getHumanResponse();
        
        updateBoardUI();
        move2();
        getHumanResponse();
        
        updateBoardUI();
        move3();
        getHumanResponse();

        updateBoardUI();
        move4();
        getHumanResponse();

        updateBoardUI();
        move5();
        getHumanResponse();

        
    }

    private static void move5() {
    }

    private static void move4() {
    }

    private static void move3() {
        if (possWin('C') > 0){
            go(possWin('C'));
        }
        
    }

    private static int possWin(char c) {
        if (c == 'C') {
           // for (int i = 0 ; i < )
        }

        return 0;
    }

    private static void move2() {
        if (isBlank(9)){
            go(9);
        }
        else{
            go(3);
        }
    }

    private static boolean isBlank(int i) {
        if (computerList.contains(i) || humanList.contains(i)) {
            return false;
        }
        return true;
    }

    private static void getHumanResponse() {
        Scanner s = new Scanner(System.in);
        humanList.add(s.nextInt());
    }

    private static void updateBoardUI() {
        
    }

    private static void move1() {
        go(5);
    }

    private static void go(int i) {
        if (i == 1)
            computerList.add(8);
        if (i == 2)
            computerList.add(9);
        if (i == 3)
            computerList.add(6);
        if (i == 4)
            computerList.add(3);
        if (i == 5)
            computerList.add(5);
        if (i == 6)
            computerList.add(7);
        if (i == 7)
            computerList.add(4);
        if (i == 8)
            computerList.add(9);
        if (i == 9)
            computerList.add(2);
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

