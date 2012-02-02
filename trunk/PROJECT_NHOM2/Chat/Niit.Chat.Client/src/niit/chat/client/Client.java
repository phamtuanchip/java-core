/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.client;

import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dung dx, toan bui
 */
public class Client  extends JFrame implements ActionListener{
    /**
     * @param args the command line arguments
     */
    private JButton login;
    private JTextField nick;
    private char[] txt2;
    private String txt1,txt3;
    private JPasswordField pass;
    JMenuBar mb;
    private JMenu m1,m2;
    private JMenuItem mi11,mi12,mi13,mi14,mi2;
    private JPanel p_login,p0,p01,p02,p03,p04;
    private String server,user,password;
    
    private JPanel p_gchat;
    private JTextArea output2;
    private List online;
    private JPanel p1,p11,p2;
    private JTextField input2;
    private JButton send2,quit2;
            
    private DataInputStream in;
    private DataOutputStream out;
    private Socket client;
    private DataStream dataStream;
    public Hashtable<String,PrivateChat> listUser;
    
    public Client(){
        super("ChatLink");        		
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }        
        });
              
        addItem();
        setSize(535,550);
        setJMenuBar(mb);
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);      
    }
    
    public void addItem(){
        
     /******************Giao diện đăng nhập***********************************/
        
        p_login= new JPanel();
        p_login.setLayout(new BorderLayout());
        
        p0= new JPanel();    
        nick= new JTextField(30);
        pass= new JPasswordField(30);
        
        nick.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    txt1= nick.getText();                    
                    txt2=pass.getPassword();
                    txt3= new String(txt2);
                    login(txt1,txt3);
                }
            }
        });
        
        pass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    txt1= nick.getText();                   
                    txt2=pass.getPassword();
                    txt3= new String(txt2);
                    login(txt1,txt3);
                }
            }
        });
        p0.setBackground(Color.GREEN);
        p0.setLayout(new GridLayout(4,1));
        p0.add(new JLabel("Tên truy cập: "));                
        p0.add(nick);
        p0.add(new JLabel("Mật khẩu: "));
        p0.add(pass);
        
        p01=new JPanel();
        p01.add(p0,BorderLayout.CENTER);      
        p01.add(new JLabel("   "),BorderLayout.NORTH);
        p01.add(new JLabel("   "),BorderLayout.WEST);
        p01.add(new JLabel("   "),BorderLayout.EAST);
        p01.add(new JLabel("   "),BorderLayout.SOUTH);
        p01.setBackground(Color.GREEN);
                    
        p02=new JPanel(){
            Toolkit currentTK= Toolkit.getDefaultToolkit();
            Image anh= currentTK.getImage("src\\Messenger.jpg");                           
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(anh,0,0,this);
            }
        };
        
        p03=new JPanel(); 
        login= new JButton("Đăng nhập");
        login.addActionListener(this);                       
        p03.add(login,BorderLayout.CENTER);      
        p03.add(new JLabel("   "),BorderLayout.NORTH);
        p03.add(new JLabel("   "),BorderLayout.WEST);
        p03.add(new JLabel("   "),BorderLayout.EAST);
        p03.add(new JLabel("   "),BorderLayout.SOUTH);
        p03.setBackground(Color.RED);
                                          
        p_login.add(p01,BorderLayout.NORTH);                      
        p_login.add(p02,BorderLayout.CENTER);
        p_login.add(p03,BorderLayout.SOUTH);
        
        mb= new JMenuBar();
        m1= new JMenu("Tài khoản");
        mi11= new JMenuItem("Đăng ký");
        mi11.addActionListener(this);
        mi12= new JMenuItem("Cập nhật");
        mi12.addActionListener(this);
        mi13= new JMenuItem("Xóa");
        mi13.addActionListener(this);        
        mi14= new JMenuItem("Thoát");
        mi14.addActionListener(this);
                                       
        m1.add(mi11);
        m1.add(mi12);
        m1.add(mi13);
        m1.addSeparator();
        m1.add(mi14);
        
        m2= new JMenu("Trợ giúp");
        mi2= new JMenuItem("Thông tin");
        mi2.addActionListener(this);
        m2.add(mi2);
        
        mb.add(m1);        
        mb.add(m2);
         
        add(p_login,BorderLayout.CENTER);
        
     /****************Giao diện chat chung***********************************/
        
        p_gchat= new JPanel();
        input2= new JTextField(30);
        input2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    send2();
                }
            }
        });
        output2= new JTextArea(10,20);
        output2.setEditable(false);
        online= new List();
        online.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onlineItemStateChanged(e);
            }
        });
        send2= new JButton("Gửi");
        send2.addActionListener(this);
        quit2= new JButton("Thoát");
        quit2.addActionListener(this);
        
        p_gchat.setLayout(new BorderLayout());
              
        p1= new JPanel();        
        p1.setLayout(new BorderLayout());
        p11= new JPanel();
        p11.setLayout(new FlowLayout(FlowLayout.CENTER));
        p11.setBackground(Color.YELLOW);
        p11.add(new JLabel("Danh sách online"));
        p1.add(p11,BorderLayout.NORTH);
              
        p1.add(new JScrollPane(online),BorderLayout.CENTER);
        p1.add(new JLabel("   "),BorderLayout.SOUTH);
        p1.add(new JLabel("   "),BorderLayout.WEST);
        p1.add(new JLabel("   "),BorderLayout.EAST);
        p1.setBackground(Color.YELLOW);
        
        p2= new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("Tin nhắn "));
        p2.add(input2);
        p2.add(send2);
        p2.add(quit2);
        p2.setBackground(Color.MAGENTA);
        
        p_gchat.add(new JScrollPane(output2),BorderLayout.CENTER);
        p_gchat.add(p1, BorderLayout.EAST);
        p_gchat.add(p2, BorderLayout.SOUTH);
        p_gchat.add(new JLabel("   "),BorderLayout.WEST);
        p_gchat.add(new JLabel("   "),BorderLayout.NORTH);

        p_gchat.setBackground(Color.CYAN);
        p_gchat.setVisible(false);
        add(p_gchat,BorderLayout.WEST);                                                      
    }
    
    public void launch(){
        try {
            client= new Socket("localhost",8000);
            in= new DataInputStream(client.getInputStream());
            out= new DataOutputStream(client.getOutputStream());          
            listUser= new Hashtable<String, PrivateChat>();
            
            setServer("ALPHA402");
            setUser("sa");
            setPassord("sa");
        } catch (IOException ex) {
            System.exit(0);
        }
    }
    
    public void setServer(String server){
        this.server= server;
    }
    
    public String getServer(){
        return server;
    }
    
    public void setUser(String user){
        this.user= user;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setPassord(String password){
        this.password= password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void sendMSG(String data){
        try{
            out.writeUTF(data);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private String getMSG(){
        String data= null;
        try {
            data= in.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    public void getMSG(String msg1,String msg2){
        int stt= Integer.parseInt(msg1);
        switch (stt){
            //tin nhan cua nhung nguoi khac
            case 3:
                this.output2.append(msg2);
                break;
            // update danh sach online
            case 4:
                this.online.removeAll();
                String[] User=msg2.split("\n");
                for (int i=0;i<User.length;i++)
                    this.online.add(User[i]);
                break;        
            
            default:
                     break;
                
        }     
    }

    public void getMSG(String msg1,String msg2,String msg3){
        Boolean test = false;    
        Enumeration e=listUser.keys();
        String name=null;
        while (e.hasMoreElements()){
            name=(String)e.nextElement();
            if (name.compareTo(msg2)==0){             
                listUser.get(name).setVisible(true);
                listUser.get(name).setOutput(msg3);
                test= true;
            }
        }      
        if (test ==false){
            PrivateChat p=new PrivateChat(this,msg2);
            p.setUserID(nick.getText());
            p.setInputStream(in);
            p.setOutputStream(out);
            p.setOutput(msg3);
            listUser.put(msg2,p);           
        }                               
    }
    
    public void checkSend(String msg){
        if (msg.compareTo("\n")!=0){
            this.output2.append(nick.getText()+" : "+msg);
            sendMSG("1");
            sendMSG(msg);
        }           
    }
    
    public void send2(){
        checkSend(input2.getText()+"\n");
        input2.setText("");
    }
     
    public void login(String nick,String pass){
        if (nick.length()==0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!","Thông báo", JOptionPane.WARNING_MESSAGE);
            this.nick.requestFocusInWindow();
        }                           
        else if (pass.length()==0){
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập mật khẩu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            this.pass.requestFocusInWindow();
        }  
        else{
            try {    
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String url= "jdbc:odbc:driver={SQL Server};server="+server+";user="+user+";password="+password+";database=Chatting";                        
                Connection con= DriverManager.getConnection(url);                
                java.sql.Statement stmt= con.createStatement();
                ResultSet rs= stmt.executeQuery(" SELECT * FROM Chat");
                boolean test= false;
                
                while (rs.next()){
                    if (rs.getString(1).equals(nick)&& rs.getString(2).equals(pass))
                        test= true;
                }
                if (test== false){
                    JOptionPane.showMessageDialog(this,"Tên đăng nhập hoặc mật khẩu không chính xác!");
                    this.nick.requestFocusInWindow();
                }
                else{
                    sendMSG(nick);
                    int sst= Integer.parseInt(getMSG());
                    if (sst== 0){                               
                        JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại, bạn hãy nhập tên khác!","Thông báo", JOptionPane.WARNING_MESSAGE);
                        this.nick.requestFocusInWindow();
                    }                
                    else{
                        p_login.setVisible(false);                
                        p_gchat.setVisible(true);
                        this.setTitle(nick);
                        output2.append("Đã đăng nhập thành công \n");
                        
                        dataStream= new DataStream(this,this.in);                                               
                    }                    
                }
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Không kết nối được với cơ sở dữ liệu! ","Thông báo", JOptionPane.WARNING_MESSAGE);
            }catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Không nạp được driver!","Thông báo", JOptionPane.WARNING_MESSAGE);
            }       
        }
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()==login)){                                                    
            txt1= nick.getText();            
            txt2=pass.getPassword();
            txt3= new String(txt2);
            login(txt1,txt3);                             
        }
        else if(e.getSource()==mi11){
            new Registry(this).setLocationRelativeTo(this);
        }
        else if (e.getSource()==mi12){          
            new Update(this).setLocationRelativeTo(this);
        }
        else if (e.getSource()==mi13){
            new Delete(this).setLocationRelativeTo(this);
        }
        else if (e.getSource()==mi14)
            exit();
        else if(e.getSource()==mi2){
           new Help().setLocationRelativeTo(this);
        }
        else if (e.getSource()== send2){
            send2();
        }
        else if(e.getSource()==quit2){
            dataStream.stopThread();
            exit();
        }    
    }

    private void exit() {
        try {
            sendMSG("0");
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
    
    private void onlineItemStateChanged(ItemEvent e){
        if (online.getSelectedItem().compareTo(nick.getText())!=0){           
            PrivateChat p=new PrivateChat(this,online.getSelectedItem());           
            p.setUserID(nick.getText());
            p.setInputStream(in);
            p.setOutputStream(out);
            listUser.put(online.getSelectedItem(),p);
        }
    }
    
    public static void main(String[] args) {
        new Client().launch();
    }    
}
