
import ChatEncrypter.Cryptography.EncoderDecoder;
import ChatEncrypter.Networking.MessageTransmitter;
import ChatEncrypter.Networking.WritableGUI;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class ChatGUI extends javax.swing.JFrame implements WritableGUI {

    private Inet4Address inet4Address;
    private Socket sendSocket;
    private MessageTransmitter messageTransmitter;
    private PublicKey publicKey;
    /**
     * Creates new form ChatGUI
     */
    public ChatGUI() {
        initComponents();
        getContentPane().setBackground(Color.YELLOW);
        aes.setActionCommand("AES");
        des.setActionCommand("DES");
        setVisible(true);
        sendButton.setMnemonic(KeyEvent.VK_ENTER);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                disconnectClient();

            }
        });

        try {
            this.inet4Address = (Inet4Address) Inet4Address.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Can't fetch local host!!");
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jLabel3 = new javax.swing.JLabel();
        hostIpLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hostPortLabel = new javax.swing.JLabel();
        messageTextArea = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        isConnected = new javax.swing.JLabel();
        clientIpLabel = new javax.swing.JLabel();
        clientPortLabel = new javax.swing.JLabel();
        aes = new javax.swing.JRadioButton();
        des = new javax.swing.JRadioButton();
        sendFile = new javax.swing.JButton();

        fileChooser.setApproveButtonText("Select File");
        fileChooser.setDialogTitle("Select file to send");
        fileChooser.setFileHidingEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setBackground(new java.awt.Color(51, 255, 204));

        jLabel3.setText("IP");

        hostIpLabel.setText("localhost");

        jLabel5.setText("Port");

        hostPortLabel.setText("3128");

        messageTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageTextAreaActionPerformed(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(51, 0, 255));
        sendButton.setFont(new java.awt.Font("Bodoni MT Black", 0, 11)); // NOI18N
        sendButton.setText("SEND");
        sendButton.setToolTipText("Click to send the message");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        chatArea.setEditable(false);
        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        isConnected.setForeground(java.awt.Color.red);
        isConnected.setText("Disconnected");

        clientIpLabel.setText("clientIP");

        clientPortLabel.setText("clientPort");

        buttonGroup1.add(aes);
        aes.setSelected(true);
        aes.setText("AES");
        aes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aesActionPerformed(evt);
            }
        });

        buttonGroup1.add(des);
        des.setText("DES");

        sendFile.setBackground(new java.awt.Color(0, 255, 0));
        sendFile.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        sendFile.setText("Send File");
        sendFile.setEnabled(false);
        sendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hostIpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addComponent(hostPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isConnected)
                .addGap(30, 30, 30)
                .addComponent(clientIpLabel)
                .addGap(32, 32, 32)
                .addComponent(clientPortLabel)
                .addGap(18, 18, 18)
                .addComponent(aes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(des)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(messageTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostIpLabel)
                    .addComponent(jLabel5)
                    .addComponent(hostPortLabel)
                    .addComponent(isConnected)
                    .addComponent(clientIpLabel)
                    .addComponent(clientPortLabel)
                    .addComponent(aes)
                    .addComponent(des))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton)
                    .addComponent(sendFile)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed

        String message = this.messageTextArea.getText();
        String original = message;
        String cryptAlgo = buttonGroup1.getSelection().getActionCommand();
        if (message != null && !message.equals("")) {
            message = EncoderDecoder.encodeMessage(message, cryptAlgo,publicKey);
            messageTransmitter.send(message,original);
        }

        //MessageTransmitter mt = new MessageTransmitter(, message, ABORT)
    }//GEN-LAST:event_sendButtonActionPerformed

    private void messageTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageTextAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageTextAreaActionPerformed

    private void aesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aesActionPerformed

    private void sendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileActionPerformed

        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            System.out.println("File selected: "+ file.getAbsolutePath());
            String message = "Iamsendingafile";
            String original = message;
            String cryptAlgo = buttonGroup1.getSelection().getActionCommand();
            message = EncoderDecoder.encodeMessage(message, cryptAlgo,publicKey);
            String fileNameEncrypted = EncoderDecoder.encodeMessage(file.getName(), cryptAlgo, publicKey);
            messageTransmitter.send(message,original);
            messageTransmitter.send(fileNameEncrypted,file.getName()+"is sent");
            
            try {
                String fileEncrypted = new String(Files.readAllBytes(Paths.get(file.getPath())));
                fileEncrypted = EncoderDecoder.encodeMessage(fileEncrypted, cryptAlgo, publicKey);
                messageTransmitter.sendFile(fileEncrypted);
            } catch (IOException ex) {
                Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            System.out.println("File Selection is cancelled by the user");
        }
        
    }//GEN-LAST:event_sendFileActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Nimbus Look and Feel is not present for your System");
            java.util.logging.Logger.getLogger(ChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChatGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JLabel clientIpLabel;
    private javax.swing.JLabel clientPortLabel;
    private javax.swing.JRadioButton des;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel hostIpLabel;
    private javax.swing.JLabel hostPortLabel;
    private javax.swing.JLabel isConnected;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField messageTextArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendFile;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String s) {
        chatArea.append(s + System.lineSeparator());
    }

    @Override
    public void clear() {
        messageTextArea.setText("");
    }

    @Override
    public void connectClient(String ip, int port) {

        isConnected.setText("Connected");
        clientIpLabel.setText(ip);
        clientPortLabel.setText(port + "");
        isConnected.setForeground(Color.blue);
    }

    @Override
    public void disconnectClient() {

        isConnected.setText("Disconnected");
        isConnected.setForeground(Color.red);
        clientIpLabel.setText("clientIp");
        clientPortLabel.setText("clientPort");

    }

    @Override
    public void showHostInfo(String hostIp, int hostPort) {

        hostIpLabel.setText(hostIp);
        hostPortLabel.setText(hostPort + "");

    }

    @Override
    public void showClientInfo(String clientIp, int clientPort) {

        clientIpLabel.setText(clientIp);
        clientPortLabel.setText(clientPort + "");

    }

    public void setSendSocket(Socket sendSocket) {
        this.sendSocket = sendSocket;
        sendButton.setEnabled(true);
        sendFile.setEnabled(true);
        messageTransmitter = new MessageTransmitter(sendSocket, this);
    }
    
    public void setSendPublicKey(PublicKey publicKey)
    {
        this.publicKey = publicKey;
    }

}
