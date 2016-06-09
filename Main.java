package def;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame f=new JFrame();
		View main=new View();
		f.setTitle("Bidding Dealer");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		
		f.setContentPane(main);

		f.pack();
		f.setSize(new Dimension(400,400));
		f.setVisible(true);
	}
}
