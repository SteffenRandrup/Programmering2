import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Icon;

public class CompositeIcon implements Icon {

	private ArrayList<Icon> liste;
	
	public CompositeIcon() {
		liste = new ArrayList<Icon>();
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int h = x;
		for(Icon ic : liste){
			ic.paintIcon(c,g,h,y);
			h = h+ic.getIconWidth();
		}
	}

	public int getIconWidth() {
		int svar = 0;
		for(Icon ic : liste){
			svar = svar+ic.getIconWidth();
		}	
		return svar;
	}

	public int getIconHeight() {
		int max = 0;
		for(Icon ic: liste){
			if(ic.getIconHeight()>max){
				max = ic.getIconHeight();
			}
		}
		return max;
	}

	public void addIcon(Icon ic) {
		liste.add(ic);
	}

}
