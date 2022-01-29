package interfaces;

import java.awt.event.ActionEvent;
import java.net.URL;

public interface IShowDialog {
    void message(String message, URL image, String[] buttons);
    void eventButtons(ActionEvent e);
}
