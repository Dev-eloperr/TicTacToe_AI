import javax.swing.*;

public class Main {
    static Board b = new Board();
    public static void main(String[] args) {
        int [][] board = new int[3][3];
        MagicSquare magicSquare = new MagicSquare();
        magicSquare.initialise(board);

        Object[] options1 = { "Play first","Computer plays first"};

        JPanel panel = new JPanel();
        panel.add(new JLabel("Make a decision"));

        int result = JOptionPane.showOptionDialog(null, panel, "TicTacToe",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        System.out.println(result);
        if (result != JOptionPane.YES_OPTION) {
            ComputerPlaysFirst computerPlaysFirst = new ComputerPlaysFirst(); //jackson
            computerPlaysFirst.start();
            //Main.b.setVisible(true);
        }
        else{
            HumanPlaysFirst humanPlaysFirst = new HumanPlaysFirst();
            humanPlaysFirst.start();
            //Main.b.setVisible(true);
        }
    }
}

