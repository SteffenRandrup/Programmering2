import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Crayon {
    private static Board b = new Board();
    private Color col;
    private double width;
    private double dir = 0;
    private double pos_x = 0;
    private double pos_y = 0;

    private static class Board extends JComponent {
	private ArrayList<LineSegment> lines = new ArrayList<LineSegment>();

	private static class LineSegment {
	    Color col;
	    Polygon pol;

	    LineSegment(Color c, Polygon p) { col = c; pol = p; }
	}

	public Board() {
	    this.setPreferredSize(new Dimension(600, 600));
	    JFrame frame = new JFrame();
	    frame.add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}

	public void addLine(Color c, double w, double cos, double sin,
			    double x1, double y1, double x2, double y2) {
	    Polygon p = new Polygon();
	    p.addPoint((int) (x1-w/2*sin),(int) (y1+w/2*cos));
	    p.addPoint((int) (x1+w/2*sin),(int) (y1-w/2*cos));
	    p.addPoint((int) (x2+w/2*sin),(int) (y2-w/2*cos));
	    p.addPoint((int) (x2-w/2*sin),(int) (y2+w/2*cos));
	    lines.add(new LineSegment(c,p));
	    repaint();
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.clearRect(0,0,400,500);
            for (LineSegment ls : lines) {
		g.setColor(ls.col);
		g.fillPolygon(ls.pol); 
	    }
	}
    }
  
    public Crayon(Color c, double w) {
	col = c;   width = w;
    }

    public Crayon() {
	this(Color.black,1);
    }


    public void move(double d) {
	double cos = Math.cos(dir*Math.PI/180);
	double sin = Math.sin(dir*Math.PI/180);
	double new_x = pos_x + d*cos;
	double new_y = pos_y + d*sin;
	b.addLine(col,width,cos,sin,pos_x,pos_y,new_x,new_y);
	pos_x = new_x;   pos_y = new_y;
    }

    public void moveto(double x, double y) {
	double cos = (x-pos_x) / Math.sqrt ((x-pos_x)*(x-pos_x)+(y-pos_y)*(y-pos_y));
	double sin = (y-pos_y) / Math.sqrt ((x-pos_x)*(x-pos_x)+(y-pos_y)*(y-pos_y));
	b.addLine(col,width,cos,sin,pos_x,pos_y,x,y);
	pos_x = x;   pos_y = y;
    }

    public void jump(double d) {
	pos_x = pos_x + d*Math.cos(dir*Math.PI/180);
	pos_y = pos_y + d*Math.sin(dir*Math.PI/180);
    }

    public void jumpto(double x, double y) {
	pos_x = x;   pos_y = y;
    }

    public void turn(double a) {
	dir = (dir + a) % 360;
    }

    public void turnto(double a) {
	dir = a % 360;
    }

}