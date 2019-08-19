import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int [][] board = new int[3][3];
    static ArrayList<Integer> computerList = new ArrayList<>(); //saves the moves made by AI
    static ArrayList<Integer> humanList = new ArrayList<>();    //saves the moves made by human
    //
    // static Board b = new Board();

    public static void main(String[] args) {
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.initialise(board);

        int coinToss = 1;
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
        System.out.println(humanList+"  "+computerList);
        move2_h();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);

        getHumanResponse();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);
        move4_h();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);

        getHumanResponse();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);
        move6_h();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);

        getHumanResponse();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);
        move8_h();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);

        getHumanResponse();
        updateBoardUI();
        System.out.println(humanList+"  "+computerList);
    }
    private static void move2_h(){
        if (isBlank(5)){
            go(5);
        }else
            go(1);
    }

    private static void make_2(){
        if (isBlank(5))
            go(5);
        else if (isBlank(2))
            go(2);
        else if (isBlank(4))
            go(4);
        else if (isBlank(8))
            go(8);
        else if (isBlank(6))
            go(6);

    }

    private static void move4_h() {
        if (possWin('H') > 0){
            go(findLocationOf(possWin('H')));
        }
        else{
            make_2();
        }
    }
    private static void move6_h(){
        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
        }
        else if (possWin('H')>0){
            System.out.println("block");
            go(findLocationOf(possWin('H')));
        }
        else
            make_2();
    }

    private static void move8_h(){
        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won in 8");
        }
        else if (possWin('H')>0){
            System.out.println("blocking move 8");
            go(findLocationOf(possWin('H')));
        }
        else
            go(findLocationOf(anywhere()));
    }

    private static void computerPlaysFirst(int[][] board) {
        move1();
        updateBoardUI();
        getHumanResponse();

        System.out.println(humanList+"  "+computerList);

        move2();
        updateBoardUI();System.out.println(humanList+"  "+computerList);
        getHumanResponse();

        move3();
        updateBoardUI();System.out.println(humanList+"  "+computerList);
        getHumanResponse();

        move4();
        updateBoardUI();System.out.println(humanList+"  "+computerList);
        getHumanResponse();

        move4();
        updateBoardUI();System.out.println(humanList+"  "+computerList);
        getHumanResponse();

        
    }

    private static void move4() {
        if (possWin('C') > 0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            return;
        }
        else if (possWin('H') > 0){
            go(findLocationOf(possWin('H')));
            return;
        }

        else {
            go(findLocationOf(anywhere()));
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
            go(findLocationOf(possWin('C')));
            System.out.println("won comp");
            return;
        }
        else if (possWin('H') > 0){
            go(findLocationOf(possWin('H')));
            System.out.println("block");
        }

        else if(isBlank(7)){
            go(7);
            System.out.println("7 is empty");
        }
        else {
            System.out.println("3 is empty");
            go(3);
        }

    }

    private static int possWin(char c) {
        if (c == 'C') {
            for (int i = 0 ; i < computerList.size(); i ++){
               for (int j = i+1 ; j < computerList.size() ; j++ ){
                   int d = 15 - computerList.get(i) - computerList.get(j);
                   System.out.println("difference is: "+d);
                   if (isBlank(findLocationOf(d)) && d<10 && d>0){
                       System.out.println("found d");
                       return d;
                  }
               }
            }
        }
        else {
            for (int i = 0 ; i < humanList.size(); i ++){
                for (int j = i+1 ; j < humanList.size() ; j++ ){
                    int d = 15 - humanList.get(i) - humanList.get(j);
                    if (isBlank(findLocationOf(d)) && d<10 && d>0){
                        return d;
                    }
                }
            }
        }

        return 0;
    }

    private static void move2() {
        if (isBlank(9)){
            System.out.println("9 is blank");
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
        humanList.add(transpose(s.nextInt()));
    }

    private static void updateBoardUI() {
        char [][] b = new char[3][3];
        int i;
        for (int j = 1; j < 10 ; j++){
            if (isBlank(findLocationOf(j))){
                i = findLocationOf(j);
                b[(i-1)/3][(i-1)%3] = '-';
            }
            else if(computerList.contains(j)){
                i = findLocationOf(j);
                b[(i-1)/3][(i-1)%3] = 'X';
            }
            else if(humanList.contains(j)){
                i = findLocationOf(j);
                b[(i-1)/3][(i-1)%3] = 'O';
            }
        }

        for (i = 0; i < b.length; i++) {
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
        go(findLocationOf(5));
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
        i = transpose(i);
        computerList.add(i);
    }

}

