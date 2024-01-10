
package prueba;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JOptionPane;
public class frmObjetos extends javax.swing.JFrame {
	
	private void initComponents(){
		jpFondo = new javax.swing.JPanel();
		btGuardar = new javax.swing.JButton();
		btImprimir = new javax.swing.JButton();
		lbTitulo = new javax.swing.JLabel();
		lbNombre= new javax.swing.JLabel();
		txtNombre = new javax.swing.JTextField();
		
  		CbLista = new javax.swing.JComboBox<>();
  		
  		


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jpFondo.setBackground(new java.awt.Color(255, 153, 0));
		jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


 		lbTitulo.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
         		lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
         		lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         		lbTitulo.setText("OBJETOS");
	         
         		getContentPane().add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 16, 384, 32));
         
		lbNombre.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        		lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        		lbNombre.setText("Nombre");
        		jpFondo.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 51, 176, 32)); 
        
         		//97

		txtNombre.setBackground(new java.awt.Color(255, 255, 255));
		txtNombre.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
		txtNombre.setForeground(new java.awt.Color(0, 0, 0));
		txtNombre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
               				 txtNombreActionPerformed(evt);
            			}
        		});
        		jpFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 51, 160, 32));
        		//97

btGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btGuardar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        jpFondo.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 97, 160, 48));
       // -------------------------------------------------------------------------------------
 btImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btImprimir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btImprimir.setForeground(new java.awt.Color(0, 0, 0));
        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }

        });
        jpFondo.add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 102, 160, 48));
        
      
        CbLista.setBackground(new java.awt.Color(255, 255, 255));
                CbLista.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
               CbLista.setForeground(new java.awt.Color(0, 0, 0));
                CbLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dado","marcador",""}));
                CbLista.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CbListaActionPerformed(evt);
                            }
                });
                jpFondo.add(CbLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 51, 160, 48));
                

		getContentPane().add(jpFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 558,202));

		pack();
	}
 	
	private void txtNombreActionPerformed(ActionEvent evt) {
	
	}			  
private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                          
			        frmMenu frm = new frmMenu();
			        frm.setVisible(true);
			        this.dispose();
        }
        private void btImprimirActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, this.CbLista.getSelectedItem().toString());
       }
        private void CbListaActionPerformed(ActionEvent evt) {
        }
			    
			    
	public frmObjetos(){
	initComponents();
	this.dispose();
	this.setLocationRelativeTo(null);
	this.setSize(558,202 ); //456x, 558y Establece el tamaño
	this.setResizable(false);
	this.jpFondo.setPreferredSize(new Dimension(558,202));
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
            java.util.logging.Logger.getLogger(frmObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmObjetos().setVisible(true);
            }
        });
	    	}	
    private javax.swing.JPanel jpFondo;
	        private javax.swing.JButton btGuardar;
          private javax.swing.JButton btImprimir;
	        private javax.swing.JLabel lbTitulo;
	private javax.swing.JLabel lbNombre;
	private javax.swing.JTextField txtNombre;
	private javax.swing.JComboBox<String> CbLista;
}
	
