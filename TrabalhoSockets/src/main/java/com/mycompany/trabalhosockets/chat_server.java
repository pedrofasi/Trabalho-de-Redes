package com.mycompany.trabalhosockets;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
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
public class chat_server extends javax.swing.JFrame {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream msg_in;
    static DataOutputStream msg_out;
    
    public chat_server() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // Código abaixo gerado pelo NETBEANS
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Sockets");
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("SERVIDOR");

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

        msg_send.setBackground(new java.awt.Color(102, 102, 102));
        msg_send.setForeground(new java.awt.Color(204, 204, 204));
        msg_send.setText("Enviar");
        msg_send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        msg_area.setEditable(false);
        msg_area.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(msg_area);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(msg_text))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                msgout = msg_text.getText().trim();
                msg_out.writeUTF(msgout);
                msgtext = msgtext+"<b><font color=green>Server: </font></b>"+msgout+"<br>";// aparece a mensagem no display pelo server
                msg_area.setContentType("text/html");
                msg_area.setText("<html>"+msgtext+"</html>");
                msg_text.setText("Escreva uma mensagem");
                msg_text.setForeground(new Color(204,204,204));
            }
        }
        catch(Exception e){
        }
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
                new chat_server().setVisible(true);
            }
        });
        String msgin = "";
        try{
            ss = new ServerSocket(1201); // servidor começa com a porta 1201
            s = ss.accept(); // servidor permite a conecção
            msg_in = new DataInputStream(s.getInputStream()); // variavel responsavel por receber as mensagens
            msg_out = new DataOutputStream(s.getOutputStream()); // variavel responsavel por enviar as mensagens
            // renderizando as mensagens na tela em HTML
            while(!msgin.equals("exit")){
                msgin = msg_in.readUTF();
                msgtext = msgtext+"<b><font color=red>Cliente: </font></b>"+msgin+"<br>";// aparece a mensagem no display pelo cliente
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextPane msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
