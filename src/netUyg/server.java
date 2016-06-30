package netUyg;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class server extends javax.swing.JFrame {

    String clientGelen = "";
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    String deger;
    BufferedReader data;
    BufferedReader in;
    PrintWriter out;
    StringBuilder sb = new StringBuilder();
    String mesaj=" ";


    public server() throws IOException {
        initComponents();
        jEditorPane1.setContentType("text/html");
        baglan();
    }

    public void baglan() {
        Runnable conn = () -> {
            while (true) {
                try {
                    //*Server 7755 portundan Client'ı dinliyor *//
                    serverSocket = new ServerSocket(7755);
                    System.out.println("SERVER BAGLANTI İÇİN HAZIR...");
                    clientSocket = serverSocket.accept();
                    System.out.println("Baglantı yapıldı.");
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    data = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Giriş çıkış birimleri aktif. Mesajlaşma başlayabilir.");
                    dinle();
                    break;
                } catch (Exception e) {
                    System.out.println("Server port hatası: " + e);
                }
            }
        };
        new Thread(conn).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMesaj = new javax.swing.JTextField();
        btnGonder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGonder.setText("Gönder");
        btnGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGonderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("SERVER");

        jScrollPane2.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGonder, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGonder)
                    .addComponent(txtMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void dinle() throws IOException {
        Runnable dinle = () -> {
            try {
                while ((clientGelen = in.readLine()) != null) {
                    mesaj += "<div style='background:#FF4000;border:1px solid #09131E;margin:5px;padding:3px'>" + clientGelen + "</div>" + "\n";
                    sb.append(mesaj);
                    jEditorPane1.setText(sb.toString());
                    jEditorPane1.setText(mesaj);
                }
            } catch (Exception e) {
                System.err.println("Dinleme hatası:" + e);
            }
        };
        new Thread(dinle).start();
    }
    private void btnGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGonderActionPerformed
        if ((deger = txtMesaj.getText().trim()) != null) {
            out.println(deger);
            mesaj += "<div style='background:#DDFEC7;border:1px solid #7DBFAB;margin:5px;padding:3px'>" + deger + "</div>" + "\n";
            sb.append(mesaj);
            jEditorPane1.setText(sb.toString());
            jEditorPane1.setText(mesaj);

        }
        txtMesaj.setText("");
        txtMesaj.requestFocus();
    }//GEN-LAST:event_btnGonderActionPerformed

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
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new server().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGonder;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtMesaj;
    // End of variables declaration//GEN-END:variables
}
