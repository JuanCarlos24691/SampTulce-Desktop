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
    
    public static String USER_DB;

    public login() {
        
        run.window.setSize(650, 450);
        run.window.setLocationRelativeTo(null);
        run.window.setResizable(false);
        run.window.setTitle("Ingresar - SampTulce");
        
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

        password.setBackground(new java.awt.Color(245, 245, 245));
        password.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        password.setForeground(new java.awt.Color(100, 100, 100));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("012345678");
        password.setBorder(null);

        goAccount.setBackground(new java.awt.Color(255, 255, 255));
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
                    this.OManagerData.select("SELECT name, password FROM accounts WHERE name = '" + this.userName.getText() + "'");
                    
                    if (this.OManagerData.getRs().next()) {
                        if (this.OManagerData.getRs().getString("name").equalsIgnoreCase(this.userName.getText()) && this.OManagerData.getRs().getString("password").equals(new String(this.password.getPassword()))) {
                            
                            login.USER_DB = this.OManagerData.getRs().getString("name");
                            
                            this.setVisible(false);
                            run.window.remove(this);
                            
                            run.window.add(new account(), BorderLayout.CENTER);
                        } else {
                            new showDialog().message("Los datos que haz ingresado son erroneos\nPor favor vuelve a intentalo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                        }
                    } else {
                        new showDialog().message("Esta cuenta no existe, Por favor vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                } finally {
                    this.OManagerData.SQLClose();
                }
            } else {
                if (this.userName.getText().length() > 25 || this.password.getPassword().length > 25 || this.userName.getText().length() == 0 || this.password.getPassword().length == 0) {
                    new showDialog().message("Uno de los campos tiene una longitud demasiado grande, El maximo es de 25 caracteres\nPor favor vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                } else if (!this.userName.getText().contains("_")){
                    new showDialog().message("El formato de nombre no es correcto(Formato: Nombre_Apellido)\nPor favor vuelve a intentarlo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
                }
            }
        }
    }//GEN-LAST:event_goAccountActionPerformed

    private void nowAccountTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nowAccountTwoMouseClicked
        if (evt.getSource() == this.nowAccountTwo) {
            this.setVisible(false);
            run.window.remove(this);
            
            run.window.add(new createAccount(), BorderLayout.CENTER);
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
