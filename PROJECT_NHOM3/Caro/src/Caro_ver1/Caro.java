package Caro_ver1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.io.*;
import java.sql.*;

public class Caro extends JFrame implements ActionListener {

    private JFrame f;
    private JMenuBar jmb;
    private JMenu option, about;
    private JMenuItem ng, rg, np, exit, lg, us;
    private JButton newGame,resignGame,newPlayer,ok1,ok2,ok3;
    private JButton bt[][] = new JButton[15][15];
    private JLabel player1,player2,message,message2,namePlayer1,namePlayer2,winner,loser;
    private JPanel pn1,pn2,pn3,pn4,pn5,pn6,pn7,pn8,pn9,pn10,pn11,pn12,pn13,pn14,pn15,pn16,pn17,pn18,pn19,pn20;
    private JDialog clickOther, enterName, lastGame;
    private JTextField namepl1,namepl2;
    public static final int EMPTY = 0, RED = 1, YELLOW = 2;
    int currentPlayer;
    int[][] board;
    Icon redIcon = new ImageIcon("D:/x.png");
    Icon yellowIcon = new ImageIcon("D:/o.png");
    String str1,str2,nw,nl;
    Connection sqlConnect = Connect.Con();
    
    public Caro() {
        f = new JFrame("Caro");
        
        jmb = new JMenuBar();
        option = new JMenu("Option");
        about = new JMenu("About");
        ng = new JMenuItem("New game");
        ng.addActionListener(this);
        rg = new JMenuItem("Resign Game");
        rg.addActionListener(this);
        np = new JMenuItem("New Player");
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        np.addActionListener(this);
        lg = new JMenuItem("Last Game");
        lg.addActionListener(this);
        //us = new JMenuItem("Us");
        //us.addActionListener(this);
        newGame = new JButton("NEW GAME");
        newGame.setBackground(Color.PINK);
        newGame.addActionListener(this);
        resignGame = new JButton("RESIGN GAME");
        resignGame.setBackground(Color.pink);
        resignGame.addActionListener(this);
        newPlayer = new JButton("NEW PLAYER");
        newPlayer.setBackground(Color.PINK);
        newPlayer.addActionListener(this);
        ok1 = new JButton("OK");
        ok1.addActionListener(this);
        ok2 = new JButton("OK");
        ok2.addActionListener(this);
        ok3 = new JButton("OK");
        ok3.addActionListener(this);

        player1 = new JLabel("");
        player1.setIcon(redIcon);
        player2 = new JLabel("");
        player2.setIcon(yellowIcon);
        message = new JLabel("");
        message2 = new JLabel("");
        namepl1 = new JTextField("", 10);
        namepl2 = new JTextField("", 10);
        str1 = "";
        str2 = "";
        namePlayer1 = new JLabel(str1);
        namePlayer2 = new JLabel(str2);
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        pn5 = new JPanel();
        pn6 = new JPanel();
        pn7 = new JPanel();
        pn8 = new JPanel();
        pn9 = new JPanel();
        pn10 = new JPanel();
        pn11 = new JPanel();
        pn12 = new JPanel();
        pn13 = new JPanel();
        pn14 = new JPanel();
        pn15 = new JPanel();
        pn16 = new JPanel();
        pn17 = new JPanel();
        pn18 = new JPanel();
        clickOther = new JDialog(clickOther, "");
        enterName = new JDialog(enterName, "Enter name of Players");
        board = new int[15][15];
    }

