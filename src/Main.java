
public class Main {
    public static void main(String[] args) {
      //  Board b = new Board();
        int [][] board = new int[3][3];
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.initialise(board);

        int coinToss = (int)(Math.random()*2);
        if (coinToss == 0 ){
            ComputerPlaysFirst computerPlaysFirst = new ComputerPlaysFirst(); //jackson
            computerPlaysFirst.start();
        }

        else{
            HumanPlaysFirst humanPlaysFirst = new HumanPlaysFirst();
            humanPlaysFirst.start(); //dev
        }
    }
}

