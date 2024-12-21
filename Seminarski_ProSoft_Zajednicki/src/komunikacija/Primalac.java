/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author janja
 */
public class Primalac {
    Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            throw new Exception("Greska u primanju objekta!");
        }
        
    }
    
}