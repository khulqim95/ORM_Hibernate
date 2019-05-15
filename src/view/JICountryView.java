/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CountryController;
import daos.CountryDAO;
import icontroller.ICountryController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Region;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
//import tools.DBConnection;

/**
 *
 * @author Ode
 */
public final class JICountryView extends javax.swing.JInternalFrame {

//    DBConnection connection = new DBConnection();
//    ICountryController icc = new CountryController(connection.getConnection());
      CountryDAO cdao = new CountryDAO();
      ICountryController icc = new CountryController(HibernateUtil.getSessionFactory());
    /**
     * Creates new form JICountryView
     */
    public JICountryView() {
        initComponents();
        showTableCountry();
    }

    public void resetTextCountry() {
        txtCountryId.setText("");
        txtCountryName.setText("");
        txtCountryRegion.setText("");
        txtCountryId.setEditable(true);
        btnInsertCountry.setEnabled(true);
    }

    public void showTableCountry() {
        DefaultTableModel model = (DefaultTableModel) tableCountry.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < icc.getAll().size(); i++) {
            row[0] = icc.getAll().get(i).getCountryId();
            row[1] = icc.getAll().get(i).getCountryName();
            row[2] = icc.getAll().get(i).getRegionId().getRegionName();
            model.addRow(row);
        }
    }

//    public void showTableCountry(String s) {
//        DefaultTableModel model = (DefaultTableModel) tableCountry.getModel();
//        Object[] row = new Object[3];
//        for (int i = 0; i < icc.search(s).size(); i++) {
//            row[0] = icc.search(s).get(i).getId();
//            row[1] = icc.search(s).get(i).getName();
//            row[2] = icc.search(s).get(i).getRegion();
//            model.addRow(row);
//        }
//    }

    public void updateTableCountry() {
        DefaultTableModel model = (DefaultTableModel) tableCountry.getModel();
        model.setRowCount(0);
        showTableCountry();
    }

//    public void updateTableCountry(String s) {
//        DefaultTableModel model = (DefaultTableModel) tableCountry.getModel();
//        model.setRowCount(0);
//        if (s == "") {
//            showTableCountry();
//        }
//        showTableCountry(s);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCountryId = new javax.swing.JTextField();
        txtCountryName = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnInsertCountry = new javax.swing.JButton();
        btnUpdateCountry = new javax.swing.JButton();
        btnDeleteCountry = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCountryRegion = new javax.swing.JTextField();
        cmbCountrySearch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCountry = new javax.swing.JTable();
        txtCountrySearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("COUNTRIES");

        jLabel1.setText("Country Info");

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnInsertCountry.setText("Insert");
        btnInsertCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCountryActionPerformed(evt);
            }
        });

        btnUpdateCountry.setText("Update");
        btnUpdateCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCountryActionPerformed(evt);
            }
        });

        btnDeleteCountry.setText("Delete");
        btnDeleteCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCountryActionPerformed(evt);
            }
        });

        jLabel4.setText("Region");

        cmbCountrySearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ID", "NAME", "REGION" }));
        cmbCountrySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountrySearchActionPerformed(evt);
            }
        });

        tableCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "REGION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCountry.getTableHeader().setReorderingAllowed(false);
        tableCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCountryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCountry);
        if (tableCountry.getColumnModel().getColumnCount() > 0) {
            tableCountry.getColumnModel().getColumn(0).setResizable(false);
            tableCountry.getColumnModel().getColumn(1).setResizable(false);
            tableCountry.getColumnModel().getColumn(2).setResizable(false);
        }

        txtCountrySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountrySearchActionPerformed(evt);
            }
        });
        txtCountrySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountrySearchKeyTyped(evt);
            }
        });

        jLabel5.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCountryRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCountryId)
                                                .addComponent(txtCountryName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCountrySearch)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnInsertCountry)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdateCountry)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeleteCountry)))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addGap(0, 50, Short.MAX_VALUE))
                            .addComponent(cmbCountrySearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnClear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCountrySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountrySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCountryRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteCountry)
                            .addComponent(btnInsertCountry)
                            .addComponent(btnUpdateCountry))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        resetTextCountry();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCountrySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountrySearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountrySearchActionPerformed

    private void cmbCountrySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountrySearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountrySearchActionPerformed

    private void btnInsertCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCountryActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan insert?", "Confirm Insert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, icc.insert(txtCountryId.getText(), txtCountryName.getText(), txtCountryRegion.getText()));
            updateTableCountry();
            resetTextCountry();
        }
    }//GEN-LAST:event_btnInsertCountryActionPerformed

    private void btnUpdateCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCountryActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan update?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, icc.update(txtCountryId.getText(), txtCountryName.getText(), txtCountryRegion.getText()));
            updateTableCountry();
            resetTextCountry();
        }
    }//GEN-LAST:event_btnUpdateCountryActionPerformed

    private void btnDeleteCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCountryActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan delete?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, icc.delete(txtCountryId.getText()));
            updateTableCountry();
            resetTextCountry();
        }
    }//GEN-LAST:event_btnDeleteCountryActionPerformed

    private void tableCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCountryMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableCountry.getModel();
        int SelectedRowIndex = tableCountry.getSelectedRow();

        txtCountryId.setEditable(false);
        btnInsertCountry.setEnabled(false);
        txtCountryId.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        txtCountryName.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        txtCountryRegion.setText(model.getValueAt(SelectedRowIndex, 2).toString());
    }//GEN-LAST:event_tableCountryMouseClicked

    private void txtCountrySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountrySearchKeyTyped
        // TODO add your handling code here:
        updateTableCountry(txtCountrySearch.getText());
    }//GEN-LAST:event_txtCountrySearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteCountry;
    private javax.swing.JButton btnInsertCountry;
    private javax.swing.JButton btnUpdateCountry;
    private javax.swing.JComboBox<String> cmbCountrySearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableCountry;
    private javax.swing.JTextField txtCountryId;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JTextField txtCountryRegion;
    private javax.swing.JTextField txtCountrySearch;
    // End of variables declaration//GEN-END:variables
}