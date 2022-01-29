package index;

import java.awt.BorderLayout;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import resource.borderRounder;
import resource.loadFont;
import resource.managerData;
import resource.openBrowser;
import resource.showDialog;

public class account extends javax.swing.JPanel {

    // Object
    private final managerData OManagerData = new managerData();

    public account() throws SQLException {

        run.window.setSize(850, 550);
        run.window.setLocationRelativeTo(null);
        run.window.setTitle("Cuenta - SampTulce");
        run.window.setResizable(true);
        run.window.setVisible(true);

        initComponents();

        this.dataAccount();
        this.userDesing();
    }

    private void userDesing() {
        this.discord.setToolTipText("Ir al Discord");
        this.facebook.setToolTipText("Ir a Facebook");
        this.aggServerIp.setToolTipText("Agregar IP del servidor");
        this.userLevel.setToolTipText(this.userLevel.getText());
        this.userRep.setToolTipText(this.userRep.getText());
        this.userMoneyTwo.setToolTipText(this.userMoneyTwo.getText());
        this.userVoz.setToolTipText(this.userVoz.getText());
        this.userSex.setToolTipText(this.userSex.getText());
        this.userPhone.setToolTipText(this.userPhone.getText());
        this.userMail.setToolTipText(this.userMail.getText());
        this.userVip.setToolTipText(this.userVip.getText());
        this.userIP.setToolTipText(this.userIP.getText());
        this.userAdmin.setToolTipText(this.userAdmin.getText());
        this.userWarn.setToolTipText(this.userWarn.getText());
        this.userMember.setToolTipText(this.userMember.getText());
    }

