package prueba;

public class frmModelamiento extends javax.swing.JFrame {
	
public frmModelamiento() {
	initComponents();
	this.setLocationRelativeTo(null);
}

@SuppressWarnings("unchecked")

 private void initComponents() {
 	jMenuBar1 = new javax.swing.JMenuBar();
 	jMenu1 = new javax.swing.JMenu();
 	itemVentana = new javax.swing.JMenuItem();
 	itemArboles = new javax.swing.JMenuItem();
 	itemObjetos = new javax.swing.JMenuItem();
 	jMenu2 = new javax.swing.JMenu();	
 	
 	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 	
 	jMenu1.setText("Menu");
 	
 	itemVentana.setText("Ventana");
 	itemVentana.addActionListener(new java.awt.event.ActionListener() {
 	public void actionPerformed(java.awt.event.ActionEvent evt) {
 	       itemVentanaActionPerformed(evt);
 	    }
 	 });
 	    jMenu1.add(itemVentana);
 	
 	    jMenuBar1.add(jMenu1);
 	itemArboles.setText("arboles");
 	itemArboles.addActionListener(new java.awt.event.ActionListener() {
 	public void actionPerformed(java.awt.event.ActionEvent evt) {
 	       itemArbolesActionPerformed(evt);
 	    }
 	 });
 	    jMenu1.add(itemArboles);
 	
 	    jMenuBar1.add(jMenu1);
 	itemObjetos.setText("objetos");
 	itemObjetos.addActionListener(new java.awt.event.ActionListener() {
 	public void actionPerformed(java.awt.event.ActionEvent evt) {
 	       itemObjetosActionPerformed(evt);
 	    }
 	 });
 	    jMenu1.add(itemObjetos);
 	
 	    jMenuBar1.add(jMenu1);
 	
 	jMenu2.setText("Edit");
 	jMenuBar1.add(jMenu2);
 	
 	setJMenuBar(jMenuBar1);
 	
 	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
 	 getContentPane().setLayout(layout);
 	 layout.setHorizontalGroup(
 	    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 	      .addGap(0, 400, Short.MAX_VALUE)
 	  );
        layout.setVerticalGroup(
 	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 	            .addGap(0, 277, Short.MAX_VALUE)
 	        );
 	
 	 pack();
 	
 
 }
 
 private void itemVentanaActionPerformed(java.awt.event.ActionEvent evt) {                                      
         frmVentana Ventana = new frmVentana();
         Ventana.setVisible(true);
 }
 private void itemArbolesActionPerformed(java.awt.event.ActionEvent evt) {                                      
         frmArboles arboles = new frmArboles();
         arboles.setVisible(true);
 }
 private void itemObjetosActionPerformed(java.awt.event.ActionEvent evt) {                                      
         frmObjetos objetos = new frmObjetos();
         objetos.setVisible(true);
 }
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
             java.util.logging.Logger.getLogger(frmModelamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(frmModelamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(frmModelamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(frmModelamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
 
         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new frmModelamiento().setVisible(true);
             }
         });
     }
     private javax.swing.JMenuItem itemVentana;
     private javax.swing.JMenuItem itemArboles;
     private javax.swing.JMenuItem itemObjetos;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenuBar jMenuBar1;
	
}

