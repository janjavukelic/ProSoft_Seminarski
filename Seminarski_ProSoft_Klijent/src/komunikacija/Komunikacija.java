/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author janja
 */
public class Komunikacija {
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    public Komunikacija() {
        
    }

    public static Komunikacija getInstance() {
        if(instance==null) instance=new Komunikacija();
        return instance;
    }
    
    public void konekcija(){
        try {
            socket=new Socket("localhost", 9000);
        } catch (IOException ex) {
            System.out.println("Greska kod konekcije sa serverom!");
        }
        posiljalac=new Posiljalac(socket);
        primalac=new Primalac(socket);
    }
    
    public boolean login(Zaposleni z) throws Exception{
        try {
            posiljalac.posalji(z);
            Odgovor o=(Odgovor) primalac.primi();
            if(o.getException()!=null)return false;
        } catch (Exception ex) {
            throw new Exception("Greska kod slanja i/ili primanja objekta.");
        }
        return true;
    }
    
    
    
}
