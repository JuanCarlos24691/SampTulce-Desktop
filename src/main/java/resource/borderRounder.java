package resource;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.border.AbstractBorder;

public class borderRounder extends AbstractBorder {

    private final Color color;
    private final BasicStroke stroke;
    private final RenderingHints hints;
    private final int width, height;

    public borderRounder(Color color, int value, int width, int height) {
        this.color = color;
        this.stroke = new BasicStroke(value);
        this.width = width;
        this.height = height;
        this.hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle2D = new Ellipse2D.Double();

        if (this.stroke.getLineWidth() == 0) {
            circle2D.setFrameFromCenter(new Point(x + this.width / 2, y + this.height / 2), new Point(this.width, this.height));
        } else {
            circle2D.setFrameFromCenter(new Point(x + this.width / 2, y + this.height / 2), new Point(this.width - (int) stroke.getLineWidth(), this.height - (int) stroke.getLineWidth()));
        }

        Polygon pointer = new Polygon();
        Area area = new Area(circle2D);
        area.add(new Area(pointer));
        g2.setRenderingHints(this.hints);

        Component parent = c.getParent();
        
        if (parent != null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0, 0, this.width, this.height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, this.width, this.height);
            g2.setClip(null);
        }

        if (this.stroke.getLineWidth() > 0) {
            g2.setColor(this.color);
            g2.setStroke(this.stroke);
        }

        g2.draw(area);
    }
}
