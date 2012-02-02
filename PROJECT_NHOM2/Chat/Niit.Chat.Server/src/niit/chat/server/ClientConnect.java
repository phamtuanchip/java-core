/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author dung dx, toan bui
 */
public class ClientConnect extends Thread{
    private Socket client;
    public Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private Boolean run;
    private String nick;
    private String nick1,nick2;
    
    public ClientConnect(Server server, Socket client) {
        try { 
            this.server= server;
            this.client=client;
            in= new DataInputStream(client.getInputStream());
            out= new DataOutputStream(client.getOutputStream());
            run= true;
            this.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }           
    }
   
    public void run(){
        // xử lý đăng nhập
        String msg=null;             
        nick= getMSG();
        if (nick.compareTo("0")==0)
            logout();
        else if (checkNick(nick))
            sendMSG("0");
        else{
            server.sendAll(nick,nick+" đã tham gia phòng chat.......................................\n");
            server.listUser.put(nick, this);
            server.sendAllUpdate(nick);
            sendMSG("1");
            DiplayAllUser();
            while (run){
                int stt= Integer.parseInt(getMSG());
                switch (stt){
                    case 0:
                        run=false;
                        server.listUser.remove(this.nick);
                        exit();
                        break;
                    case 1:
                        msg= getMSG();
                        server.sendAll(nick,nick+" : "+msg);
                        break;                       
                    
                    case 5:
                        nick1= getMSG();
                        nick2= getMSG();
                        msg= getMSG();
                        
                        server.sendAll2(nick1,nick2,nick2+" : "+msg);
                }
            }
        }                                  
    }   
    
    public boolean checkNick(String nick){
        return server.listUser.containsKey(nick);
    }
    
    public String getMSG(){
        String data= null;
        try{
            data=in.readUTF();
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }
    
    public void sendMSG(String data){
        try{
            out.writeUTF(data);
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void logout() {
        try {
            out.close();
            in.close();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void DiplayAllUser() {
        String name= server.getAllName();
        sendMSG("4");
        sendMSG(name);
    }

    void sendMSG(String msg1, String msg2) {
        sendMSG(msg1);
        sendMSG(msg2);        
    }
    
    void sendMSG(String msg1, String msg2, String msg3) {
        sendMSG(msg1);
        sendMSG(msg2);        
        sendMSG(msg3);
    }
   
    private void exit() {
        try {
            server.sendAllUpdate(nick);
            out.close();
            in.close();
            client.close();
            server.sendAll(nick,nick+" đã thoát.................................................\n");            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   
}