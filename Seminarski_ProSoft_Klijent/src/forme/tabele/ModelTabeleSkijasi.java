/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tabele;

import domen.Skijas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author janja
 */
public class ModelTabeleSkijasi extends AbstractTableModel{

    private List<Skijas> skijasi;
    private String[] kolone={"Ime","Prezime","Broj telefona","Nivo skijanja"};

    public ModelTabeleSkijasi(List<Skijas> skijasi) {
        this.skijasi = skijasi;
    }

    public List<Skijas> getSkijasi() {
        return skijasi;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return skijasi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Skijas skijas=skijasi.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return skijas.getIme();
            case 1: 
                return skijas.getPrezime();
            case 2:
                return skijas.getBrTelefona();
            case 3:
                return skijas.getNivoSkijanja().getOpis();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
