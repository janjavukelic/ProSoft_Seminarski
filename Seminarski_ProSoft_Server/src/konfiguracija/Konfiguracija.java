package konfiguracija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author janja
 */
public class Konfiguracija {

    private static Konfiguracija instanca;
    private Properties konfiguracija;

    private Konfiguracija() {
        konfiguracija = new Properties();
        try {
            konfiguracija.load(new FileInputStream("C:\\Users\\janja\\OneDrive\\Dokumenti\\NetBeansProjects\\Seminarski_ProSoft_Server\\config\\config.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konfiguracija getInstanca() {
        if (instanca == null) {
            instanca = new Konfiguracija();
        }
        return instanca;
    }

    public String getProperty(String kljuc) {
        return konfiguracija.getProperty(kljuc, "n/a");
    }

    public void setProperty(String kljuc, String vrednost) {
        konfiguracija.setProperty(kljuc, vrednost);
    }

    public void sacuvajIzmene() throws FileNotFoundException, IOException {
        konfiguracija.store(new FileOutputStream("C:\\Users\\janja\\OneDrive\\Dokumenti\\NetBeansProjects\\Seminarski_ProSoft_Server\\config\\config.properties"), null);
        
    }
    
    public void postaviIzmeneZaBazu(String URL,String username,String password) throws IOException{
        setProperty("url", URL);
        setProperty("username", username);
        setProperty("password", password);
        sacuvajIzmene();
    }
    
    public void postaviIzmeneZaPort(String port) throws IOException{
        setProperty("port", port);
        sacuvajIzmene();
    }
}
