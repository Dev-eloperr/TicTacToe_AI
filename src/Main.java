import javax.swing.*;

public class Main {
    static Board b = new Board();
    static ContentList contentList = new ContentList();
    /**
     * the driver function to start the code
     * @param args
     */
    public static void main(String[] args) {
        int [][] board = new int[3][3];
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.initialise(board);

        Object[] options1 = { "Play first","Computer plays first"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Make a decision"));
        /**
         * Makes the player choose whether he wants to play first or second
         */

        int result = JOptionPane.showOptionDialog(null, panel, "TicTacToe",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        System.out.println(result);
        if (result != JOptionPane.YES_OPTION) {
            ComputerPlaysFirst computerPlaysFirst = new ComputerPlaysFirst(); //jackson
            computerPlaysFirst.start();
        }
        else{
            HumanPlaysFirst humanPlaysFirst = new HumanPlaysFirst();
            humanPlaysFirst.start();
        }


    }
}

