import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BinomialGUI {

	private JFrame frame;
	private JTextField svar;
	private JTextField nField;
	private JTextField kField;
	private JButton udregn;
	private Binomial bin;
	private JPanel top;
	private JPanel bund;
	private JLabel nLabel;
	private JLabel kLabel;
	
	public BinomialGUI(Binomial bino){
		
		bin = bino;
		udregn = new JButton("Regn ud");
		svar = new JTextField(7);
		svar.setEditable(false);
		nField = new JTextField(5);
		kField = new JTextField(5);		
		
		udregn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int n = Integer.parseInt(nField.getText());
				int k = Integer.parseInt(kField.getText());
				svar.setText(""+bin.binomial(n, k));
				frame.pack();
				frame.repaint();
			}
		});
		
		top = new JPanel();
		nLabel = new JLabel("n: ");
		top.add(nLabel);
		top.add(nField);
		kLabel = new JLabel("k: ");
		top.add(kLabel);
		top.add(kField);
		
		bund = new JPanel();
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