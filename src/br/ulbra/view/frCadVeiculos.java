package br.ulbra.view;

import br.ulbra.model.Veiculo;
import br.ulbra.model.VeiculoDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João
 */
public class frCadVeiculos extends javax.swing.JFrame {

    /**
     * Creates new form FrCadUsuario
     * @throws java.sql.SQLException
     */
    public frCadVeiculos() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        showTable();
    }

    public void showTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tbVeiculos.getModel();
        modelo.setNumRows(0);
        VeiculoDao vdao = new VeiculoDao();
        for (Veiculo c : vdao.read()) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getMarca(),
                c.getModelo(),
                c.getAno(),
                c.getCor(),
                c.getPlaca(),
                c.getMotor(),
                c.getKm(),
                c.getValor()
            });
        }
    }

    public void showTableForName(String nome) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tbVeiculos.getModel();
        modelo.setNumRows(0);
        VeiculoDao vdao = new VeiculoDao();
        for (Veiculo c : vdao.readPesq(nome)) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getMarca(),
                c.getModelo(),
                c.getAno(),
                c.getCor(),
                c.getPlaca(),
                c.getMotor(),
                c.getKm(),
                c.getValor()
            });
        }
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
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtNome4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

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

        jLabel11.setText("Modelo");

        txtNome4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Controle de veiculos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jLabel2.setText("CÓDIGO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 68, 34));

        jLabel3.setText("Marca");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        txtMarca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 140, 34));

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "marca", "modelo", "ano", "cor", "placa", "motor", "km", "valor"
            }
        ));
        tbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbVeiculos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 580, 80));

        jLabel6.setText("Marca");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 280, 34));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/search.png"))); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 44, 34));

        btSalvar.setBackground(new java.awt.Color(51, 255, 51));
        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setText("SALVAR");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 90, 34));

        btAlterar.setBackground(new java.awt.Color(255, 102, 0));
        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btAlterar.setText("ALTERAR");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 90, 34));

        btExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir.setText("EXCLUIR");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 90, 34));

        btNovo.setBackground(new java.awt.Color(0, 153, 255));
        btNovo.setForeground(new java.awt.Color(255, 255, 255));
        btNovo.setText("NOVO");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 70, 34));

        jLabel8.setText("Modelo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        txtModelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 140, 34));

        jLabel9.setText("Ano");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        txtAno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 70, 34));

        jLabel10.setText("Cor");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        txtCor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 140, 34));

        txtPlaca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 140, 34));

        jLabel12.setText("Placa");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txtMotor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 150, 34));

        jLabel13.setText("Motor");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        txtKm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 140, 34));

        jLabel14.setText("Km");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        txtValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 140, 34));

        jLabel15.setText("Valor");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Veiculo c = new Veiculo();
        c.setMarca(txtMarca.getText());
        c.setModelo(txtModelo.getText());
        c.setAno(Integer.parseInt(txtAno.getText()));
        c.setCor(txtCor.getText());
        c.setPlaca(txtPlaca.getText());
        c.setMotor(txtMotor.getText());
        c.setKm(txtKm.getText());
        c.setValor(Double.parseDouble(txtValor.getText()));
        try {
            VeiculoDao vdao = new VeiculoDao();
            vdao.create(c);
            showTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed

        try {
            showTableForName(txtPesquisa.getText());
        } catch (SQLException ex) {
            Logger.getLogger(frCadVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculosMouseClicked
        if (tbVeiculos.getSelectedRow() != -1) {
            txtid.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 0).toString());
            txtMarca.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 1).toString());
            txtModelo.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 2).toString());
            txtAno.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 3).toString());
            txtCor.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 4).toString());
            txtPlaca.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 5).toString());
            txtMotor.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 6).toString());
            txtKm.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 7).toString());
            txtValor.setText(tbVeiculos.getValueAt(tbVeiculos.getSelectedRow(), 8).toString());
            btSalvar.setEnabled(false);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);

        }
    }//GEN-LAST:event_tbVeiculosMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Veiculo c = new Veiculo();
        c.setMarca(txtMarca.getText());
        c.setModelo(txtModelo.getText());
        c.setAno(Integer.parseInt(txtAno.getText()));
        c.setCor(txtCor.getText());
        c.setPlaca(txtPlaca.getText());
        c.setMotor(txtMotor.getText());
        c.setKm(txtKm.getText());
        c.setValor(Double.parseDouble(txtValor.getText()));

        VeiculoDao udao;
        try {
            udao = new VeiculoDao();
            udao.update(c);
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(frCadVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Veiculo u = new Veiculo();
        u.setId(Integer.parseInt(txtid.getText()));
        VeiculoDao udao;
        try {
            udao = new VeiculoDao();
            udao.delete(u);
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(frCadVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frCadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frCadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frCadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frCadVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frCadVeiculos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frCadVeiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtNome4;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
