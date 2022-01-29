package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import resource.managerData;
import resource.networkInterface;

public class run extends javax.swing.JFrame {

    // Object
    public static final run window = new index.run();
    private static final managerData OManagerData = new managerData();

    protected static String USER_DB;

    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("mac") || System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                run.OManagerData.select("SELECT * FROM data WHERE MAC = '" + new networkInterface().macAdress() + "' AND hostName = '" + new networkInterface().ipAddress().getHostName() + "'", "app");

                if (run.OManagerData.getRs().next()) {

                    run.USER_DB = run.OManagerData.getRs().getString("name");

                    run.window.setLayout(new BorderLayout());
                    run.window.add(new account(), BorderLayout.CENTER, 0);
                } else {
                    run.window.setLayout(new BorderLayout());
                    run.window.add(new login(), BorderLayout.CENTER, 1);
                }

                run.window.getContentPane().setBackground(new Color(255, 255, 255));
                run.window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                run.window.setVisible(true);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.exit(1);
            } finally {
                run.OManagerData.SQLClose();
            }
        });
    }

    public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            component.setFocusable(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }
}
