package resource;

import interfaces.ILoadFont;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.FontFormatException;
import java.io.IOException;

public class loadFont implements ILoadFont {

    @Override
    public Font loadFonts(String dir, int width) {
        
        Font font = null;
        InputStream loadFonts;
        
        try {
            loadFonts = new BufferedInputStream(new FileInputStream(dir));
            font = Font.createFont(Font.TRUETYPE_FONT, loadFonts);
            font = font.deriveFont(Font.PLAIN, width);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return font;
    }
}