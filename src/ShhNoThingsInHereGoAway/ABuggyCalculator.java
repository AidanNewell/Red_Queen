package ShhNoThingsInHereGoAway;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ABuggyCalculator {

	private static double entered;
	private static double entering;
	
	
	//This makes it easier to add numbers to the end of the double
	private static String enteringString;
	
	private static final int PLUS = 0, MINUS = 1, MULTIPLY = 2, DIVIDE = 3;
	
	private static boolean singleDec;
	private static boolean cont; 
	
	private static int Operation;
	
	private static JLabel display;
		
	public static void main(String [] args)
	{
		entered = 0;
		enteringString = "";
		JFrame window = new JFrame("Calculator");
		
		JPanel pane = new JPanel(new GridBagLayout());	
		GridBagConstraints c = new GridBagConstraints();
		
		display = new JLabel();
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setBackground(Color.WHITE);
		display.setOpaque(true);
		display.setText("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,10,7,7);
		pane.add(display, c);
		
		JButton clear = new JButton("C");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				entered = 0;
				entering = 0; 
				enteringString = "";
				cont = false; 
				display.setText(" ");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1; 
		c.gridx = 0;
		c.gridy = 1;
		pane.add(clear, c);
		
		JButton clearE = new JButton("CE");
		clearE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				entering = 0; 
				enteringString = "";
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(clearE, c);
		
		/*
		* OPERATIONS: 
		*/
		
		JButton divide = new JButton("÷");
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!cont){
					entered = Double.parseDouble(enteringString);
				}
				enteringString = "";
				Operation = DIVIDE; 
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		pane.add(divide, c);
		
		JButton multiply = new JButton("x");
		multiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!cont){
					entered = Double.parseDouble(enteringString);
				}
				enteringString = "";
				Operation = MULTIPLY;
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		pane.add(multiply, c);
		
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!cont){
					entered = Double.parseDouble(enteringString);
				}
				enteringString = "";
				Operation = MINUS; 
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		pane.add(minus, c);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!cont){
					entered = Double.parseDouble(enteringString);
				}
				enteringString = "";
				Operation = PLUS;
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		pane.add(plus, c);
		
		JButton equals = new JButton("=");
		equals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				entering = Double.parseDouble(enteringString);
				switch (Operation){
					case PLUS: add();  
						break;	
					case MINUS: subtract();
						break; 
					case MULTIPLY: multiply();
						break;
					case DIVIDE: divide();
						break;
				}			
				display.setText("" + entered);
				cont = true; 
				
			}
		});
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight = 2; 
		c.gridx = 3;
		c.gridy = 4;
		pane.add(equals, c);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("7");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1; 
		c.gridwidth = 1; 
		c.gridx = 0;
		c.gridy = 2;
		pane.add(seven, c);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("8");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(eight, c);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("9");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		pane.add(nine, c);
		

		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("4");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1; 
		c.gridx = 0;
		c.gridy = 3;
		pane.add(four, c);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("5");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(five, c);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("6");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		pane.add(six, c);
		

		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("1");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(one, c);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("2");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		pane.add(two, c);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("3");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		pane.add(three, c);
		
		JButton plusMinus = new JButton ("+/-");
		plusMinus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		c.gridheight = 1; 
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(plusMinus, c);
		
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber("0");
			}
		});
		c.gridheight = 1; 
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		pane.add(zero, c);
		
		JButton decimal = new JButton(".");
		decimal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ABuggyCalculator.addNumber(".");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1; 
		c.gridx = 2;
		c.gridy = 5;
		pane.add(decimal, c);
		
		window.setContentPane(pane);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		display.setText(" ");
	}
	
	public static void add()
	{
		entered +=entering;
	}
	
	public static void subtract()
	{
		entered-=entering;
	}
	
	public static void multiply()
	{
		/**
		 * THIS IS BUG #4
		 * IT CAUSES NEGATIVE NUMBERS MULTIPLIED TOGETHER
		 * TO REMAIN NEGATIVE
		 * 
		 * IT IS COMPLETELY INTENTIONAL
		 * 
		 * **/
		if(entered < 0 && entering <0)
		{
			entered = -1 * entered * entering;
		}
		else
			entered = entered * entering;
	}
	
	public static void divide()
	{
		/**
		 * THIS IS BUG #1
		 * IT CAUSES DIVISION TO DIVIDE ENTERING BY ENTERING,
		 * ALWAYS GIVING VALUES OF 1 UNLESS DIVIDE BY ZERO
		 * 
		 * IT IS COMPLETELY INTENTIONAL
		 * 
		 * **/
		entered = entering / entering;
	}
	
	public static void addNumber(String x)
	{
		if(x.equals("."))
		{
			if(singleDec)
				System.exit(1);
			else
				singleDec=true;
		}
		enteringString = enteringString + x;
		display.setText(enteringString);
	}
}

