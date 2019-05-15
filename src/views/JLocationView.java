/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.LocationController;
import entities.Location;
import icontrollers.ILocationController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author RR17
 */
public class JLocationView extends javax.swing.JInternalFrame {
    private SessionFactory sessionFactory = null; //masuk koneksi pintu utama (masuk ke table HR)
    private Session session = null; //masuk ke koneksi dalam yg sudah ada tujuan(hanya beberapa sesi2)
    ILocationController ilc = new LocationController(sessionFactory);
    
    /**
     * Creates new form JLocationView
     */
    public JLocationView() {
        initComponents();
        showTableLocation("");
        getDataComboCountryID();
    }
    
    public void resetTextLocation(){
        txtLocationId.setText("");
        txtStreetAddress.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
        txtStateProvince.setText("");
//        cmbCountryID.setText("");
        txtLocationId.setEditable(true);
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(true);
        getDataComboCountryID();
        cmbCountryID.setSelectedIndex(0);
    }
    
    public void showTableLocation(String key){
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        Object[] row = new Object[7];
        List<Location> location = ilc.search(key);
        if (key.isEmpty()) {
            location = ilc.getAll();
        }
        for (int i = 0; i < location.size(); i++) {
            row[0]=i+1;
            row[1]=location.get(i).getCountryId();
            row[2]=location.get(i).getStreetAddress();
            row[3]=location.get(i).getPostalCode();
            row[4]=location.get(i).getCity();
            row[5]=location.get(i).getStateProvince();
            row[6]=location.get(i).getCountryId();
            model.addRow(row);
        }
    }
    
    public void updateTableLocation(String s){
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        model.setRowCount(0);
        showTableLocation(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLocationId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStreetAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStateProvince = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCountryID = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLocation = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LOCATION INFO");

        jLabel2.setText("Location ID");

        txtLocationId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Street Address");

        jLabel4.setText("Postal Code");

        jLabel5.setText("City");

        jLabel6.setText("State Province");

        jLabel7.setText("Country ID");

        cmbCountryID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CountryID" }));
        cmbCountryID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Search");

        btnUpdate.setText("Update");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tableLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "LocationID", "StreetAddress", "PostalCode", "City", "StateProvince", "CountryID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLocationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableLocation);

        btnReset.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)
                        .addGap(0, 182, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStateProvince)
                            .addComponent(txtCity)
                            .addComponent(txtPostalCode)
                            .addComponent(txtStreetAddress)
                            .addComponent(cmbCountryID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLocationId)
                            .addComponent(txtSearch))))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCountryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocationIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationIdActionPerformed

    private void cmbCountryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryIDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocationMouseClicked
        DefaultTableModel model = (DefaultTableModel)tableLocation.getModel();
        int SelectedRowIndex = tableLocation.getSelectedRow();

        txtLocationId.setEditable(false);

        txtLocationId.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        txtStreetAddress.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        txtPostalCode.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        txtCity.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        txtStateProvince.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        cmbCountryID.setSelectedItem(model.getValueAt(SelectedRowIndex, 6).toString());
    }//GEN-LAST:event_tableLocationMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String countryID = cmbCountryID.getSelectedItem().toString();
        String ctr = countryID.substring(0, countryID.indexOf("-")-1);
                
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan insert?", "Confirm Insert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, ilc.(txtLocationID.getText(), txtStreetAddress.getText(), txtPostalCode.getText(), txtCity.getText(), txtStateProvince.getText(), ctr));
            updateTableLocation("");
            resetTextLocation();
        }
    }//GEN-LAST:event_btnInsertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCountryID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableLocation;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtLocationId;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStateProvince;
    private javax.swing.JTextField txtStreetAddress;
    // End of variables declaration//GEN-END:variables
}