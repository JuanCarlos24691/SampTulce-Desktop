package resource;

import index.run;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class showDialog extends JDialog implements interfaces.IShowDialog {

    @Override
    public void message(String message, URL image, String[] buttons) {

        JPanel backgroumd = new JPanel();
        backgroumd.setBounds(run.window.getBounds());
        backgroumd.setBackground(new Color(0, 0, 0, 50));
        backgroumd.setAlignmentY(2);

        run.window.add(backgroumd, BorderLayout.CENTER, 0);

        backgroumd.setVisible(true);
        backgroumd.updateUI();

        JDialog dialog = new JDialog(run.window, true);
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));

        JOptionPane JOP = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, new ImageIcon(image), buttons, buttons[0]);

        JOP.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println(evt.getSource().toString());
            }
        });

        JOP.addPropertyChangeListener(e -> {

            System.out.println(e.getSource().toString());
            if (e.getSource().toString().contains("Aceptar")) {
                run.window.setEnabled(true);
                backgroumd.setVisible(false);
                this.removeAll();

                dialog.dispose();
            }

        });

        /*JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {

            if (e.getSource().toString().contains("Aceptar")) {
                System.out.println("exito!");
            }

            if ("value".equals(e.getPropertyName())) {

                run.window.setEnabled(true);
                backgroumd.setVisible(false);
                this.removeAll();

                dialog.dispose();
            }
        });*/

        dialog.setUndecorated(true);
        JOP.setBackground(new ColorUIResource(255, 255, 255));
        dialog.add(JOP);
        dialog.pack();
        dialog.setLocationRelativeTo(run.window); // Center
        dialog.setShape(new RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30)); // Border

        dialog.setVisible(true);
    }

    @Override
    public void eventButtons(ActionEvent e) {

        System.out.println(e.getSource().toString());
        if (e.getSource().toString().contains("Aceptar")) {
            System.out.println("exito!");
        }
    }
}
