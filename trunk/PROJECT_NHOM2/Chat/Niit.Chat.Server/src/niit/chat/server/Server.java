/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.server;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author dung dx, toan bui
 */
public class Server extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private JPanel p1,p2;
    private JButton quit;
    private JTextArea output;
    private ServerSocket server;
    public Hashtable<String,ClientConnect> listUser;

    public Server(){
        super("Server");		
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                      
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    server.close();                   
                    System.exit(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
                 
        addItem();
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    
    public void addItem(){
        
        p1= new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        output=new JTextArea(10,10);
        output.setEditable(false);
        output.setBackground(Color.GREEN);
        p1.add(output);
        p1.setBackground(Color.CYAN);
        
        p2= new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        quit= new JButton("Close Server");
        quit.addActionListener(this);
        p2.add(quit);
        p2.setBackground(Color.CYAN);
       
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);        
    }
    
    public void launch(){
        try {
            server = new ServerSocket(8000);
            listUser= new Hashtable<String, ClientConnect>(); 
            output.append("Máy chủ bắt đầu hoạt động \n");            
            while (true){
                Socket client= server.accept();
                new ClientConnect(this,client);
            } 
        }catch (IOException ex) {
                output.append("Không thể khởi động máy chủ \n");
        }                      
    }    

    @Override
    public void actionPerformed(ActionEvent e) {                        
        try{
            server.close();        
        } catch (IOException ex) {
            output.append("Không đóng được server \n");
        }         
        System.exit(0);
     }

    public void sendAll(String from, String msg) {
        Enumeration e=listUser.keys();
        String name=null;
        while (e.hasMoreElements()){
            name=(String)e.nextElement();
            if (name.compareTo(from)!=0) 
                listUser.get(name).sendMSG("3",msg);                    
        }       
    }

    public void sendAllUpdate(String from) {
        Enumeration e=listUser.keys();
        String name=null;
        while (e.hasMoreElements()){
            name=(String)e.nextElement();
            if (name.compareTo(from)!=0) 
                listUser.get(name).sendMSG("4",getAllName());                    
        }
    }
    
    public String getAllName(){
        Enumeration e=listUser.keys();
        String name="";
        while (e.hasMoreElements())
            name+=(String)e.nextElement()+"\n";
        return name;
    }  
    
    public void sendAll2(String from, String nick,String msg) {
        Enumeration e=listUser.keys();
        String name=null;
        while (e.hasMoreElements()){
            name=(String)e.nextElement();
            if (name.compareTo(from)==0) 
                listUser.get(name).sendMSG("6",nick,msg);                    
        }
    }
        
    public static void main(String[] args)  {
        // TODO code application logic here
        new Server().launch();       
    }   
}