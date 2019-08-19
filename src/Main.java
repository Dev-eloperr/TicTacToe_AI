public class Main {
    static Board b = new Board();
    public static void main(String[] args) {
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

