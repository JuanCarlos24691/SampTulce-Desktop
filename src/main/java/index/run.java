package index;

import java.awt.BorderLayout;
import java.awt.Color;

public class run extends javax.swing.JFrame{

    public static final run window = new index.run();

    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("mac") || System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else if (System.getProperty("os.name").toLowerCase().contains("windows")){
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            window.getContentPane().setBackground(new Color(255,255,255));
            window.setVisible(true);
            window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            window.setLayout(new BorderLayout());
            window.add(new login(), BorderLayout.CENTER);
        });
    }
}
