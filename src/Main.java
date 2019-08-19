import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int [][] board = new int[3][3];
    static ArrayList<Integer> computerList = new ArrayList<>(); //saves the moves made by AI
    static ArrayList<Integer> humanList = new ArrayList<>();    //saves the moves made by human

    public static void main(String[] args) {
        Board b = new Board();
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.initialise(board);

        int coinToss = 0;
        if (coinToss == 0 ){
            computerPlaysFirst(board); //jackson
        }

        else{
            humanPlaysFirst(board); //dev
        }
    }

    private static void humanPlaysFirst(int[][] board) {
        getHumanResponse();
        updateBoardUI();
        make_2();
        updateBoardUI();

        getHumanResponse();
        updateBoardUI();
        move4_h();
        updateBoardUI();

        getHumanResponse();
        updateBoardUI();
        move6_h();
        updateBoardUI();

        getHumanResponse();
        updateBoardUI();
        move8_h();
        updateBoardUI();

    }
    private static void make_2(){
        if (isBlank(5))
            go(5);
        else if (isBlank(1))
            go(1);
        else if (isBlank(3))
            go(1);
        else if (isBlank(7))
            go(1);
        else if (isBlank(9))
            go(1);

    }

    private static void move4_h() {
        if (possWin('H') > 0){
            go(possWin('H'));
        }
        else{
            make_2();
        }
    }
    private static void move6_h(){
        if (possWin('C')>0){
            go(possWin('C'));
            System.out.println("Computer Won");
            return;
        }
        else if (possWin('H')>0){
            go(possWin('H'));
        }
        else
            make_2();
    }

    private static void move8_h(){
        if (possWin('C')>0){
            go(possWin('C'));
            System.out.println("Computer Won");
            return;
        }
        else if (possWin('H')>0){
            go(possWin('H'));
        }
        else
            go(anywhere());
    }

    private static void computerPlaysFirst(int[][] board) {
        move1();
        updateBoardUI();
        getHumanResponse();

        move2();
        updateBoardUI();
        getHumanResponse();

        move3();
        updateBoardUI();
        getHumanResponse();

        move4();
        updateBoardUI();
        getHumanResponse();


        move4();
        updateBoardUI();
        getHumanResponse();

        
    }

    private static void move4() {
        if (possWin('C') > 0){
            go(possWin('C'));
            System.out.println("Computer Won");
            return;
        }
        else if (possWin('H') > 0){
            go(possWin('H'));
            return;
        }

        else {
            go(anywhere());
        }
    }

    private static int anywhere() {
        for (int i = 1 ; i < 10 ; i ++){
            if (!computerList.contains(i) && !humanList.contains(i)){
                return i;
            }
        }
        return 0;
    }

    private static void move3() {
        if (possWin('C') > 0){
            go(possWin('C'));
            return;
        }
        else if (possWin('H') > 0){
            go(possWin('H'));
            return;
        }

        else if(isBlank(7)){
            go(7);
        }
        else {
            go(3);
        }

    }

    private static int possWin(char c) {
        if (c == 'C') {
            for (int i = 0 ; i < computerList.size(); i ++){
               for (int j = i+1 ; j < computerList.size() ; j++ ){
                   int d = 15 - computerList.get(i) + computerList.get(j);
                   if (isBlank(d)){
                    return d;
                  }
               }
            }
        }
        else {
            for (int i = 0 ; i < humanList.size(); i ++){
                for (int j = i+1 ; j < humanList.size() ; j++ ){
                    int d = 15 - humanList.get(i) + humanList.get(j);
                    if (isBlank(d)){
                        return d;
                    }
                }
            }
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
        int j = transpose(i);
        if (computerList.contains(j) || humanList.contains(j)) {
            return false;
        }
        return true;
    }

    private static void getHumanResponse() {
        Scanner s = new Scanner(System.in);
        go(s.nextInt());
    }

    private static void updateBoardUI() {
        char [][] b = new char[3][3];

        for (int i = 1; i < 10 ; i++){
            b[(i-1)/3][(i-1)%3] = '1';
        }

        for (int i = 1; i < 10 ; i++){
            if (isBlank(i)){
                i = findLocationOf(i);
                b[(i-1)/3][(i-1)%3] = 'M';
            }
            else if(computerList.contains(i)){
                i = findLocationOf(i);
                b[(i-1)/3][(i-1)%3] = 'X';
            }
            else if(humanList.contains(i)){
                i = findLocationOf(i);
                b[(i-1)/3][(i-1)%3] = 'O';
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findLocationOf(int i) {
        switch (i){
            case 1: return 2;
            case 2: return 9;
            case 3: return 4;
            case 4: return 7;
            case 5: return 5;
            case 6: return 3;
            case 7: return 6;
            case 8: return 1;
            case 9: return 8;
        }
        return 0;
    }

    private static void move1() {
        go(5);
    }


    static int transpose(int i){
        switch (i){
            case 1: return 8;
            case 2: return 1;
            case 3: return 6;
            case 4: return 3;
            case 5: return 5;
            case 6: return 7;
            case 7: return 4;
            case 8: return 9;
            case 9: return 2;
        }
        return 0;
    }


    private static void go(int i) {
        if (i == 1)
            computerList.add(8);
        if (i == 2)
            computerList.add(1);
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

}

