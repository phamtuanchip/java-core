/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niit.chat.client;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author dung dx, toan bui
 */
class DataStream extends Thread{
    private boolean run;
    private DataInputStream in;
    private Client client;

    DataStream(Client client, DataInputStream in) {
        run=true;
        this.client= client;
        this.in= in;
        this.start();
    }

    public void run(){
        String msg1,msg2,msg3;
        while (run){
            try {
                msg1= in.readUTF();
                int stt= Integer.parseInt(msg1);
                if (stt== 6){
                    msg2= in.readUTF();
                    msg3= in.readUTF();
                    client.getMSG(msg1,msg2,msg3);
                }
                else{
                    msg2= in.readUTF();
                    client.getMSG(msg1,msg2);              
                }
            }catch (IOException ex) {

            }
        }
        try {
            in.close();
        } catch (IOException ex) {

        }
    }
    
    void stopThread() {
        this.run= false;
    }    
}
