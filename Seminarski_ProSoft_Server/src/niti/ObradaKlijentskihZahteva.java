/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.*;

/**
 *
 * @author janja
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        primalac = new Primalac(socket);
        posiljalac = new Posiljalac(socket);
    }

    @Override
    public void run() {
        while (true) {
            Odgovor odgovor=new Odgovor();
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                switch (zahtev.getOperacija()) {
                    
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                odgovor.setException(ex);
            }
            
        }
    }

}
