package def;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Integer> order=new ArrayList<Integer>(52);
	
	private ArrayList<Integer> n1=new ArrayList<Integer>(13);
	private ArrayList<Integer> n2=new ArrayList<Integer>(13);
	private ArrayList<Integer> n3=new ArrayList<Integer>(13);
	private ArrayList<Integer> n4=new ArrayList<Integer>(13);
	private ArrayList<Integer> s1=new ArrayList<Integer>(13);
	private ArrayList<Integer> s2=new ArrayList<Integer>(13);
	private ArrayList<Integer> s3=new ArrayList<Integer>(13);
	private ArrayList<Integer> s4=new ArrayList<Integer>(13);
	
	private int hcp;
	
	public Deck(){
		for(int i=0;i<52;i++){
			order.add(i);
		}
	}
	
	public int getHCP(){
		return hcp;
	}
	
	public String[] deal(){
		long seed = System.nanoTime();
		Collections.shuffle(order, new Random(seed));
		while(check_value(order)<28){
			seed = System.nanoTime();
			Collections.shuffle(order, new Random(seed));
		}
		hcp=check_value(order);
		n1=new ArrayList<Integer>(13);
		n2=new ArrayList<Integer>(13);
		n3=new ArrayList<Integer>(13);
		n4=new ArrayList<Integer>(13);
		s1=new ArrayList<Integer>(13);
		s2=new ArrayList<Integer>(13);
		s3=new ArrayList<Integer>(13);
		s4=new ArrayList<Integer>(13);
		
		for(int i=0;i<13;i++){
			switch (order.get(i)/13){
				case 0:n1.add(order.get(i));break;
				case 1:n2.add(order.get(i));break;
				case 2:n3.add(order.get(i));break;
				case 3:n4.add(order.get(i));break;
			}
			switch (order.get(i+13)/13){
				case 0:s1.add(order.get(i+13));break;
				case 1:s2.add(order.get(i+13));break;
				case 2:s3.add(order.get(i+13));break;
				case 3:s4.add(order.get(i+13));break;
			}
		}
		String[] results=new String[8];
		results[0]=stringify(n1);
		results[1]=stringify(n2);
		results[2]=stringify(n3);
		results[3]=stringify(n4);
		results[4]=stringify(s1);
		results[5]=stringify(s2);
		results[6]=stringify(s3);
		results[7]=stringify(s4);
		return results;		
	}


	private static int check_value(ArrayList<Integer> d){
		int pts=0;
		int a;
		for(int i=0;i<26;i++){
			a=d.get(i);
			pts+=points(a);
		}
		return pts;
	}
	
	private static String stringify(ArrayList<Integer> a){
		Collections.sort(a);
		String r="";
		for(int i:a){
			r=r.concat(face(i));
		}
		return r;
	}

	private static String face(int a){
		String s;
		switch(a%13){
			case 0:s="A";break;
			case 1:s="K";break;
			case 2:s="Q";break;
			case 3:s="J";break;
			default:
				s=Integer.toString(14-a%13);break;
		}
		return s;
	}
	
	private static int points(int value){
		int a=value%13;
		if(a<4)return 4-a;
		else return 0;
	}
}
