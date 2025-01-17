/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.LoginFroma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class LoginKontroler {
    private final LoginFroma loginForma;

    public LoginKontroler(LoginFroma lf) {
        this.loginForma = lf;
        addActionListener();
    }
    
    

    private void addActionListener() {
        loginForma.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String korisnickoIme=loginForma.getTxtKorisnickoIme().getText().trim();
                String sifra=new String(loginForma.getTxtSifra().getPassword());
                Zaposleni z=new Zaposleni(korisnickoIme, sifra);
                
                try {
                    Zaposleni ulogovani=Komunikacija.getInstance().prijaviZaposleni(z);
                    if(ulogovani==null){
                        JOptionPane.showMessageDialog(loginForma, "Prijava na sistem neuspesna!", "Greska", JOptionPane.ERROR_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(loginForma, "Prijava na sistem uspesna!", "", JOptionPane.INFORMATION_MESSAGE);
                        Koordinator.getInstanca().setUlogovani(ulogovani);
                        Koordinator.getInstanca().otvoriGlavnuFormu();
                        loginForma.dispose();
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(loginForma, "Greska u komunikaciji sa serverom.");
                }
            }
        });
    }

    public void otvoriFormu() {
        loginForma.setVisible(true);
    }
    
    
    
}
