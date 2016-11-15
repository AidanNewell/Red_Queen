package ShhNoThingsInHereGoAway;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BuggyCalculator {

	private static double entered;


	//This makes it easier to add numbers to the end of the double
	private static String enteringString;

	private static final int PLUS = 0, MINUS = 1, MULTIPLY = 2, DIVIDE = 3;

	private static boolean singleDec, doubleDec, badEntered;

	private static boolean operationLogged;

	private static boolean result;

	private static int Operation;

	private static JLabel display;

	public static void main(String [] args)
	{
		operationLogged = false;
		entered =0;
		result = true;
		doubleDec = false;
		badEntered = false;
		enteringString="0";
		JFrame window = new JFrame("Calculator");

		JPanel pane = new JPanel(new GridBagLayout());	
		GridBagConstraints c = new GridBagConstraints();

		display = new JLabel();
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setBackground(Color.WHITE);
		display.setOpaque(true);
		display.setText("");
		display.setMinimumSize(new Dimension(215, 18));
		display.setPreferredSize(new Dimension(215, 18));
		display.setMaximumSize(new Dimension(215, 18));
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
				entered =0;
				enteringString="0";
				Operation=4;
				operationLogged=false;
				singleDec=false;
				doubleDec = false;
				badEntered = false;
				result=true;
				display.setText(enteringString);
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
				//cacheEntering();
				if(badEntered)
					doubleDec = true;
				else 
					doubleDec = false;
				singleDec=false;
				enteringString="";
				display.setText(" ");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(clearE, c);

		JButton divide = new JButton("÷");
		divide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				result = false;
				if(operationLogged)
					calcResult();
				Operation = DIVIDE;
				operationLogged=true;
				cacheEntering();
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
				result = false;
				if(operationLogged)
					calcResult();
				Operation = MULTIPLY;
				operationLogged=true;
				cacheEntering();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		pane.add(multiply, c);

		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				BuggyCalculator.addNumber("7");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1; 
		c.gridx = 0;
		c.gridy = 2;
		pane.add(seven, c);

		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				BuggyCalculator.addNumber("8");
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
				BuggyCalculator.addNumber("9");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		pane.add(nine, c);

		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				result = false;
				if(operationLogged)
					calcResult();
				Operation = MINUS;
				operationLogged=true;
				cacheEntering();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		pane.add(minus, c);

		JButton four = new JButton("4");
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				BuggyCalculator.addNumber("4");
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
				BuggyCalculator.addNumber("5");
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
				BuggyCalculator.addNumber("6");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		pane.add(six, c);

		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				result = false;
				if(operationLogged)
					calcResult();
				Operation = PLUS;
				operationLogged=true;
				cacheEntering();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		pane.add(plus, c);

		JButton one = new JButton("1");
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				BuggyCalculator.addNumber("1");
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
				BuggyCalculator.addNumber("2");
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
				BuggyCalculator.addNumber("3");
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		pane.add(three, c);

		JButton equals = new JButton("=");
		equals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				singleDec=false;
				operationLogged=false;
				if(!doubleDec)
					calcResult();
				else
					System.exit(Integer.MIN_VALUE);
				doubleDec = false;
				badEntered = false;
			}
		});
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight = 2; 
		c.gridx = 3;
		c.gridy = 4;
		pane.add(equals, c);

		JButton plusMinus = new JButton ("+/-");
		plusMinus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//It turns out that you have to do this. You can't just do String != null
				if(!enteringString.equals(""))
				{
					System.out.println(enteringString);
					if(enteringString.substring(0,1).equals("-"))
						enteringString = enteringString.substring(1);
					else
						enteringString = "-"+enteringString;
					display.setText(enteringString);
				}
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
				BuggyCalculator.addNumber("0");
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
				BuggyCalculator.addNumber(".");
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

		display.setText(enteringString);
	}

	public static void cacheEntering()
	{
		try{
			if(enteringString.substring(0,1).equals("0") || (enteringString.substring(0,1).equals("-") && enteringString.substring(1,2).equals("0")))
			{
				enteringString="0";
			}
		}catch(Exception e){}
		singleDec=false;
		try{
			entered=Double.parseDouble(enteringString);
		}catch(Exception e){
			badEntered = true;
		}
		enteringString="";
	}

	public static void add()
	{
		enteringString = ""+(entered + Double.parseDouble(enteringString));
	}

	public static void subtract()
	{
		enteringString = ""+(entered  - Double.parseDouble(enteringString));
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
		if(entered < 0 && Double.parseDouble(enteringString) <0)
		{
			enteringString = ""+(-1 * entered * Double.parseDouble(enteringString));
		}
		else
			enteringString = ""+(entered * Double.parseDouble(enteringString));
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
		enteringString = ""+(Double.parseDouble(enteringString) / Double.parseDouble(enteringString));
	}

	public static void addNumber(String x)
	{
		if(enteringString.length()<32){
			if(result)
			{
				enteringString = "";
				result = false;
			}
			if(enteringString.equals("NaN"))
				enteringString = "";
			if(x.equals("."))
			{
				if(singleDec)
				{
					doubleDec = true;
				}
				else
					singleDec=true;
			}
			enteringString = enteringString + x;
			display.setText(enteringString);
		}
	}

	public static void calcResult()
	{
		if(!enteringString.equals(""))
		{
			if(enteringString.substring(0,1).equals("0") || (enteringString.substring(0,1).equals("-") && enteringString.substring(1,2).equals("0")))
			{
				enteringString="0";
			}
			switch(Operation)
			{
			case PLUS:
				add();
				Operation = 4;
				result=true;
				break;
			case MINUS:
				subtract();
				Operation = 4;
				result=true;
				break;
			case MULTIPLY:
				multiply();
				Operation = 4;
				result=true;
				break;
			case DIVIDE:
				divide();
				Operation = 4;
				result=true;
				break;
			}
			display.setText(enteringString);	
		}
	}
}