    private void dataAccount() {

        try {
            this.OManagerData.select("SELECT * FROM accounts LEFT JOIN bans ON bans.name = accounts.name LEFT JOIN fraction ON fraction.id = accounts.member WHERE accounts.name = '" + run.USER_DB + "'");
            this.OManagerData.getRs().next();

            // Información del personaje
            ImageIcon rescaleSkin = new javax.swing.ImageIcon(getClass().getResource("/PJ/_" + this.OManagerData.getRs().getInt("accounts.model") + ".png"));
            rescaleSkin = new ImageIcon(rescaleSkin.getImage().getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING));
            this.userSkin.setIcon(rescaleSkin);
            this.userSkin.setBorder(new borderRounder(new java.awt.Color(150, 150, 150), 2, 80, 80));

            this.userName.setText(this.OManagerData.getRs().getString("accounts.name"));
            this.userID.setText("- DB-ID: " + this.OManagerData.getRs().getString("accounts.id"));

            this.userLevel.setText("Nivel: " + this.OManagerData.getRs().getString("accounts.level"));
            this.userRep.setText("Rep: " + this.OManagerData.getRs().getString("accounts.rep"));
            this.userMoneyTwo.setText("$" + this.OManagerData.getRs().getInt("accounts.cash"));
            this.userBankTwo.setText("$" + this.OManagerData.getRs().getInt("accounts.bank"));
            this.userVoz.setText("Edad: +" + this.OManagerData.getRs().getString("accounts.voz"));

            switch (this.OManagerData.getRs().getInt("accounts.sex")) {
                case 1 ->
                    this.userSex.setText("Sexo: Hombre");
                case 2 ->
                    this.userSex.setText("Sexo: Mujer");
                case 3 ->
                    this.userSex.setText("Sexo: Travesti");
                case 4 ->
                    this.userSex.setText("Sexo: Marimacho");
                default ->
                    this.userSex.setText("Sexo: Desconocido");
            }

            if (this.OManagerData.getRs().getInt("accounts.phone") != 0) {
                this.userPhone.setText("Tel: " + this.OManagerData.getRs().getString("accounts.phone"));
            } else if (this.OManagerData.getRs().getInt("accounts.phone") == 0) {
                this.userPhone.setText("Tel: No tiene");
            }

            this.userMail.setText("Gmail: " + this.OManagerData.getRs().getString("accounts.mail"));

            if (this.OManagerData.getRs().getInt("accounts.vip") != 0) {
                this.userVip.setText("VIP: Activo");
            } else if (this.OManagerData.getRs().getInt("accounts.vip") == 0) {
                this.userVip.setText("VIP: No tiene");
            }

            this.userIP.setText("IP: " + this.OManagerData.getRs().getString("accounts.ip"));

            // Notificaciones
            if (this.OManagerData.getRs().getInt("accounts.admin") > 6 || this.OManagerData.getRs().getInt("accounts.admin") == 0) {
                this.userAdminPane.setVisible(false);
                this.remove(this.userAdminPane);

            } else if (this.OManagerData.getRs().getInt("accounts.admin") != 0) {

                switch (this.OManagerData.getRs().getInt("accounts.admin")) {
                    case 1 ->
                        this.userAdmin.setText("Ingresaste como: Ayudante");
                    case 2 ->
                        this.userAdmin.setText("Ingresaste como: Moderador");
                    case 3 ->
                        this.userAdmin.setText("Ingresaste como: Moderador Plus");
                    case 4 ->
                        this.userAdmin.setText("Ingresaste como: Super moderador");
                    case 5 ->
                        this.userAdmin.setText("Ingresaste como: Soporte");
                    case 6 ->
                        this.userAdmin.setText("Ingresaste como: Administrador");
                }
            }

            if (this.OManagerData.getRs().getString("bans.name") != null) {
                this.userWarn.setText("Fuiste baneado por " + this.OManagerData.getRs().getString("bans.whobanned") + ", Razon: " + this.OManagerData.getRs().getString("bans.reason") + " (Fecha: " + this.OManagerData.getRs().getString("bans.bandate") + ")");
            } else if (this.OManagerData.getRs().getInt("accounts.warn") > 3 || this.OManagerData.getRs().getInt("accounts.warn") == 0) {
                this.userPaneWarn.setVisible(false);
                this.remove(this.userPaneWarn);
            } else if (this.OManagerData.getRs().getInt("accounts.warn") < 3) {
                this.userWarn.setText("Advertencias: " + this.OManagerData.getRs().getInt("accounts.warn") + "(Sí, llegas a las 3 advertencias seras baneado por 10 días)");
            }

            if (this.OManagerData.getRs().getString("fraction.name") != null) {
                this.userMember.setText("Ingresaste como: " + this.OManagerData.getRs().getString("fraction.name") + " (" + this.OManagerData.getRs().getString("fraction.rank" + this.OManagerData.getRs().getInt("accounts.rank")) + ")");
            } else {
                this.userMemberPane.setVisible(false);
                this.remove(this.userMemberPane);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } finally {
            this.OManagerData.SQLClose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userName = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();
        hideSesion = new javax.swing.JLabel();
        infoUser = new javax.swing.JLabel();
        userAdminPane = new javax.swing.JPanel();
        userAdmin = new javax.swing.JLabel();
        userNotification = new javax.swing.JLabel();
        infoPane1 = new javax.swing.JPanel();
        userMoneyOne = new javax.swing.JLabel();
        userMoneyTwo = new javax.swing.JLabel();
        userBankOne = new javax.swing.JLabel();
        userBankTwo = new javax.swing.JLabel();
        infoPane2 = new javax.swing.JPanel();
        userLevel = new javax.swing.JLabel();
        userRep = new javax.swing.JLabel();
        infoPane3 = new javax.swing.JPanel();
        userVoz = new javax.swing.JLabel();
        userMail = new javax.swing.JLabel();
        infoPane4 = new javax.swing.JPanel();
        userPhone = new javax.swing.JLabel();
        userSex = new javax.swing.JLabel();
        infoPane5 = new javax.swing.JPanel();
        userIP = new javax.swing.JLabel();
        userVip = new javax.swing.JLabel();
        userPaneWarn = new javax.swing.JPanel();
        userWarn = new javax.swing.JLabel();
        userPaneNotification2 = new javax.swing.JPanel();
        userAdmin2 = new javax.swing.JLabel();
        userMemberPane = new javax.swing.JPanel();
        userMember = new javax.swing.JLabel();
        userPaneNotification4 = new javax.swing.JPanel();
        userAdmin4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userSkin = new javax.swing.JLabel();
        infoUser1 = new javax.swing.JLabel();
        inventoryPane1 = new javax.swing.JPanel();
        userLevel1 = new javax.swing.JLabel();
        userBankOne1 = new javax.swing.JLabel();
        userBankTwo1 = new javax.swing.JLabel();
        inventoryPane3 = new javax.swing.JPanel();
        userLevel2 = new javax.swing.JLabel();
        userBankOne2 = new javax.swing.JLabel();
        userBankTwo2 = new javax.swing.JLabel();
        inventoryPane4 = new javax.swing.JPanel();
        userLevel3 = new javax.swing.JLabel();
        userBankOne3 = new javax.swing.JLabel();
        userBankTwo3 = new javax.swing.JLabel();
        inventoryPane5 = new javax.swing.JPanel();
        userLevel4 = new javax.swing.JLabel();
        userBankOne4 = new javax.swing.JLabel();
        userBankTwo4 = new javax.swing.JLabel();
        inventoryPane2 = new javax.swing.JPanel();
        userLevel5 = new javax.swing.JLabel();
        userBankOne5 = new javax.swing.JLabel();
        userBankTwo5 = new javax.swing.JLabel();
        exitApp = new javax.swing.JLabel();
        separatorOne = new javax.swing.JLabel();
        aggServerIp = new javax.swing.JLabel();
        facebook = new javax.swing.JLabel();
        discord = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        userName.setFont(new loadFont().loadFonts(System.getProperty("user.dir") + "/src/main/resources/fonts/Quicksand-SemiBold.ttf", 20));
        userName.setText("Nombre de usuario");

        userID.setFont(new loadFont().loadFonts(System.getProperty("user.dir") + "/src/main/resources/fonts/Quicksand-SemiBold.ttf", 20));
        userID.setText("- DB-ID: 0");

        hideSesion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        hideSesion.setForeground(new java.awt.Color(0, 153, 255));
        hideSesion.setText("Cerrar sesión");
        hideSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hideSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideSesionMouseClicked(evt);
            }
        });

        infoUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoUser.setForeground(new java.awt.Color(102, 102, 102));
        infoUser.setText("INFORMACIÓN");

        userAdminPane.setBackground(new java.awt.Color(209, 237, 255));

        userAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userAdmin.setForeground(new java.awt.Color(100, 100, 100));
        userAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        userAdmin.setText("Ingresaste como: No se ha espesificado");

        javax.swing.GroupLayout userAdminPaneLayout = new javax.swing.GroupLayout(userAdminPane);
        userAdminPane.setLayout(userAdminPaneLayout);
        userAdminPaneLayout.setHorizontalGroup(
            userAdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userAdminPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        userAdminPaneLayout.setVerticalGroup(
            userAdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userAdminPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userNotification.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userNotification.setForeground(new java.awt.Color(102, 102, 102));
        userNotification.setText("NOTIFICACIONES");

        userMoneyOne.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userMoneyOne.setForeground(new java.awt.Color(100, 100, 100));
        userMoneyOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N
        userMoneyOne.setText("Dinero:");

        userMoneyTwo.setBackground(new java.awt.Color(255, 255, 255));
        userMoneyTwo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userMoneyTwo.setForeground(new java.awt.Color(77, 189, 20));
        userMoneyTwo.setText("No se ha definido");

        userBankOne.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne.setText("Banco:");

        userBankTwo.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo.setText("No se ha definido");

        javax.swing.GroupLayout infoPane1Layout = new javax.swing.GroupLayout(infoPane1);
        infoPane1.setLayout(infoPane1Layout);
        infoPane1Layout.setHorizontalGroup(
            infoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userMoneyOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userMoneyTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userBankOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPane1Layout.setVerticalGroup(
            infoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userMoneyOne)
                    .addComponent(userMoneyTwo)
                    .addComponent(userBankTwo)
                    .addComponent(userBankOne))
                .addContainerGap())
        );

        infoPane2.setBackground(new java.awt.Color(245, 245, 245));

        userLevel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel.setForeground(new java.awt.Color(100, 100, 100));
        userLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel.setText("Nivel: No se ha definido");

        userRep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userRep.setForeground(new java.awt.Color(100, 100, 100));
        userRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rep.png"))); // NOI18N
        userRep.setText("Rep: No se ha definido");

        javax.swing.GroupLayout infoPane2Layout = new javax.swing.GroupLayout(infoPane2);
        infoPane2.setLayout(infoPane2Layout);
        infoPane2Layout.setHorizontalGroup(
            infoPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userRep, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPane2Layout.setVerticalGroup(
            infoPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLevel)
                    .addComponent(userRep))
                .addContainerGap())
        );

        userVoz.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userVoz.setForeground(new java.awt.Color(100, 100, 100));
        userVoz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voz.png"))); // NOI18N
        userVoz.setText("Edad: No se ha definido");

        userMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userMail.setForeground(new java.awt.Color(100, 100, 100));
        userMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        userMail.setText("Correo: No se ha definido");

        javax.swing.GroupLayout infoPane3Layout = new javax.swing.GroupLayout(infoPane3);
        infoPane3.setLayout(infoPane3Layout);
        infoPane3Layout.setHorizontalGroup(
            infoPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userVoz, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userMail, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPane3Layout.setVerticalGroup(
            infoPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userVoz)
                    .addComponent(userMail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoPane4.setBackground(new java.awt.Color(245, 245, 245));

        userPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userPhone.setForeground(new java.awt.Color(100, 100, 100));
        userPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cell-phone.png"))); // NOI18N
        userPhone.setText("Tel: No se ha definido");

        userSex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userSex.setForeground(new java.awt.Color(100, 100, 100));
        userSex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sex.png"))); // NOI18N
        userSex.setText("Sexo: No se ha definido");

        javax.swing.GroupLayout infoPane4Layout = new javax.swing.GroupLayout(infoPane4);
        infoPane4.setLayout(infoPane4Layout);
        infoPane4Layout.setHorizontalGroup(
            infoPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userSex, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPane4Layout.setVerticalGroup(
            infoPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPhone)
                    .addComponent(userSex))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userIP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userIP.setForeground(new java.awt.Color(100, 100, 100));
        userIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ip-address.png"))); // NOI18N
        userIP.setText("IP: No se ha definido");

        userVip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userVip.setForeground(new java.awt.Color(100, 100, 100));
        userVip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vip.png"))); // NOI18N
        userVip.setText("VIP: No se ha definido");

        javax.swing.GroupLayout infoPane5Layout = new javax.swing.GroupLayout(infoPane5);
        infoPane5.setLayout(infoPane5Layout);
        infoPane5Layout.setHorizontalGroup(
            infoPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userVip, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        infoPane5Layout.setVerticalGroup(
            infoPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIP)
                    .addComponent(userVip))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userPaneWarn.setBackground(new java.awt.Color(255, 209, 209));

        userWarn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userWarn.setForeground(new java.awt.Color(100, 100, 100));
        userWarn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warn.png"))); // NOI18N
        userWarn.setText("Advertencias: No se ha espesificado");

        javax.swing.GroupLayout userPaneWarnLayout = new javax.swing.GroupLayout(userPaneWarn);
        userPaneWarn.setLayout(userPaneWarnLayout);
        userPaneWarnLayout.setHorizontalGroup(
            userPaneWarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneWarnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        userPaneWarnLayout.setVerticalGroup(
            userPaneWarnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneWarnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userWarn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userPaneNotification2.setBackground(new java.awt.Color(217, 255, 209));

        userAdmin2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userAdmin2.setForeground(new java.awt.Color(100, 100, 100));
        userAdmin2.setText("Ingresaste como: No se ha espesificado");

        javax.swing.GroupLayout userPaneNotification2Layout = new javax.swing.GroupLayout(userPaneNotification2);
        userPaneNotification2.setLayout(userPaneNotification2Layout);
        userPaneNotification2Layout.setHorizontalGroup(
            userPaneNotification2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneNotification2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        userPaneNotification2Layout.setVerticalGroup(
            userPaneNotification2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneNotification2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userMemberPane.setBackground(new java.awt.Color(209, 210, 255));

        userMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userMember.setForeground(new java.awt.Color(100, 100, 100));
        userMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member.png"))); // NOI18N
        userMember.setText("Ingresaste como: No se ha espesificado");

        javax.swing.GroupLayout userMemberPaneLayout = new javax.swing.GroupLayout(userMemberPane);
        userMemberPane.setLayout(userMemberPaneLayout);
        userMemberPaneLayout.setHorizontalGroup(
            userMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userMemberPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userMember, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        userMemberPaneLayout.setVerticalGroup(
            userMemberPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userMemberPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userMember)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userPaneNotification4.setBackground(new java.awt.Color(255, 240, 209));

        userAdmin4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userAdmin4.setForeground(new java.awt.Color(100, 100, 100));
        userAdmin4.setText("Ingresaste como: No se ha espesificado");

        javax.swing.GroupLayout userPaneNotification4Layout = new javax.swing.GroupLayout(userPaneNotification4);
        userPaneNotification4.setLayout(userPaneNotification4Layout);
        userPaneNotification4Layout.setHorizontalGroup(
            userPaneNotification4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneNotification4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        userPaneNotification4Layout.setVerticalGroup(
            userPaneNotification4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneNotification4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userAdmin4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        userSkin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PJ/_0.png"))); // NOI18N
        userSkin.setMaximumSize(new java.awt.Dimension(236, 236));

        infoUser1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoUser1.setForeground(new java.awt.Color(102, 102, 102));
        infoUser1.setText("INVENTARIO");

        userLevel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel1.setForeground(new java.awt.Color(100, 100, 100));
        userLevel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel1.setText("Nivel: No se ha definido");

        userBankOne1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne1.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne1.setText("Banco:");

        userBankTwo1.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo1.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo1.setText("No se ha definido");

        javax.swing.GroupLayout inventoryPane1Layout = new javax.swing.GroupLayout(inventoryPane1);
        inventoryPane1.setLayout(inventoryPane1Layout);
        inventoryPane1Layout.setHorizontalGroup(
            inventoryPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBankOne1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPane1Layout.setVerticalGroup(
            inventoryPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userBankOne1)
                    .addComponent(userBankTwo1)
                    .addComponent(userLevel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userLevel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel2.setForeground(new java.awt.Color(100, 100, 100));
        userLevel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel2.setText("Nivel: No se ha definido");

        userBankOne2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne2.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne2.setText("Banco:");

        userBankTwo2.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo2.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo2.setText("No se ha definido");

        javax.swing.GroupLayout inventoryPane3Layout = new javax.swing.GroupLayout(inventoryPane3);
        inventoryPane3.setLayout(inventoryPane3Layout);
        inventoryPane3Layout.setHorizontalGroup(
            inventoryPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBankOne2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPane3Layout.setVerticalGroup(
            inventoryPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userBankOne2)
                    .addComponent(userBankTwo2)
                    .addComponent(userLevel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inventoryPane4.setBackground(new java.awt.Color(245, 245, 245));

        userLevel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel3.setForeground(new java.awt.Color(100, 100, 100));
        userLevel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel3.setText("Nivel: No se ha definido");

        userBankOne3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne3.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne3.setText("Banco:");

        userBankTwo3.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo3.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo3.setText("No se ha definido");

        javax.swing.GroupLayout inventoryPane4Layout = new javax.swing.GroupLayout(inventoryPane4);
        inventoryPane4.setLayout(inventoryPane4Layout);
        inventoryPane4Layout.setHorizontalGroup(
            inventoryPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBankOne3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLevel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPane4Layout.setVerticalGroup(
            inventoryPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userBankOne3)
                    .addComponent(userBankTwo3)
                    .addComponent(userLevel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userLevel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel4.setForeground(new java.awt.Color(100, 100, 100));
        userLevel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel4.setText("Nivel: No se ha definido");

        userBankOne4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne4.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne4.setText("Banco:");

        userBankTwo4.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo4.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo4.setText("No se ha definido");

        javax.swing.GroupLayout inventoryPane5Layout = new javax.swing.GroupLayout(inventoryPane5);
        inventoryPane5.setLayout(inventoryPane5Layout);
        inventoryPane5Layout.setHorizontalGroup(
            inventoryPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBankOne4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLevel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPane5Layout.setVerticalGroup(
            inventoryPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userBankOne4)
                    .addComponent(userBankTwo4)
                    .addComponent(userLevel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inventoryPane2.setBackground(new java.awt.Color(245, 245, 245));

        userLevel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLevel5.setForeground(new java.awt.Color(100, 100, 100));
        userLevel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/level.png"))); // NOI18N
        userLevel5.setText("Nivel: No se ha definido");

        userBankOne5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankOne5.setForeground(new java.awt.Color(100, 100, 100));
        userBankOne5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        userBankOne5.setText("Banco:");

        userBankTwo5.setBackground(new java.awt.Color(255, 255, 255));
        userBankTwo5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBankTwo5.setForeground(new java.awt.Color(77, 189, 20));
        userBankTwo5.setText("No se ha definido");

        javax.swing.GroupLayout inventoryPane2Layout = new javax.swing.GroupLayout(inventoryPane2);
        inventoryPane2.setLayout(inventoryPane2Layout);
        inventoryPane2Layout.setHorizontalGroup(
            inventoryPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBankOne5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBankTwo5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLevel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryPane2Layout.setVerticalGroup(
            inventoryPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userBankOne5)
                    .addComponent(userBankTwo5)
                    .addComponent(userLevel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        exitApp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        exitApp.setForeground(new java.awt.Color(0, 153, 255));
        exitApp.setText("Salir");
        exitApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitAppMouseClicked(evt);
            }
        });

        separatorOne.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        separatorOne.setForeground(new java.awt.Color(100, 100, 100));
        separatorOne.setText("-");
        separatorOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        aggServerIp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SA-MP.png"))); // NOI18N
        aggServerIp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aggServerIp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aggServerIpMouseClicked(evt);
            }
        });

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/facebook.png"))); // NOI18N
        facebook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        facebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facebookMouseClicked(evt);
            }
        });

        discord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/discord.png"))); // NOI18N
        discord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        discord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userSkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userID))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(hideSesion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separatorOne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitApp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(facebook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aggServerIp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
                            .addComponent(infoPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inventoryPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inventoryPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inventoryPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inventoryPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoUser1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE))
                            .addComponent(inventoryPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userPaneNotification4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userPaneNotification2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userMemberPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userAdminPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userPaneWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(101, 101, 101)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(facebook)
                                .addComponent(aggServerIp)
                                .addComponent(discord))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(userName)
                                    .addComponent(userID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hideSesion)
                                    .addComponent(exitApp)
                                    .addComponent(separatorOne)))))
                    .addComponent(userSkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoUser1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventoryPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventoryPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userNotification)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userAdminPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userPaneWarn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userMemberPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventoryPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inventoryPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventoryPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userPaneNotification2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userPaneNotification4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hideSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideSesionMouseClicked
        if (evt.getSource() == this.hideSesion) {
            
            run.window.setVisible(false);
            this.setVisible(false);
            this.removeAll();
            run.window.remove(this);
            run.window.add(new login(), BorderLayout.CENTER);
        }
    }//GEN-LAST:event_hideSesionMouseClicked

    private void exitAppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitAppMouseClicked
        if (evt.getSource() == this.exitApp) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitAppMouseClicked

    private void facebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookMouseClicked
        if (evt.getSource() == this.facebook) {
            new openBrowser().openURL("https://www.facebook.com/juanca24691/");
        }
    }//GEN-LAST:event_facebookMouseClicked

    private void aggServerIpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aggServerIpMouseClicked
        if (evt.getSource() == this.aggServerIp) {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new openBrowser().openURL("samp://52.167.129.168:7777");
            } else {
                new showDialog().message("SA-MP no se encuentra disponible en su sistema operativo", getClass().getResource("/images/cancel.png"), new String[]{"Aceptar"});
            }
        }
    }//GEN-LAST:event_aggServerIpMouseClicked

    private void discordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discordMouseClicked
        if (evt.getSource() == this.discord) {
            new openBrowser().openURL("https://discord.gg/skyREvqVyK");
        }
    }//GEN-LAST:event_discordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aggServerIp;
    private javax.swing.JLabel discord;
    private javax.swing.JLabel exitApp;
    private javax.swing.JLabel facebook;
    private javax.swing.JLabel hideSesion;
    private javax.swing.JPanel infoPane1;
    private javax.swing.JPanel infoPane2;
    private javax.swing.JPanel infoPane3;
    private javax.swing.JPanel infoPane4;
    private javax.swing.JPanel infoPane5;
    private javax.swing.JLabel infoUser;
    private javax.swing.JLabel infoUser1;
    private javax.swing.JPanel inventoryPane1;
    private javax.swing.JPanel inventoryPane2;
    private javax.swing.JPanel inventoryPane3;
    private javax.swing.JPanel inventoryPane4;
    private javax.swing.JPanel inventoryPane5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel separatorOne;
    private javax.swing.JLabel userAdmin;
    private javax.swing.JLabel userAdmin2;
    private javax.swing.JLabel userAdmin4;
    private javax.swing.JPanel userAdminPane;
    private javax.swing.JLabel userBankOne;
    private javax.swing.JLabel userBankOne1;
    private javax.swing.JLabel userBankOne2;
    private javax.swing.JLabel userBankOne3;
    private javax.swing.JLabel userBankOne4;
    private javax.swing.JLabel userBankOne5;
    private javax.swing.JLabel userBankTwo;
    private javax.swing.JLabel userBankTwo1;
    private javax.swing.JLabel userBankTwo2;
    private javax.swing.JLabel userBankTwo3;
    private javax.swing.JLabel userBankTwo4;
    private javax.swing.JLabel userBankTwo5;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userIP;
    private javax.swing.JLabel userLevel;
    private javax.swing.JLabel userLevel1;
    private javax.swing.JLabel userLevel2;
    private javax.swing.JLabel userLevel3;
    private javax.swing.JLabel userLevel4;
    private javax.swing.JLabel userLevel5;
    private javax.swing.JLabel userMail;
    private javax.swing.JLabel userMember;
    private javax.swing.JPanel userMemberPane;
    private javax.swing.JLabel userMoneyOne;
    private javax.swing.JLabel userMoneyTwo;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userNotification;
    private javax.swing.JPanel userPaneNotification2;
    private javax.swing.JPanel userPaneNotification4;
    private javax.swing.JPanel userPaneWarn;
    private javax.swing.JLabel userPhone;
    private javax.swing.JLabel userRep;
    private javax.swing.JLabel userSex;
    private javax.swing.JLabel userSkin;
    private javax.swing.JLabel userVip;
    private javax.swing.JLabel userVoz;
    private javax.swing.JLabel userWarn;
    // End of variables declaration//GEN-END:variables
}
