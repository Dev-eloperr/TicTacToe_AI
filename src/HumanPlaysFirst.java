class HumanPlaysFirst extends TicTacFunc{

    void start() {
        getHumanResponse();
        updateBoardUI();
        System.out.println();

        move2_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();

        move4_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();

        move6_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();

        move8_h();
        updateBoardUI();
        System.out.println();

        getHumanResponse();
        updateBoardUI();
        System.out.println();
    }

    private void move2_h(){
        if (isBlank(5)){
            go(5);
        }else
            go(1);
    }

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
        else if(humanList.contains(2)){
            go(3);
        }
        else{
            make_2();
        }
    }
    private void move6_h(){
        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            flag=1;

        }
        else if (possWin('H')>0){
            System.out.println("block");
            go(findLocationOf(possWin('H')));
        }
        else
            make_2();
    }

    private void move8_h(){
        if (possWin('C')>0){
            go(findLocationOf(possWin('C')));
            System.out.println("Computer Won");
            flag=1;
        }
        else if (possWin('H')>0){
            System.out.println("blocking move 8");
            go(findLocationOf(possWin('H')));
        }
        else
            go(findLocationOf(anywhere()));
    }
}
