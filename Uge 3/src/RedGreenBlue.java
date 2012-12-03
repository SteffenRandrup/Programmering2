import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RedGreenBlue {

	private static CompositeIcon ikoner;
	private static JFrame frame;
	
	public static void main(String[] args){
		
		JButton red = new JButton("Rød");
		JButton green = new JButton("Gørn");
		JButton blue = new JButton("Blå");
		
		red.addActionListener(createColor(Color.RED));
		green.addActionListener(createColor(Color.GREEN));
		blue.addActionListener(createColor(Color.BLUE));
		
		JPanel knapper = new JPanel();
		knapper.add(red);
		knapper.add(green);
		knapper.add(blue);
		
		ikoner = new CompositeIcon();
		JLabel farver = new JLabel();
		farver.setIcon(ikoner);
		
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.add(knapper, BorderLayout.NORTH);
		frame.add(farver, BorderLayout.SOUTH);	
		frame.pack();
		frame.setVisible(true);
		
	}

	private static ActionListener createColor(final Color farve) {
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Icon test = new SquareIcon(20,farve);
				ikoner.addIcon(test);
				frame.pack();
				frame.repaint();
			}
		};
	}
}















