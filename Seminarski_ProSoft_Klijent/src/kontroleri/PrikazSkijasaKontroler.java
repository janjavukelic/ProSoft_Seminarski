/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.NivoSkijanja;
import domen.Skijas;
import forme.PrikaziSkijasaForma;
import forme.tabele.ModelTabeleSkijasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class PrikazSkijasaKontroler {

    private final PrikaziSkijasaForma forma;

    public PrikazSkijasaKontroler(PrikaziSkijasaForma prikazSkijasaForma) {
        this.forma = prikazSkijasaForma;
        //addActionListener();
    }

    public void otvoriPrikazSkijasaFormu() {
        forma.setVisible(true);
        pripremiFormu();
        addActionListener();
    }

    private void addActionListener() {
        forma.btnObrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiSkijasa();
            }
        });

        forma.btnPromeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniSkijasa();
            }

        });
        forma.txtBrTelAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziSkijasa();
            }
        });
        forma.txtImeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziSkijasa();
            }
        });
        forma.txtPrezimeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziSkijasa();
            }
        });
        forma.comboNivoAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziSkijasa();
            }
        });
    }

    private void pripremiFormu() {
        //ucitati listu skijasa
        osveziTabelu(null);
        popuniComboBox();
    }

    private void obrisiSkijasa() {
        int red = forma.getTblSkijasi().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise skijasa", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Skijas s = ((ModelTabeleSkijasi) forma.getTblSkijasi().getModel()).getSkijasi().get(red);
        Komunikacija.getInstance().obrisiSkijas(s);
        osveziTabelu(null);
    }

    private void osveziTabelu(List<Skijas> lista) {
        if(lista==null)lista = Komunikacija.getInstance().pretraziSkijas(null);
        ModelTabeleSkijasi mts = new ModelTabeleSkijasi(lista);
        forma.getTblSkijasi().setModel(mts);
    }

    private void promeniSkijasa() {
        int red=forma.getTblSkijasi().getSelectedRow();
        if(red==-1){
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da promeni skijasa", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Skijas s = ((ModelTabeleSkijasi) forma.getTblSkijasi().getModel()).getSkijasi().get(red);
        Koordinator.getInstanca().otvoriIzmeniSkijasaFormu(s);
        osveziTabelu(null);
    }
    
    private void pretraziSkijasa(){
        String ime=forma.getTxtIme().getText().trim();
        String prezime=forma.getTxtPrezime().getText().trim();
        String brTel=forma.getTxtBrTel().getText().trim();
        NivoSkijanja nivo=(NivoSkijanja) forma.getComboNivo().getSelectedItem();
        
        Skijas skijas=new Skijas(0, ime, prezime, brTel, nivo);
        List<Skijas>lista=Komunikacija.getInstance().pretraziSkijas(skijas);
        osveziTabelu(lista);
        
    }

    private void popuniComboBox() {
        List<NivoSkijanja> lista=Komunikacija.getInstance().ubaciNivoSkijanja();
        forma.getComboNivo().addItem(null);
        for (NivoSkijanja nivoSkijanja : lista) {
            forma.getComboNivo().addItem(nivoSkijanja);
        }
        
    }
}
