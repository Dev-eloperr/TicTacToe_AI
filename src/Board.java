import javax.swing.*;
import java.awt.*;

/**
 * A class which presents the graphical user interface of the tic tac toe board game.
 */

class Board extends TicTacFunc {
    boolean isClicked = false;
    int buttonNo = 0;
    /**
     * 9 buttons representing the nine tiles of the game
     */
    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button2 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();

       Board(){
           /**
            * setting the color to white of each tile
            */
           
           button1.setBackground(Color.white);
           button2.setBackground(Color.white);
           button3.setBackground(Color.white);
           button4.setBackground(Color.white);
           button5.setBackground(Color.white);
           button6.setBackground(Color.white);
           button7.setBackground(Color.white);
           button8.setBackground(Color.white);
           button9.setBackground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //the close operation
        setTitle("Tic Tac Toe");
        setSize(400,400);
        setLayout(new GridLayout(3,3));
           button1.setFont(new Font("Arial", Font.PLAIN, 80));
           button2.setFont(new Font("Arial", Font.PLAIN, 80));
           button3.setFont(new Font("Arial", Font.PLAIN, 80));
           button4.setFont(new Font("Arial", Font.PLAIN, 80));
           button5.setFont(new Font("Arial", Font.PLAIN, 80));
           button6.setFont(new Font("Arial", Font.PLAIN, 80));
           button7.setFont(new Font("Arial", Font.PLAIN, 80));
           button8.setFont(new Font("Arial", Font.PLAIN, 80));
           button9.setFont(new Font("Arial", Font.PLAIN, 80));

           /**
            * The action listeners which listen for button click to see what the player has played
            */
           button1.addActionListener(e -> {
                isClicked = true;
                buttonNo = 1;
               System.out.println("button 1 is clicked");
           });
           button2.addActionListener(e -> {
               isClicked = true;
               buttonNo = 2;
           });
           button3.addActionListener(e -> {
               isClicked = true;
               buttonNo = 3;
           });
           button4.addActionListener(e -> {
               isClicked = true;
               buttonNo = 4;
           });
           button5.addActionListener(e -> {
               isClicked = true;
               buttonNo = 5;
           });
           button6.addActionListener(e -> {
               isClicked = true;
               buttonNo = 6;
           });
           button7.addActionListener(e -> {
               isClicked = true;
               buttonNo = 7;
           });
           button8.addActionListener(e -> {
               isClicked = true;
               buttonNo = 8;
           });
           button9.addActionListener(e -> {
               isClicked = true;
               buttonNo = 9;
           });



            add(button1);
            add(button2);
            add(button3);
            add(button4);
            add(button5);
            add(button6);
            add(button7);
            add(button8);
            add(button9);

            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
           System.out.println(screenSize);
            setLocation((int)(screenSize.getWidth()/2.0)-200,0);
    }
}