    public void creatBt() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                bt[i][j] = new JButton();
                bt[i][j].setBackground(Color.CYAN);
                bt[i][j].addActionListener(this);
            }
        }
    }
    
    public void creatDialog1(){
        clickOther.setSize(400, 150);
        clickOther.setLocation(620, 350);
        clickOther.setLayout(new GridLayout(2, 1));
        clickOther.add(pn8);
        pn8.add(message2);
        clickOther.add(pn9);
        pn9.add(ok1);
        clickOther.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        clickOther.setVisible(true);
    }
    
    public void creatDialog2(){
        enterName.setBounds(620, 350, 400, 150);
        enterName.setLayout(new GridLayout(3, 1));
        enterName.add(pn11);
        pn11.setLayout(new GridLayout(1,2));
        pn11.add(player1);
        pn11.add(namepl1);
        enterName.add(pn12);
        pn12.setLayout(new GridLayout(1,2));
        pn12.add(player2);
        pn12.add(namepl2);
        enterName.add(pn13);
        pn13.add(ok2);
        enterName.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        enterName.setVisible(true);
    }
    
    public void creatDialog3(){
        lastGame = new JDialog(lastGame, "Last Game");
        lastGame.setBounds(620, 350, 400, 150);
        lastGame.setLayout(new GridLayout(3,1));
        winner = new JLabel("The Winner of last game :              " + getWinner());
        loser = new JLabel("The Loser of last game:                 " + getLoser());
        lastGame.add(winner);
        lastGame.add(loser);
        lastGame.add(pn18);
        pn18.add(ok3);
        lastGame.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        lastGame.setVisible(true);
    }
    public JPanel creatLocaltion() {

        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout(15, 15));
        creatBt();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                pn1.add(bt[i][j]);
            }
        }
        return pn1;
    }

    public JPanel creatCotrol() {
        JPanel pn2 = new JPanel();
        pn2.setLayout(new GridLayout(3, 1));
        pn2.add(pn3);
        pn3.setLayout(new GridLayout(3, 1));
        pn3.add(newGame);
        pn2.add(pn4);
        pn4.setLayout(new GridLayout(3, 1));
        pn4.add(resignGame);
        pn2.add(pn5);
        pn5.setLayout(new GridLayout(3, 1));
        pn5.add(newPlayer);
        return pn2;
    }
    
    public JPanel creatPlayerInfomation(){
        JPanel pn7 = new JPanel();
        pn7.setLayout(new GridLayout(3, 1));
        pn7.add(pn10);
        pn10.setLayout(new GridLayout(2, 2));
        pn10.add(player1);
        pn10.add(pn14);
        pn10.add(namePlayer1, 1);
        pn7.add(pn6);
        pn6.setLayout(new GridLayout(2, 1));
        pn6.add(player2);
        pn6.add(pn15);
        pn6.add(namePlayer2, 1);
        pn7.add(message);
        return pn7;
    }

    public void display() {
        f.setBounds(0, 0, 1000, 652);
        f.setLayout(null);
        jmb.add(option);
        jmb.add(about);
        option.add(ng);
        option.add(rg);
        option.add(np);
        option.add(exit);
        about.add(lg);
        //about.add(us);
        pn1 = creatLocaltion();
        pn1.setBounds(0, 0, 600, 600);
        pn2 = creatCotrol();
        pn2.setBounds(725, 50, 150, 300);
        pn7 = creatPlayerInfomation();
        pn7.setBounds(650, 400, 250, 210);
        f.add(pn1);
        f.add(pn2);
        f.add(pn7);
        f.setJMenuBar(jmb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocation(300, 100);
        f.setVisible(true);
        ClickNewPlayer();
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == newGame) {
            ClickNewGame();
        }
        if (src == resignGame) {
            ClickResignGame();
        }
        if(src == ok1){
            ClickOK1();
        }
        if(src == ok2){
            ClickOK2();
        }
        if(src == ok3){
            ClickOK3();
        }
        if(src == newPlayer){
            ClickNewPlayer();
        }
        if(src == ng){
            ClickNewGame();
        }
        if(src == rg){
            ClickResignGame();
        }
        if(src == np){
            ClickNewPlayer();
        }
        if(src == exit){
            System.exit(0);
        }
        if(src == lg){
            f.setEnabled(false);
            creatDialog3();
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (src == bt[i][j]) {
                    doClickSquare(i, j);
                }
            }
        }
    }
    
    public void ClickNewGame() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = EMPTY;
                bt[i][j].setBackground(Color.CYAN);
                bt[i][j].setIcon(null);
                bt[i][j].setEnabled(true);
            }
        }
        currentPlayer = RED;
        message.setText(" : Make your move.");
        message.setIcon(redIcon);
        newGame.setEnabled(false);
        ng.setEnabled(false);
        resignGame.setEnabled(true);
        rg.setEnabled(true);
    }

    public void ClickResignGame() {

        if (currentPlayer == YELLOW) {
             if(!"".equals(str1) && !"".equals(str2)){
                    message.setIcon(null);
                    message.setText(str2 + " resigns. " + str1 + " wins.");
                    updateDB(str1,str2);
                }
             else{
                 message.setText(" win because the other resign!!!");
                 message.setIcon(redIcon);
             }
        } else {
            if(!"".equals(str1) && !"".equals(str2)){
                    message.setIcon(null);
                    message.setText(str1 + " resigns. " + str2 +" wins.");
                    updateDB(str2,str1);
                }
            else{
                 message.setText(" win because the other resign!!!");
                 message.setIcon(yellowIcon);
             }
        }
        newGame.setEnabled(true);
        ng.setEnabled(true);
        resignGame.setEnabled(false);
        rg.setEnabled(false);
        for (int u = 0; u < 15; u++) {
            for (int v = 0; v < 15; v++) {
                bt[u][v].setEnabled(false);
            }
        }
    }
    
    public void ClickNewPlayer(){
        f.setEnabled(false);
        creatDialog2();
    }
    
    void ClickOK1(){
        f.setEnabled(true);
        clickOther.setVisible(false);
    }
    
    void ClickOK2(){
        f.setEnabled(true);
        ClickNewGame();
        enterName.setVisible(false);
        str1 = namepl1.getText();
        str2 = namepl2.getText();
        namePlayer1.setText(str1);
        namePlayer2.setText(str2);
        namePlayer1.setIcon(redIcon);
        namePlayer2.setIcon(yellowIcon);
    }
    void ClickOK3(){
        f.setEnabled(true);
        lastGame.setVisible(false);
    }

    void doClickSquare(int i, int j) {
        if (board[i][j] != EMPTY) {
            if (currentPlayer == RED) {
                message.setText(" : Please click an empty square.");
                message.setIcon(redIcon);
                message2.setText(" : Please click an empty square.");
                message2.setIcon(redIcon);
                f.setEnabled(false);
                creatDialog1();
            } else {
                message.setText(" : Please click an empty square.");
                message.setIcon(yellowIcon);
                message2.setText(" : Please click an empty square.");
                message2.setIcon(yellowIcon);
                f.setEnabled(false);
                creatDialog1();
            }
            return;
        }
        board[i][j] = currentPlayer;
        if (currentPlayer == RED) {
            bt[i][j].setIcon(redIcon);
        }
        if (currentPlayer == YELLOW) {
            bt[i][j].setIcon(yellowIcon);
        }

        if (winner(i, j) != 0) {
            for (int u = 0; u < 15; u++) {
                for (int v = 0; v < 15; v++) {
                    bt[u][v].setEnabled(false);
                }
            }
            if (winner(i, j) == 1) {
                fillWin(board[i][j], i, j, 1, 0);
            }
            if (winner(i, j) == 2) {
                fillWin(board[i][j], i, j, 0, 1);
            }
            if (winner(i, j) == 3) {
                fillWin(board[i][j], i, j, 1, -1);
            }
            if (winner(i, j) == 4) {
                fillWin(board[i][j], i, j, 1, 1);
            }
            if (currentPlayer == YELLOW) {
                gameOver(str2 + " wins the game!");
                if(!"".equals(str1) && !"".equals(str2)){
                    updateDB(str2,str1);
                }
                
            } else {
                gameOver(str1 +" wins the game!");
                if(!"".equals(str1) && !"".equals(str2)){
                    updateDB(str1,str2);
                }
            }
            return;
        }

        boolean emptySpace = false;
        for (int u = 0; u < 15; u++) {
            for (int v = 0; v < 15; v++) {
                if (board[u][v] == EMPTY) {
                    emptySpace = true;
                    break;
                }
            }
        }
        if (emptySpace == false) {
                    gameOver("The game ends in a draw.");
                    return;
        }

        if (currentPlayer == RED) {
            currentPlayer = YELLOW;
            message.setText(" : Make your move.");
            message.setIcon(yellowIcon);
        } else {
            currentPlayer = RED;
            message.setText(" : Make your move.");
            message.setIcon(redIcon);
        }
    }

    void gameOver(String str) {
        message.setText(str);
        newGame.setEnabled(true);
        ng.setEnabled(true);
        resignGame.setEnabled(false);
        rg.setEnabled(false);
    }

    private int winner(int i, int j) {

        if (count(board[i][j], i, j, 1, 0) >= 5) {
            return 1;
        }
        if (count(board[i][j], i, j, 0, 1) >= 5) {
            return 2;
        }
        if (count(board[i][j], i, j, 1, -1) >= 5) {
            return 3;
        }
        if (count(board[i][j], i, j, 1, 1) >= 5) {
            return 4;
        }
        return 0;

    }

    private int count(int player, int row, int col, int dirX, int dirY) {
        int ct = 1;
        int r, c;

        r = row + dirX;
        c = col + dirY;
        while (r >= 0 && r < 15 && c >= 0 && c < 15 && board[r][c] == player) {
            ct++;
            r += dirX;
            c += dirY;
        }
        r = row - dirX;
        c = col - dirY;
        while (r >= 0 && r < 15 && c >= 0 && c < 15 && board[r][c] == player) {
            ct++;
            r -= dirX;
            c -= dirY;
        }
        return ct;
    }
    
    void fillWin(int player, int row, int col, int dirX, int dirY) {
        bt[row][col].setIcon(null);
        bt[row][col].setBackground(Color.WHITE);
        int r, c;
        r = row + dirX;
        c = col + dirY;
        while (r >= 0 && r< 15 && c >= 0 && c < 15 && board[r][c] == player) {
            bt[r][c].setIcon(null);
            bt[r][c].setBackground(Color.WHITE);
            r += dirX;
            c += dirY;
        }
        r = row - dirX;
        c = col - dirY;
        while (r >= 0 && r < 15 && c >= 0 && c < 15 && board[r][c] == player) {
            bt[r][c].setIcon(null);
            bt[r][c].setBackground(Color.WHITE);
            r -= dirX;
            c -= dirY;
        }
    }
    
    void updateDB(String winner, String loser) {
        try{
        String query = "UPDATE LastPlayer SET Winner = ? WHERE Num = '1'";
        String query1 = "UPDATE LastPlayer SET Loser = ? WHERE Num = '1'";
        PreparedStatement stmt = sqlConnect.prepareStatement(query);
        PreparedStatement stmt1 = sqlConnect.prepareStatement(query1);
        stmt.setString(1, winner);
        stmt1.setString(1, loser);
        int count  = stmt.executeUpdate();
        int count1  = stmt1.executeUpdate();
        //sqlConnect.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not connect to database !", "Query faild", JOptionPane.ERROR_MESSAGE);
        }
    }
   private String getWinner(){
       String kq = null;
       try{
       String st = "SELECT Winner FROM LastPlayer";
       Statement stmt = sqlConnect.createStatement();
       ResultSet rs = stmt.executeQuery(st);
       while(rs.next())
           kq = rs.getString("Winner");
       }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Can not connect to database !", "Query faild Winner", JOptionPane.ERROR_MESSAGE);
        }
       return kq;
    }
   private String getLoser(){
       String kq = null;
       try{
       String st = "SELECT Loser FROM LastPlayer";
       Statement stmt = sqlConnect.createStatement();
       ResultSet rs = stmt.executeQuery(st);
       while(rs.next())
           kq = rs.getString("Loser");
       }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Can not connect to database !", "Query faild Loser", JOptionPane.ERROR_MESSAGE);
        }
       return kq;
    }
    public static void main(String[] args) {
        Caro a = new Caro();
        a.display();
    }
}
