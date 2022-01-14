package index;

import java.awt.BorderLayout;
import resource.loadFont;

public class createAccount extends javax.swing.JPanel {
    
    public createAccount() {
        
        run.window.setSize(650, 450);
        run.window.setResizable(false);
        run.window.setTitle("Registrarse - SampTulce");
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        sex = new javax.swing.JComboBox<>();
        invited = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        createAccount = new javax.swing.JButton();
        loginTextOne = new javax.swing.JLabel();
        loginTextTow = new javax.swing.JLabel();
        userVoz = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new loadFont().loadFonts(System.getProperty("user.dir") + "/src/main/resources/fonts/Quicksand-SemiBold.ttf", 35));
        title.setText("Registrarse");

        userName.setBackground(new java.awt.Color(245, 245, 245));
        userName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        userName.setForeground(new java.awt.Color(100, 100, 100));
        userName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userName.setText("Nombre de usuario");
        userName.setBorder(null);

        password.setBackground(new java.awt.Color(245, 245, 245));
        password.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        password.setForeground(new java.awt.Color(100, 100, 100));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("012345678");
        password.setBorder(null);

        sex.setBackground(new java.awt.Color(245, 245, 245));
        sex.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        sex.setForeground(new java.awt.Color(100, 100, 100));
        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        sex.setBorder(null);

        invited.setBackground(new java.awt.Color(245, 245, 245));
        invited.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        invited.setForeground(new java.awt.Color(100, 100, 100));
        invited.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invited.setText("¿Te han invitado? ");
        invited.setBorder(null);

        mail.setBackground(new java.awt.Color(245, 245, 245));
        mail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mail.setForeground(new java.awt.Color(100, 100, 100));
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mail.setText("Correo electronico");
        mail.setBorder(null);

        createAccount.setBackground(new java.awt.Color(255, 255, 255));
        createAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        createAccount.setForeground(new java.awt.Color(0, 117, 239));
        createAccount.setText("Registrarse");

        loginTextOne.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        loginTextOne.setForeground(new java.awt.Color(100, 100, 100));
        loginTextOne.setText("¿Ya tienes cuenta?");

        loginTextTow.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        loginTextTow.setForeground(new java.awt.Color(0, 117, 239));
        loginTextTow.setText("Iniciar sesión");
        loginTextTow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginTextTow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTextTowMouseClicked(evt);
            }
        });

        userVoz.setBackground(new java.awt.Color(245, 245, 245));
        userVoz.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        userVoz.setForeground(new java.awt.Color(100, 100, 100));
        userVoz.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userVoz.setText("Edad");
        userVoz.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(invited, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(createAccount))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(loginTextOne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginTextTow)))))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(title)
                    .addContainerGap(392, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invited, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createAccount)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginTextOne)
                    .addComponent(loginTextTow))
                .addGap(86, 86, 86))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(title)
                    .addContainerGap(409, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginTextTowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginTextTowMouseClicked
        if (evt.getSource() == this.loginTextTow) {
            this.setVisible(false);
            run.window.remove(this);
            run.window.add(new login(), BorderLayout.CENTER);
        }
    }//GEN-LAST:event_loginTextTowMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccount;
    private javax.swing.JTextField invited;
    private javax.swing.JLabel loginTextOne;
    private javax.swing.JLabel loginTextTow;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> sex;
    private javax.swing.JLabel title;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userVoz;
    // End of variables declaration//GEN-END:variables
}
