/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.NivoSkijanja;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author janja
 */
public class PrikaziSkijasaForma extends javax.swing.JFrame {

    /**
     * Creates new form PrikazSkijasa
     */
    public PrikaziSkijasaForma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSkijasi = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboNivo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Skijasi");

        tblSkijasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblSkijasi);

        btnObrisi.setText("Obrisi");

        btnPromeni.setText("Promeni");

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Broj telefona:");

        jLabel4.setText("Nivo skijanja:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboNivo, 0, 139, Short.MAX_VALUE)
                            .addComponent(txtBrTel))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboNivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(btnPromeni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTblSkijasi() {
        return tblSkijasi;
    }

    public void setTblSkijasi(JTable tblSkijasi) {
        this.tblSkijasi = tblSkijasi;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<NivoSkijanja> comboNivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSkijasi;
    private javax.swing.JTextField txtBrTel;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    public void btnObrisiAddActionListener(ActionListener actionListener){
        btnObrisi.addActionListener(actionListener);
    }
    
    public void btnPromeniAddActionListener(ActionListener actionListener){
        btnPromeni.addActionListener(actionListener);
    }
    
    public void txtImeAddActionListener(ActionListener actionListener){
        txtIme.addActionListener(actionListener);
    }
    
    public void txtPrezimeAddActionListener(ActionListener actionListener){
        txtPrezime.addActionListener(actionListener);
    }
    public void txtBrTelAddActionListener(ActionListener actionListener){
        txtBrTel.addActionListener(actionListener);
    }
    
    public void comboNivoAddActionListener(ActionListener actionListener){
        comboNivo.addActionListener(actionListener);
    }

    public JComboBox<NivoSkijanja> getComboNivo() {
        return comboNivo;
    }

    public void setComboNivo(JComboBox<NivoSkijanja> comboNivo) {
        this.comboNivo = comboNivo;
    }

    public JTextField getTxtBrTel() {
        return txtBrTel;
    }

    public void setTxtBrTel(JTextField txtBrTel) {
        this.txtBrTel = txtBrTel;
    }

    public JTextField getTxtIme() {
        return txtIme;
    }

    public void setTxtIme(JTextField txtIme) {
        this.txtIme = txtIme;
    }

    public JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public void setTxtPrezime(JTextField txtPrezime) {
        this.txtPrezime = txtPrezime;
    }
    
    
}
