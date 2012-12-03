import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BinomialGUI {

	private static JFrame frame;
	private static JTextField svar;
	private static JTextField nField;
	private static JTextField kField;
	private static Binomial bin;
	
	public static void main(String[] args){
		
		JButton udregn = new JButton("Regn ud");
		svar = new JTextField(7);
		svar.setEditable(false);
		nField = new JTextField(5);
		kField = new JTextField(5);		
		bin = new Binomial1();
		
		udregn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int n = Integer.parseInt(nField.getText());
				int k = Integer.parseInt(kField.getText());
				svar.setText(""+bin.binomial(n, k));
				frame.pack();
				frame.repaint();
			}
		});
		
		JPanel top = new JPanel();
		JLabel nLabel = new JLabel("n: ");
		top.add(nLabel);
		top.add(nField);
		JLabel kLabel = new JLabel("k: ");
		top.add(kLabel);
		top.add(kField);
		
		JPanel bund = new JPanel();
		bund.add(udregn);
		bund.add(svar);
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.add(top, BorderLayout.NORTH);
		frame.add(bund, BorderLayout.SOUTH);	
		frame.pack();
		frame.setVisible(true);
		
	}
}