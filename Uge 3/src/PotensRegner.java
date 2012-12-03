import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PotensRegner {
	
	public static void main(String[] args){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, 0));
		JPanel midten = new JPanel();
		midten.setLayout(new BoxLayout(midten,0));
		
		JTextArea ns = new JTextArea(1,5);
		JTextArea xs = new JTextArea(1,5);	
		JTextArea svar = new JTextArea(1,5);
		JButton knap = new JButton("Regn ud");
		
		top.add(new JLabel("n: "));
		top.add(ns);
		midten.add(new JLabel("x: "));
		midten.add(xs);
		panel.add(top, BorderLayout.NORTH);
		panel.add(midten, BorderLayout.CENTER);
		panel.add(knap,BorderLayout.SOUTH);	
		//panel.add(svar,BorderLayout.SOUTH);	
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static double pot(double x, int n) {
		double svar;
		if (n % 2 == 0) {
			svar = Math.pow(pot(x,n/2), 2);
		} else {
			if (n == 1) {
				return x;
			}
			svar = x * pot(x, n - 1);
		}
		return svar;
	}
	
}
