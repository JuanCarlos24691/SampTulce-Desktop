package resource;

import index.run;
import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class showDialog extends JDialog implements interfaces.IShowDialog {

    private JOptionPane JOP;

    @Override
    public void message(String message, URL image, String[] buttons) {
        UIManager.put("Panel.background", new ColorUIResource(228, 230, 235));
        JDialog dialog = new JDialog(run.window, true);


        this.JOP = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, new ImageIcon(image), buttons, buttons[0]);

        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            
            String buttonClick = e.getPropertyName();
            
            if ("value".equals(buttonClick))
                dialog.dispose();
        });
        
        dialog.setUndecorated(true);
        dialog.setLayout(new BorderLayout());
        dialog.add(JOP);
        dialog.pack();
        dialog.setLocationRelativeTo(run.window);
        dialog.setShape(new RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30));
        JOP.setBackground(new ColorUIResource(228, 230, 235));
        dialog.setVisible(true);
    }

    public JOptionPane getJOP() {
        return this.JOP;
    }
}
