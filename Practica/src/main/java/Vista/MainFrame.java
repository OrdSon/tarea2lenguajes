/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Analizador.Analizador;

/**
 *
 * @author ordson
 */
public class MainFrame extends javax.swing.JFrame {
    
    Analizador analizador = new Analizador();
   
    public MainFrame() {
        initComponents();
        
    }
    
    public void compilar(){
        txtAreaAciertos.setText("");
        txtAreaErrores.setText("");
        panelAciertos.updateUI();
        analizador.Analizar(txtPanePrincipal);
        analizador.writeAciertos(txtAreaAciertos);
        analizador.writeErrores(txtAreaErrores);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelOutput = new javax.swing.JPanel();
        panelAciertos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaAciertos = new javax.swing.JTextPane();
        panelErrores = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaErrores = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanePrincipal = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuCompilar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setLayout(new java.awt.BorderLayout());

        panelOutput.setMaximumSize(new java.awt.Dimension(32767, 96));
        panelOutput.setLayout(new java.awt.GridLayout(1, 0));

        panelAciertos.setBackground(new java.awt.Color(204, 255, 204));
        panelAciertos.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Aciertos");
        panelAciertos.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        txtAreaAciertos.setMaximumSize(new java.awt.Dimension(800, 80));
        txtAreaAciertos.setMinimumSize(new java.awt.Dimension(6, 80));
        jScrollPane2.setViewportView(txtAreaAciertos);

        panelAciertos.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelOutput.add(panelAciertos);

        panelErrores.setBackground(new java.awt.Color(255, 204, 204));
        panelErrores.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Errores");
        panelErrores.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        txtAreaErrores.setMaximumSize(new java.awt.Dimension(800, 80));
        txtAreaErrores.setMinimumSize(new java.awt.Dimension(6, 80));
        txtAreaErrores.setPreferredSize(new java.awt.Dimension(6, 80));
        jScrollPane5.setViewportView(txtAreaErrores);

        panelErrores.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        panelOutput.add(panelErrores);

        panelBase.add(panelOutput, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 300));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(8, 300));
        jScrollPane1.setViewportView(txtPanePrincipal);

        panelBase.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu3.setText("Acciones");

        menuCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCompilar.setText("Compilar");
        menuCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarActionPerformed(evt);
            }
        });
        jMenu3.add(menuCompilar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarActionPerformed
        compilar();
    }//GEN-LAST:event_menuCompilarActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenuItem menuCompilar;
    private javax.swing.JPanel panelAciertos;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelErrores;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JTextPane txtAreaAciertos;
    private javax.swing.JTextPane txtAreaErrores;
    private javax.swing.JTextPane txtPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
