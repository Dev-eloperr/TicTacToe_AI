import java.util.ArrayList;
import java.util.Arrays;

class HumanPlaysFirst extends TicTacFunc{

    /**
     * the driver class to drive the computer moves
     */
    void start() {
        getHumanResponse();
        updateBoardUI();
        System.out.println();
        timer();

        move2_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();
        timer();

        move4_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();
        timer();

        move6_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();
        timer();

        move8_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();

        checkDraw();
    }


    /**
     * a function which defines the second move the computer plays
     */
    private void move2_h(){
        if (isBlank(5)){
            go(5);
        }else
            go(1);
    }

    /**
     * a function which makes a move in a non corner square
     */
    private void make_2(){
        if (isBlank(5))
            go(5);
        else if (isBlank(2) && isBlank(8))
            go(2);
        else if (isBlank(4) && isBlank(6))
            go(4);
        else if (isBlank(8) && isBlank(2))
            go(8);
        else if (isBlank(6) && isBlank(4))
            go(6);
        else if (isBlank(2))
            go(2);
        else if (isBlank(4))
            go(4);
        else if (isBlank(8))
            go(8);
        else if (isBlank(6))
            go(6);

    }

    private void move4_h() {
        if (possWin('H') > 0){
            go(findLocationOf(possWin('H')));
        }
        /**
         * to tackle double corner attack strategy
         * this special function is used.
         */
        else if(humanList.contains(2) && humanList.contains(5)){
            go(3);
        }else if(humanList.containsAll(Arrays.asList(transpose(6),transpose(8))) && isBlank(9)){
            go(9);
        }else if(humanList.containsAll(Arrays.asList(transpose(2),transpose(4))) && isBlank(1)){
            go(1);
        }else if(humanList.containsAll(Arrays.asList(transpose(2),transpose(6))) && isBlank(3)){
            go(3);
        }else if (humanList.containsAll(Arrays.asList(transpose(4),transpose(8))) && isBlank(7)){
            go(7);
        }
        else{
            make_2();
        }
    }

    /**
     * The sixth move of the computer
     */
    private void move6_h(){

        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            flag=1;
            updateBoardUI();
            declareWinner(flag);

        }
        else if (possWin('H')>0){
            System.out.println("block");
            /**
             * to tackle double corner attack strategy
             * this special function is used.
             */
            go(findLocationOf(possWin('H')));
        }else if(humanList.containsAll(Arrays.asList(transpose(1),transpose(6),transpose(8))) && isBlank(9)){
            go(9);
        }else if(humanList.containsAll(Arrays.asList(transpose(9),transpose(2),transpose(4))) && isBlank(1)){
            go(1);
        }else if(humanList.containsAll(Arrays.asList(transpose(7),transpose(2),transpose(6))) && isBlank(3)){
            go(3);
        }else if (humanList.containsAll(Arrays.asList(transpose(3),transpose(4),transpose(8))) && isBlank(7)){
            go(7);
        }

        else
            make_2();
    }

    /**
     * The 8 th move of the computer
     */
    private void move8_h(){
        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            flag=1;
            updateBoardUI();
            declareWinner(flag);        //if computer or player wins display it
        }
        else if (possWin('H')>0){
            System.out.println("blocking move 8");
            go(findLocationOf(possWin('H')));
        }
        else
            go(findLocationOf(anywhere()));
    }
}
