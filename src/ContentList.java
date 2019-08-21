import javax.swing.*;
import java.awt.*;

public class ContentList extends TicTacFunc{
    JTextField computerData = new JTextField();
    JTextField humanData = new JTextField();

    ContentList(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //the close operation
        setTitle("Content List");
        setSize(400,400);
        setLayout(new GridLayout(2,1));

        JPanel human = new JPanel();
        humanData.setText("Human list content:");
        human.add(humanData);
        JPanel computer = new JPanel();

        computerData.setText("Computer list content:");
        computer.add(computerData);
        add(humanData);
        add(computerData);

        setVisible(true);
    }
}
