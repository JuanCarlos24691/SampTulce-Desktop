package index;

import interfaces.IManagerData;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Arrays;
import resource.loadFont;
import resource.managerData;
import resource.showDialog;

public class login extends javax.swing.JPanel {

    // Object
    private final IManagerData OManagerData = new managerData();

    private final char noCharacterUserName[] = {'\'', '°', '|', '!', '"', '#', '$', '%', '&', '/', '(', ')', '?', '¡',
        '¿', '<', '>', ',', ';', '.', ':', '-', '{', '[', '}', ']', '´', '¨', '+', '*', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '0'};
    
    private final char noCharacterPassword[] = {'\'', '=', ',', '*', '.'};

    public login() {

        run.window.setSize(650, 450);
        run.window.setLocationRelativeTo(null);
        run.window.setTitle("Ingresar - SampTulce");
        run.window.setResizable(false);
        run.window.setVisible(true);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        goAccount = new javax.swing.JButton();
        nowAccountTwo = new javax.swing.JLabel();
        nowAccountOne = new javax.swing.JLabel();
        getPassword = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new loadFont().loadFonts(System.getProperty("user.dir") + "/src/main/resources/fonts/Quicksand-SemiBold.ttf", 35));
        title.setText("Iniciar sesion");

        userName.setBackground(new java.awt.Color(245, 245, 245));
        userName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        userName.setForeground(new java.awt.Color(100, 100, 100));
        userName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userName.setText("Nombre de usuario");
        userName.setBorder(null);
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNameKeyTyped(evt);
            }
        });

        password.setBackground(new java.awt.Color(245, 245, 245));
        password.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        password.setForeground(new java.awt.Color(100, 100, 100));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("012345678");
        password.setBorder(null);
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        goAccount.setBackground(null);
        goAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        goAccount.setForeground(new java.awt.Color(0, 117, 239));
        goAccount.setText("Abrir sesión");
        goAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goAccountActionPerformed(evt);
            }
        });

        nowAccountTwo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        nowAccountTwo.setForeground(new java.awt.Color(0, 117, 239));
        nowAccountTwo.setText("Crear una cuenta");
        nowAccountTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nowAccountTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nowAccountTwoMouseClicked(evt);
            }
        });

        nowAccountOne.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        nowAccountOne.setForeground(new java.awt.Color(100, 100, 100));
        nowAccountOne.setText("¿Eres nuevo?");

        getPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        getPassword.setForeground(new java.awt.Color(0, 117, 239));
        getPassword.setText("Olvide mi contraseña");
        getPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(title)
                .addContainerGap(381, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(goAccount))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nowAccountOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nowAccountTwo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(getPassword))
                    .addComponent(userName))
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title)
                .addGap(66, 66, 66)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(goAccount)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nowAccountOne)
                    .addComponent(nowAccountTwo))
                .addGap(18, 18, 18)
                .addComponent(getPassword)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goAccountActionPerformed
        if (evt.getSource() == this.goAccount) {
            if (!this.userName.getText().isEmpty() && this.userName.getText().length() <= 25 && !Arrays.toString(this.password.getPassword()).isEmpty() && this.password.getPassword().length <= 25 && this.userName.getText().contains("_")) {

                try {
                    this.OManagerData.select("SELECT name, password FROM accounts WHERE name = '" + this.userName.getText() + "' AND password = '" + new String(this.password.getPassword()) + "'");

                    if (this.OManagerData.getRs().next()) {

                        run.USER_DB = this.OManagerData.getRs().getString("name");

                        run.window.setVisible(false);
                        this.setVisible(false);
                        this.removeAll();
                        run.window.remove(this);
                        run.window.add(new account(), BorderLayout.CENTER, 0);

                    } else {
                        new showDialog().message("Esta cuenta no existe o los datos son erroneos\nPor favor vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                    System.exit(1);
                } finally {
                    this.OManagerData.SQLClose();
                }
            } else {
                if (this.userName.getText().length() > 25 || this.password.getPassword().length > 25 || this.userName.getText().length() == 0 || this.password.getPassword().length == 0) {
                    new showDialog().message("Uno de los campos tiene una longitud demasiado grande o no hay nada escrito\nel maximo es de 25 caracteres, Por favor vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                } else if (!this.userName.getText().contains("_")) {
                    new showDialog().message("El formato de nombre no es correcto\nPor favor utiliza Nombre_Apellido y vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                }
            }
        }
    }//GEN-LAST:event_goAccountActionPerformed

    private void userNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyTyped
        if (evt.getSource() == this.userName) {
            for (int i = 0; i < this.noCharacterUserName.length; i++) {
                if (evt.getKeyChar() == this.noCharacterUserName[i]) {
                    evt.consume();
                }
            }
        }
    }//GEN-LAST:event_userNameKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        if (evt.getSource() == this.password) {
            for (int i = 0; i < this.noCharacterPassword.length; i++) {
                if (evt.getKeyChar() == this.noCharacterPassword[i]) {
                    evt.consume();
                }
            }
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void nowAccountTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nowAccountTwoMouseClicked
        if (evt.getSource() == this.nowAccountTwo && this.nowAccountTwo.isEnabled()) {
            new showDialog().message("Esta funcion no esta disponible", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
        }
    }//GEN-LAST:event_nowAccountTwoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel getPassword;
    private javax.swing.JButton goAccount;
    private javax.swing.JLabel nowAccountOne;
    private javax.swing.JLabel nowAccountTwo;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel title;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}