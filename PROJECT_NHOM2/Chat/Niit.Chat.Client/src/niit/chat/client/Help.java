/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.client;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dungdx, toan bui
 */
public class Help extends JFrame{
    private JPanel p1;
    public Help(){
        super("Thông tin ");
        addItem();
        setSize(300,150);
        setResizable(false);
        setVisible(true);
    }
    public void addItem(){
        p1= new JPanel();
        p1.setLayout(new GridLayout(2,2));
        p1.add(new JLabel("  Đoàn Xuân Dũng"));
        p1.add(new JLabel("            01656100951"));
        p1.add(new JLabel("  Bùi Văn Toàn"));
        p1.add(new JLabel("             0974423859"));
        
        p1.setBackground(Color.CYAN);        
        add(p1);
    }    
}
