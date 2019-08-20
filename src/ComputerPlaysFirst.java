class ComputerPlaysFirst extends TicTacFunc{
    /**
     * A driver class which drives the computer's moves when it plays first
     */
    void start() {
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
        checkDraw();
    }

    /**
     * the 4th move
     */
    private  void move4() {
        if (possWin('C') > 0){              // if computer can win, go ahead and win
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            flag=1;
            updateBoardUI();
            declareWinner(flag);
        }
        else if (possWin('H') > 0){             //if human can win block it
            go(findLocationOf(possWin('H')));
        }

        else {
            go(findLocationOf(anywhere()));         // else go anywhere
        }
    }



    private  void move3() {
        if (possWin('C') > 0){
            go(findLocationOf(possWin('C')));
            System.out.println("won comp");
            flag=1;
            updateBoardUI();
            declareWinner(flag);
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



    private  void move2() {                     //the move computer plays second time
        if (isBlank(9)){
            System.out.println("9 is blank");
            go(9);
        }

        else{
            go(3);
        }
    }
    private  void move1() {                     //the move computer plays first
        go(findLocationOf(5));
    }
}