/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import controllers.JobController;

import icontrollers.IJobController;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Job;

import tools.HibernateUtil;

/**
 *
 * @author Relion31
 */
public class JobView extends javax.swing.JInternalFrame {

    /**
     * Creates new form JobView
     */
    public JobView() {
        initComponents();
        showTableJob("");
    }

    IJobController ijc = new JobController(HibernateUtil.getSessionFactory());

    public void showTableJob(String s) {
        DefaultTableModel model = (DefaultTableModel)tableJob.getModel();
        List<Job> jobs = ijc.search(s);
        Object[] row = new Object[5];
        if(s.isEmpty()){
            jobs = ijc.getAll();
        }
        for (int i = 0; i < jobs.size(); i++) {
            row[0] = i + 1;
            row[1] = jobs.get(i).getJobId();
            row[2] = jobs.get(i).getJobTitle();
            row[3] = jobs.get(i).getMinSalary();
            row[4] = jobs.get(i).getMaxSalary();
            model.addRow(row);
        }
    }
    
    private void updateTable(String s) {
        DefaultTableModel model = (DefaultTableModel)tableJob.getModel();
        model.setRowCount(0);
        showTableJob(s);
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
        tableJob = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();

        setClosable(true);

        tableJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Job ID", "Job Title", "Min Salary", "Max Salary"
            }
        ));
        jScrollPane1.setViewportView(tableJob);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        updateTable(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJob;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}