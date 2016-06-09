package def;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JPanel implements ActionListener{
	
	private Deck myd=new Deck();
	
	private JPanel north=new JPanel();
	private JPanel south=new JPanel();
	private JPanel ctrl=new JPanel();
	private JButton deal=new JButton("Deal");
	
	private JLabel pts=new JLabel();
	private JLabel ns=new JLabel();
	private JLabel nh=new JLabel();
	private JLabel nd=new JLabel();
	private JLabel nc=new JLabel();
	private JLabel ss=new JLabel();
	private JLabel sh=new JLabel();
	private JLabel sd=new JLabel();
	private JLabel sc=new JLabel();
	public View(){
		north.setLayout(new GridLayout(4,1));
		south.setLayout(new GridLayout(4,1));
		setLayout(new BorderLayout());
		north.add(ns);
		north.add(nh);
		north.add(nd);
		north.add(nc);
		south.add(ss);
		south.add(sh);
		south.add(sd);
		south.add(sc);
		
		ctrl.setLayout(new GridLayout(2,1));
		ctrl.add(pts);
		ctrl.add(deal);
		
		deal.addActionListener(this);
		deal.setActionCommand("Deal");
		deal.setFont(new Font("Serif",Font.PLAIN,20));
		
		this.add(north,BorderLayout.NORTH);
		this.add(south,BorderLayout.SOUTH);
		this.add(ctrl,BorderLayout.EAST);
	}
	public void actionPerformed(ActionEvent e){
		this.deal();
	}
	private void deal(){
		String[] r=myd.deal();
		pts.setText("HCP:"+Integer.toString(myd.getHCP()));
		ns.setText("S:"+r[0]);
		nh.setText("H:"+r[1]);
		nd.setText("D:"+r[2]);
		nc.setText("C:"+r[3]);
		ss.setText("S:"+r[4]);
		sh.setText("H:"+r[5]);
		sd.setText("D:"+r[6]);
		sc.setText("C:"+r[7]);
		pts.setFont(new Font("Serif",Font.PLAIN,20));
		ns.setFont(new Font("Serif",Font.PLAIN,20));
		nh.setFont(new Font("Serif",Font.PLAIN,20));
		nd.setFont(new Font("Serif",Font.PLAIN,20));
		nc.setFont(new Font("Serif",Font.PLAIN,20));
		ss.setFont(new Font("Serif",Font.PLAIN,20));
		sh.setFont(new Font("Serif",Font.PLAIN,20));
		sd.setFont(new Font("Serif",Font.PLAIN,20));
		sc.setFont(new Font("Serif",Font.PLAIN,20));
	}
}