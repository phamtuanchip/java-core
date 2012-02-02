/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author dung dx, toan bui
 */
public class PrivateChat extends JFrame implements ActionListener {

    
    private JPanel p_pchat;
    private JPanel p31,p32;
    private JTextArea output3;
    private JTextField input3;
    private JButton send3,quit3;
    
    private Client client;
    private String nick,User;
    private DataInputStream in;
    private DataOutputStream out;
    
    public PrivateChat(Client client, final String nick){
        super(nick);
        this.nick=nick;
        this.client= client;
        setSize(550,290);
        addItem();
        setResizable(false);
        setVisible(true);       
    }
    
    public void addItem(){
        p_pchat= new JPanel();
        output3=new JTextArea(12,20);
        output3.setEditable(false);
        input3= new JTextField(35);
        input3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    send3();
                }
            }
        });
        send3= new JButton("Gửi");
        send3.addActionListener(this);
        quit3= new JButton("Thoát");
        quit3.addActionListener(this);
        
        p_pchat.setLayout(new BorderLayout());
        
        p31= new JPanel();
        p31.setLayout(new BorderLayout());
        p31.add(new JScrollPane(output3),BorderLayout.CENTER);
        p31.add(new JLabel("   "),BorderLayout.NORTH);
        p31.add(new JLabel("   "),BorderLayout.WEST);
        p31.add(new JLabel("   "),BorderLayout.EAST);
        p31.add(new JLabel("   "),BorderLayout.SOUTH);
        p31.setBackground(Color.CYAN);
        
        p32= new JPanel();
        p32.setLayout(new FlowLayout(FlowLayout.LEFT));
        p32.add(input3);
        p32.add(send3);
        p32.add(quit3);
        p32.setBackground(Color.MAGENTA);
        
        p_pchat.add(p31,BorderLayout.CENTER);
        p_pchat.add(p32,BorderLayout.SOUTH);
        
        add(p_pchat,BorderLayout.NORTH);
    }
    
    public void setUserID(String User){
        this.User= User;
    }
    
    public void setInputStream(DataInputStream in){
        this.in= in;
    }
    
    public void setOutputStream(DataOutputStream out){
        this.out= out;
    }
    
    public void setOutput(String msg){
        output3.append(msg);
    }
  
    private void sendMSG(String data) {
        try{
            out.writeUTF(data);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void checkSend(String msg) {
        if (msg.compareTo("\n")!=0){
            this.output3.append(User+" : "+msg);
            sendMSG("5");
            sendMSG(nick);
            sendMSG(User);
            sendMSG(msg);
        }      
    }
    
    public void send3(){
        checkSend(input3.getText()+"\n");
        input3.setText("");
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==send3){
            send3();
        }
        else if (e.getSource()== quit3){         
            setVisible(false);
        }
    } 
}
