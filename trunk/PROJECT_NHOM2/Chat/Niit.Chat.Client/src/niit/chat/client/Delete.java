/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dungdx,toan bui
 */
public class Delete extends JFrame implements ActionListener {
    private JButton delete;    
    private JTextField nick;
    private JPasswordField pass1,pass2;
    private JPanel p,p1,p2,p3;
    private char[] txt2,txt4;
    private String txt1,txt3,txt5;
    private String server,user, password;
    
    public Delete(Client client){
        super("Xóa");
        addItem();
        setSize(500,200);
        setResizable(false);
        setVisible(true);
        
        this.server= client.getServer();
        this.user= client.getUser();
        this.password= client.getPassword();
    }
    
    public void addItem(){
        p1= new JPanel();
        p1.setLayout(new GridLayout(3,3));        
        nick= new JTextField(30);
        nick.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    txt1= nick.getText();                                   
                    
                    txt2=pass1.getPassword();
                    txt3= new String(txt2);
            
                    txt4=pass2.getPassword();
                    txt5= new String(txt4);
            
                    delete(txt1,txt3,txt5);
                }
            }
        });
        
        pass1= new JPasswordField(30);
        pass1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    txt1= nick.getText();                                   
                    
                    txt2=pass1.getPassword();
                    txt3= new String(txt2);
            
                    txt4=pass2.getPassword();
                    txt5= new String(txt4);
            
                    delete(txt1,txt3,txt5);
                }
            }
        });
        
        pass2= new JPasswordField(30); 
        pass2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    txt1= nick.getText();                                   
                    
                    txt2=pass1.getPassword();
                    txt3= new String(txt2);
            
                    txt4=pass2.getPassword();
                    txt5= new String(txt4);
            
                    delete(txt1,txt3,txt5);
                }
            }
        });
        
        p1.add(new JLabel("Nick"));
        p1.add(nick);
        p1.add(new JLabel("Mật khẩu"));
        p1.add(pass1);       
        p1.add(new JLabel("Xác nhận mật khẩu"));
        p1.add(pass2);
        p1.setBackground(Color.CYAN);
        
        p2=new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(p1,BorderLayout.CENTER);      
        p2.add(new JLabel("   "),BorderLayout.NORTH);
        p2.add(new JLabel("   "),BorderLayout.WEST);
        p2.add(new JLabel("   "),BorderLayout.EAST);
        p2.add(new JLabel("   "),BorderLayout.SOUTH);
        p2.setBackground(Color.CYAN);
        
        p3=new JPanel(); 
        delete= new JButton("Xóa");
        delete.addActionListener(this);                       
        p3.add(delete,BorderLayout.CENTER);      
        p3.add(new JLabel("   "),BorderLayout.NORTH);
        p3.add(new JLabel("   "),BorderLayout.WEST);
        p3.add(new JLabel("   "),BorderLayout.EAST);
        p3.add(new JLabel("   "),BorderLayout.SOUTH);
        p3.setBackground(Color.RED);
        
        p= new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p2,BorderLayout.CENTER);
        p.add(p3,BorderLayout.SOUTH);
        
        add(p);
    }
    
    public void delete(String nick, String pass1, String pass2){
        if (nick.length()==0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên!","Thông báo", JOptionPane.WARNING_MESSAGE);
            this.nick.requestFocusInWindow();
        }
        else if (pass1.length()==0){
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập mật khẩu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            this.pass1.requestFocusInWindow();
        }
        else if (pass2.length()==0){ 
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập mật khẩu xác nhận!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            this.pass2.requestFocusInWindow();
      
        }  
        else if (pass2.compareTo(pass1)!=0){
            JOptionPane.showMessageDialog(this,"Xác nhận mật khẩu không đúng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            this.pass2.setText("");
            this.pass2.requestFocusInWindow();
        }
        else{
            String sql;
            try {    
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String url= "jdbc:odbc:driver={SQL Server};server="+server+";user="+user+";password="+password+";database=Chatting";                        
                Connection con= DriverManager.getConnection(url);                
                java.sql.Statement stmt= con.createStatement();               
                ResultSet rs= stmt.executeQuery("SELECT * FROM Chat");
                boolean test= false;
                while (rs.next()){
                    if (rs.getString(1).equals(nick)&& rs.getString(2).equals(pass1))
                        test=true;
                }
                if (test== true){
                    sql= "DELETE FROM Chat WHERE nick='"+nick+"'";
                    stmt.executeUpdate(sql);
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this,"Xóa tên đăng nhập thành công ");                   
                }
                else{
                    JOptionPane.showMessageDialog(this,"Tên đăng nhập hoặc mật khẩu không chính xác!");
                    this.nick.requestFocusInWindow();
                }
                
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Không kết nối được với cơ sở dữ liệu! ","Thông báo", JOptionPane.WARNING_MESSAGE);               
            }catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "Không nạp được driver!","Thông báo", JOptionPane.WARNING_MESSAGE);
            }   
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        txt1= nick.getText();            
        
        txt2=pass1.getPassword();
        txt3= new String(txt2);
        
        txt4=pass2.getPassword();
        txt5= new String(txt4);
        
        delete(txt1,txt3,txt5);
    }
}
