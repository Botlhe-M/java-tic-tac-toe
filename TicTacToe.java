import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{
    Random rand = new Random();
    JFrame newFrame = new JFrame("Tic_Tac_Toe");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel resetPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton[] reset = new JButton[2];
    boolean player1_turn;

    public TicTacToe(){
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(800,800);
        newFrame.getContentPane().setBackground(new Color(50,50, 50));
        newFrame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255, 0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic_Tac_Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,400,75);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(155,25, 25));
        buttonPanel.setBounds(0, 400, 600, 500);
        for (int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        resetPanel.setLayout(new GridLayout(1,1));
        resetPanel.setBackground(Color.white);
        resetPanel.setBounds(0, 692, 800, 70);
        resetPanel.setOpaque(true);

        reset[0] = new JButton("New Game");
        reset[1] = new JButton("Close App");
        resetPanel.add(reset[0]);
        resetPanel.add(reset[1]);
        reset[0].setFont(new Font("MV Boli",Font.BOLD,60));
        reset[0].setFocusable(false);
        reset[0].addActionListener(this);
        reset[1].setFont(new Font("MV Boli",Font.BOLD,60));
        reset[1].setFocusable(true);
        reset[1].addActionListener(this);
        

        titlePanel.add(textField);
        newFrame.add(titlePanel,BorderLayout.NORTH); 
        newFrame.add(resetPanel, BorderLayout.PAGE_END); 
        newFrame.add(buttonPanel);
        

        whosTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i = 0; i < 9; i++){
        if(e.getSource() == buttons[i]){
            if(player1_turn){
                if(buttons[i].getText() == ""){
                    buttons[i].setForeground(new Color(255,0,0));;
                    buttons[i].setText("X");
                    player1_turn = false;
                    textField.setText("O turn");
                    check();
                    draw();
                }
            }
            else{
                if(buttons[i].getText() == ""){
                    buttons[i].setForeground(new Color(255,0,0));;
                    buttons[i].setText("O");
                    player1_turn = true;
                    textField.setText("X turn");
                    check();
                    draw();
                }
            }
        }
       }
       if(e.getSource() == reset[0]){
           newGame();
       }
       if(e.getSource() == reset[1]){
        System.exit(0);
       }
    }
    public void newGame(){

        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        for (int i=0 ; i<9 ; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText("");
            buttons[i].setForeground(Color.black);
            buttons[i].setBackground( new Color(red,green,blue));
        }
       whosTurn();
    }
    public void whosTurn(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if(rand.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("X turn");
        }
        else{
            player1_turn = false;
            textField.setText("O turn");
        }
    }
    public void check(){
        if(
            (buttons[0].getText().equals("X") &&
            (buttons[1].getText().equals("X") &&
            (buttons[2].getText().equals("X")
        )))){
            xWin(0, 1, 2);
        }
        else if(
            (buttons[3].getText().equals("X") &&
            (buttons[4].getText().equals("X") &&
            (buttons[5].getText().equals("X")
        )))){
            xWin(3, 4, 5);
        }
        else if(
            (buttons[6].getText().equals("X") &&
            (buttons[7].getText().equals("X") &&
            (buttons[8].getText().equals("X")
        )))){
            xWin(6, 7, 8);
        }
        else if(
            (buttons[0].getText().equals("X") &&
            (buttons[3].getText().equals("X") &&
            (buttons[6].getText().equals("X")
        )))){
            xWin(0, 3, 6);
        }
        else if(
            (buttons[0].getText().equals("X") &&
            (buttons[4].getText().equals("X") &&
            (buttons[8].getText().equals("X")
        )))){
            xWin(0, 4, 8);
        }
        else if(
            (buttons[1].getText().equals("X") &&
            (buttons[4].getText().equals("X") &&
            (buttons[7].getText().equals("X")
        )))){
            xWin(1, 4, 7);
        }
        else if(
            (buttons[2].getText().equals("X") &&
            (buttons[5].getText().equals("X") &&
            (buttons[8].getText().equals("X")
        )))){
            xWin(2, 5, 8);
        }
            else if(
            (buttons[2].getText().equals("X") &&
            (buttons[4].getText().equals("X") &&
            (buttons[6].getText().equals("X")
        )))){
            xWin(2, 4, 6);
        }
        //check O win
        else if(
            (buttons[0].getText().equals("O") &&
            (buttons[1].getText().equals("O") &&
            (buttons[2].getText().equals("O")
        )))){
            oWin(0, 1, 2);
        }
        else if(
            (buttons[3].getText().equals("O") &&
            (buttons[4].getText().equals("O") &&
            (buttons[5].getText().equals("O")
        )))){
            oWin(3, 4, 5);
        }
        else if(
            (buttons[6].getText().equals("O") &&
            (buttons[7].getText().equals("O") &&
            (buttons[8].getText().equals("O")
        )))){
            oWin(6, 7, 8);
        }
        else if(
            (buttons[0].getText().equals("O") &&
            (buttons[3].getText().equals("O") &&
            (buttons[6].getText().equals("O")
        )))){
            oWin(0, 3, 6);
        }
        else if(
            (buttons[0].getText().equals("O") &&
            (buttons[4].getText().equals("O") &&
            (buttons[8].getText().equals("O")
        )))){
            oWin(0, 4, 8);
        }
        else if(
            (buttons[1].getText().equals("O") &&
            (buttons[4].getText().equals("O") &&
            (buttons[7].getText().equals("O")
        )))){
            oWin(1, 4, 7);
        }
        else if(
            (buttons[2].getText().equals("O") &&
            (buttons[5].getText().equals("O") &&
            (buttons[8].getText().equals("O")
        )))){
            oWin(2, 5, 8);
        }
        else if(
            (buttons[2].getText().equals("O") &&
            (buttons[4].getText().equals("O") &&
            (buttons[6].getText().equals("O")
        )))){
            oWin(2, 4, 6);
        }
    }
    public void xWin(int a,int b,int c){
        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);
        JOptionPane.showMessageDialog(null,"Player X wins!");
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Game Over");

    }
    public void oWin(int a,int b,int c){
        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);
        JOptionPane.showMessageDialog(null,"Player O wins!");
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Game Over");

    }
    public void draw(){
        int count = 0;
        for(int i = 0; i < 9; i++){
            if(!(buttons[i].getText().equals(""))){
                count++;
            }
        }
        if(count == 9){
            JOptionPane.showMessageDialog(null,"It's a Draw!");
        }
    }
      public static void main(String args[]){
        TicTacToe newgame = new TicTacToe();
    }
}
