/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author janja
 */
public class Server extends Thread{
    private boolean kraj=false;
    private ServerSocket serverSocket;
    private IOException greska;
   
    public Server() {
        start();
    }

    @Override
    public void run(){
        try {
            pokreniServer();
            
        }catch (IOException ex) {
            greska=ex;
        } catch (InterruptedException ex) {
        }
        
    }
    
    private void pokreniServer() throws IOException, InterruptedException{
        serverSocket=new ServerSocket(getPort());
        while(!kraj && !isInterrupted()){
            System.out.println("Cekam klijenta...");
            Socket s=serverSocket.accept();
            System.out.println("Klijent se povezao...");
            ObradaKlijentskihZahteva klijent=new ObradaKlijentskihZahteva(s);
            klijent.start();
        }
    }
    
    public void zaustaviServer() throws IOException{
        kraj=true;
        interrupt();
        if(serverSocket!=null)serverSocket.close();
    }

    public IOException getGreska() {
        return greska;
    }

    public int getPort() {
        return Integer.parseInt(konfiguracija.Konfiguracija.getInstanca().getProperty("port"));
    }
    
    
}
