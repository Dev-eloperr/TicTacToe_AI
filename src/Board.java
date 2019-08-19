import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    public boolean isClicked = false;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
       setSize(800,800);
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

           button1.addActionListener(e -> {
                isClicked = true;
                Main.humanList.add(Main.transpose(1));
               System.out.println("button 1 is clicked");
           });
           button2.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(2));
           });
           button3.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(3));
           });
           button4.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(4));
           });
           button5.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(5));
           });
           button6.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(6));
           });
           button7.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(7));
           });
           button8.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(8));
           });
           button9.addActionListener(e -> {
               isClicked = true;
               Main.humanList.add(Main.transpose(9));
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
    }

}
