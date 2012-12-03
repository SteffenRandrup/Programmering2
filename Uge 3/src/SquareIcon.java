import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;


public class SquareIcon implements Icon {
	
	private int iconSize;
	private Color iconColor;
	
	public SquareIcon(int size, Color color) {
		iconSize = size;
		iconColor = color;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double square = new Rectangle2D.Double(x,y,iconSize,iconSize);
		
		g2.setColor(iconColor);
		g2.fill(square);
		
	}

	public int getIconWidth() {
		return iconSize;
	}

	public int getIconHeight() {
		return iconSize;
	}
		

}
