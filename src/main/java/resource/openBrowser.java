package resource;

import interfaces.IOpenBrowser;
import java.io.IOException;

public class openBrowser implements IOpenBrowser{

    @Override
    public void openURL(String url) {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            }
        } catch (IOException ev) {
            ev.printStackTrace(System.out);
            System.exit(1);
        }
    }
}
