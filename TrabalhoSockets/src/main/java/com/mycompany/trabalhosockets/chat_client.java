package com.mycompany.trabalhosockets;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.UIManager;

/**
 *
 * Autores:
 * Ana Laura
 * Larissa Domingos
 * Pedro Henrique Reis Rodrigues
 * Tárcila Fernandez
 */
public class chat_client extends javax.swing.JFrame {
    static Socket s;
    static DataInputStream msg_in;
    static DataOutputStream msg_out;
    
    public chat_client() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // Código abaixo gerado pelo NETBEANS
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Sockets");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("CLIENTE");

        msg_text.setBackground(new java.awt.Color(153, 153, 153));
        msg_text.setForeground(new java.awt.Color(204, 204, 204));
        msg_text.setText("Escreva uma mensagem");
        msg_text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                msg_textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                msg_textFocusLost(evt);
            }
        });
        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        msg_send.setBackground(new java.awt.Color(102, 102, 102));
        msg_send.setForeground(new java.awt.Color(204, 204, 204));
        msg_send.setText("Enviar");
        msg_send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        msg_area.setEditable(false);
        msg_area.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(msg_area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Funções de comando
    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        // Quando clica no botão
        try{
            // renderizando as mensagens na tela em HTML
            if(!(msg_text.getText().equals("Escreva uma mensagem"))){
                String msgout = "";
                msgout = msg_text.getText();
                msg_out.writeUTF(msgout);
                msgtext = msgtext+"<b><font color=red>Cliente: </font></b>"+msgout+"<br>";
                msg_area.setContentType("text/html");
                msg_area.setText("<html>"+msgtext+"</html>");
                msg_text.setText("Escreva uma mensagem");
                msg_text.setForeground(new Color(204,204,204));
            }
        }
        catch(Exception e){}
    }//GEN-LAST:event_msg_sendActionPerformed

    private void msg_textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_msg_textFocusGained
        // Quando clica dentro da caixa de texto
        if(msg_text.getText().equals("Escreva uma mensagem")){
            msg_text.setText("");
            msg_text.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_msg_textFocusGained

    private void msg_textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_msg_textFocusLost
        // Quando clica fora da caixa de texto
        if(msg_text.getText().equals("")){
            msg_text.setText("Escreva uma mensagem");
            msg_text.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_msg_textFocusLost

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed
        
    }//GEN-LAST:event_msg_textActionPerformed

 
    public static void main(String args[]) {
        /* Colocando o modo de interface Nimbus */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.put( "control", new Color( 128, 128, 128) );
        UIManager.put( "info", new Color(128,128,128) );
        UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
        UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
        UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
        UIManager.put( "nimbusFocus", new Color(115,164,209) );
        UIManager.put( "nimbusGreen", new Color(176,179,50) );
        UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
        UIManager.put( "nimbusLightBackground", new Color( 18, 30, 49) );
        UIManager.put( "nimbusOrange", new Color(191,98,4) );
        UIManager.put( "nimbusRed", new Color(169,46,34) );
        UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
        UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
        UIManager.put( "text", new Color( 230, 230, 230) );
        try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
          }
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (InstantiationException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_client().setVisible(true);
            }
        });
        
        try{
            s = new Socket("127.0.0.1",1201); // local adress pois estou executando cliente e servidor na mesma máquina
            msg_in = new DataInputStream(s.getInputStream()); // variavel responsavel por receber as mensagens
            msg_out = new DataOutputStream(s.getOutputStream()); // variavel responsavel por enviar as mensagens
            String msgin = "";
            // renderizando as mensagens na tela em HTML
            while(!msgin.equals("exit")){
                msgin = msg_in.readUTF();
                msgtext = msgtext+"<b><font color=green>Server: </font></b>"+msgin+"<br>";
                msg_area.setContentType("text/html");
                msg_area.setText("<html>"+msgtext+"</html>");
            }
        }
        catch(Exception e){
        }
    }
    private static String msgtext = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextPane msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
