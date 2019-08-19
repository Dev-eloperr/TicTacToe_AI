import javax.swing.*;
import java.util.ArrayList;

class TicTacFunc extends JFrame {
     ArrayList<Integer> computerList = new ArrayList<>(); //saves the moves made by AI
     ArrayList<Integer> humanList = new ArrayList<>();    //saves the moves made by human
    int flag=0;//no one won 1->C won 2->H won
    int anywhere() {
        for (int i = 1 ; i < 10 ; i ++){
            if (!computerList.contains(i) && !humanList.contains(i)){
                return i;
            }
        }
        return 0;
    }

    void declareWinner(int flag){
        if (flag == 1){
            JOptionPane.showMessageDialog(null,"Sorry! you lost.\n Better luck next time ;)");
        }
        Main.b.setVisible(false);
        System.exit(0);
    }

    void checkDraw(){
        JOptionPane.showMessageDialog(null,"This match is a Draw!");
        Main.b.setVisible(false);
        System.exit(0);
    }

    int findLocationOf(int i) {
        switch (i){
            case 1: return 2;
            case 2: return 9;
            case 3: return 4;
            case 4: return 7;
            case 5: return 5;
            case 6: return 3;
            case 7: return 6;
            case 8: return 1;
            case 9: return 8;
        }
        return 0;
    }

    int transpose(int i){
        switch (i){
            case 1: return 8;
            case 2: return 1;
            case 3: return 6;
            case 4: return 3;
            case 5: return 5;
            case 6: return 7;
            case 7: return 4;
            case 8: return 9;
            case 9: return 2;
        }
        return 0;
    }


    void go(int i) {
        i = transpose(i);
        computerList.add(i);
    }
    void timer(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     void updateBoardUI() {
        char [][] b = new char[3][3];
        int i;
        for (int j = 1; j < 10 ; j++){
            if (isBlank(findLocationOf(j))){
                i = findLocationOf(j);
                switch (i){
                    case 1: Main.b.button1.setText("");
                    break;
                    case 2: Main.b.button2.setText("");
                        break;
                    case 3: Main.b.button3.setText("");
                        break;
                    case 4: Main.b.button4.setText("");
                        break;
                    case 5: Main.b.button5.setText("");
                        break;
                    case 6: Main.b.button6.setText("");
                        break;
                    case 7: Main.b.button7.setText("");
                        break;
                    case 8: Main.b.button8.setText("");
                        break;
                    case 9: Main.b.button9.setText("");
                        break;
                }
            }
            else if(computerList.contains(j)){
                i = findLocationOf(j);
                switch (i){
                    case 1: Main.b.button1.setText("O"); Main.b.button1.setEnabled(false);
                        break;
                    case 2: Main.b.button2.setText("O"); Main.b.button2.setEnabled(false);
                        break;
                    case 3: Main.b.button3.setText("O"); Main.b.button3.setEnabled(false);
                        break;
                    case 4: Main.b.button4.setText("O"); Main.b.button4.setEnabled(false);
                        break;
                    case 5: Main.b.button5.setText("O"); Main.b.button5.setEnabled(false);
                        break;
                    case 6: Main.b.button6.setText("O"); Main.b.button6.setEnabled(false);
                        break;
                    case 7: Main.b.button7.setText("O"); Main.b.button7.setEnabled(false);
                        break;
                    case 8: Main.b.button8.setText("O"); Main.b.button8.setEnabled(false);
                        break;
                    case 9: Main.b.button9.setText("O"); Main.b.button9.setEnabled(false);
                        break;
                }
            }
            else if(humanList.contains(j)){
                i = findLocationOf(j);
                switch (i){
                    case 1: Main.b.button1.setText("X"); Main.b.button1.setEnabled(false);
                        break;
                    case 2: Main.b.button2.setText("X"); Main.b.button2.setEnabled(false);
                        break;
                    case 3: Main.b.button3.setText("X"); Main.b.button3.setEnabled(false);
                        break;
                    case 4: Main.b.button4.setText("X"); Main.b.button4.setEnabled(false);
                        break;
                    case 5: Main.b.button5.setText("X"); Main.b.button5.setEnabled(false);
                        break;
                    case 6: Main.b.button6.setText("X"); Main.b.button6.setEnabled(false);
                        break;
                    case 7: Main.b.button7.setText("X"); Main.b.button7.setEnabled(false);
                        break;
                    case 8: Main.b.button8.setText("X"); Main.b.button8.setEnabled(false);
                        break;
                    case 9: Main.b.button9.setText("X"); Main.b.button9.setEnabled(false);
                        break;
                }
            }
        }

        for (i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    void getHumanResponse() {
        while(true){
            System.out.println("Waiting");
            if (Main.b.isClicked){
                humanList.add(transpose(Main.b.buttonNo));
                Main.b.isClicked = false;
                break;
            }
        }
    }

    boolean isBlank(int i) {
        int j = transpose(i);
        return !computerList.contains(j) && !humanList.contains(j);
    }

    int possWin(char c) {
        if (c == 'C') {
            for (int i = 0 ; i < computerList.size(); i ++){
                for (int j = i+1 ; j < computerList.size() ; j++ ){
                    int d = 15 - computerList.get(i) - computerList.get(j);
                    System.out.println("difference is: "+d);
                    if (isBlank(findLocationOf(d)) && d<10 && d>0){
                        System.out.println("found d");
                        return d;
                    }
                }
            }
        }
        else {
            for (int i = 0 ; i < humanList.size(); i ++){
                for (int j = i+1 ; j < humanList.size() ; j++ ){
                    int d = 15 - humanList.get(i) - humanList.get(j);
                    if (isBlank(findLocationOf(d)) && d<10 && d>0){
                        return d;
                    }
                }
            }
        }

        return 0;
    }

}
