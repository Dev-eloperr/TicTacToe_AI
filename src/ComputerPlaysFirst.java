class ComputerPlaysFirst extends TicTacFunc{

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
        getHumanResponse();
    }

    private  void move4() {
        if (possWin('C') > 0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
        }
        else if (possWin('H') > 0){
            go(findLocationOf(possWin('H')));
        }

        else {
            go(findLocationOf(anywhere()));
        }
    }



    private  void move3() {
        if (possWin('C') > 0){
            go(findLocationOf(possWin('C')));
            System.out.println("won comp");
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



    private  void move2() {
        if (isBlank(9)){
            System.out.println("9 is blank");
            go(9);
        }

        else{
            go(3);
        }
    }



    private  void move1() {
        go(findLocationOf(5));
    }



}
