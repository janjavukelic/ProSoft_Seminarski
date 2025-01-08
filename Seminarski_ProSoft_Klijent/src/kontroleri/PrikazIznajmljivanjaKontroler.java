/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Iznajmljivanje;
import forme.PrikaziIznajmljivanjeForma;
import forme.tabele.ModelTabeleIznajmljivanje;
import java.util.List;
import komunikacija.Komunikacija;
/**
 *
 * @author janja
 */
public class PrikazIznajmljivanjaKontroler {
    private final PrikaziIznajmljivanjeForma forma;

    public PrikazIznajmljivanjaKontroler(PrikaziIznajmljivanjeForma forma) {
        this.forma = forma;
        //addActionListener();
    }
    
    public void otvoriFormu(){
        forma.setVisible(true);
        pripremiFormu();
    }

    private void addActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void pripremiFormu() {
        List<Iznajmljivanje> lista=Komunikacija.getInstance().vratiListuIznajmljivanje();
        ModelTabeleIznajmljivanje mti=new ModelTabeleIznajmljivanje(lista);
        forma.getTabela().setModel(mti);
    }
    
}
