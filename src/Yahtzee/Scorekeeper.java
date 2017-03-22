package Yahtzee;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Scorekeeper extends JFrame implements ActionListener{
	public final static int MAX_STRAT = 30;
	public final static int ONE_SECOND = 1000;
	public final static int average = 1, total = 2, recent = 3, max = 4, min = 5;
	public final static String SEP = "    |    ";
	private JLabel lTime, lGames, testingLabel;
	private Strategy stratList[];
	private boolean  menuEnabled, inSort;
	private double scoreStopper = -1;
	
	private boolean toStopScore = false, slowScores = false,
	toStopTime= false, isAscending= false, testing = false,
	testingStopper = false, stop = false, reset = false;
	private JTable table;
	
	JMenuBar bar=new JMenuBar();
	JMenu displayOptions=new JMenu("Display Options");
	JMenu ascending= new JMenu("Ascending");
	
	JMenuItem averageItem = new JMenuItem("Average"),
		totalItem = new JMenuItem("Total"), recentItem= new JMenuItem("Recent"),
	maxItem = new JMenuItem("Max"), minItem = new JMenuItem("Min"),
	ascendingItem = new JMenuItem("Ascending"),
	descendingItem = new JMenuItem("Descending");
	
	private int width =800, height=600, games=0, slowTime=0,
	fontSize=12, /*updateInterval=5,*/ time = 0, gamesPlayed=0,
	timeStopper =-1, display=1, numCols =2;
	long startTime = 0;
	
	Scorekeeper(){
		super("Strategy Checker");
		//setInterval(30);
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		startTime = System.currentTimeMillis();
	}
	public String toString(){
		String answer = "";
		answer += SEP;
		answer += "Stopping Score: " + toStopScore + ", " + scoreStopper;
		answer += SEP;
		answer += "Slow Time: " + slowScores + ", " + slowTime; 
		answer += SEP;
		answer += "Stopping Time: " + toStopTime + ", " + timeStopper;
		answer += SEP;
		answer += "Display type: " + displayTypeToString();
		answer += SEP;
		answer += "Ascending: " + isAscending;
		answer += SEP;
		return answer;
	}
	private String displayTypeToString(){
		if (display== average){
			return "Average";
		}
		else if (display == total){
			return "Total";
		}
		else if (display == recent){
			return "Recent";
		}
		else if (display == max){
			return "Max";
		}
		else{
			return "Min";
		}
	}
	private String dispTime(){
		int time=time();
		String toRet = "";
		int seconds = time % 60;
		int minutes = (time%3600) /60;
		int hours = time /3600;
		if (hours > 0) {
			toRet += hours + " hours, ";
		}
		if (minutes > 0) {
			 toRet += minutes + " minutes, ";
		}
		toRet +=  seconds + " seconds";
		return toRet;
	}
	private void doCreate(){
		for (int x=0; x < stratList.length; x++)
			stratList[x].setAscending(isAscending);
		table.setAutoResizeMode(4);
		getContentPane().removeAll();
		
		if (menuEnabled){
			//Menu
			displayOptions.add(averageItem);
			displayOptions.add(totalItem);
			displayOptions.add(recentItem);
			displayOptions.add(maxItem);
			displayOptions.add(minItem);
			ascendingItem.addActionListener(this);
			descendingItem.addActionListener(this);
			recentItem.addActionListener(this);
			totalItem.addActionListener(this);
			maxItem.addActionListener(this);
			minItem.addActionListener(this);
			averageItem.addActionListener(this);
			ascending.add(ascendingItem);
			ascending.add(descendingItem);
			bar.add(ascending);
			bar.add(displayOptions);
			this.setJMenuBar(bar);
		}
		//Table
		String[] colNames = {"Name", "Author", "Score"};
		table = new JTable(getData(), colNames);
		table.setRowHeight(fontSize + 4);
		table.setFont(new Font("Dialog", Font.PLAIN, fontSize));
		table.setSize(width, height);
		JScrollPane scrollPane = new JScrollPane(table);
		
		//Labels
		JPanel lPanel = new JPanel();		
		lTime = new JLabel("Time: " + dispTime());
		lGames = new JLabel("Games: " + games);
		lTime.setFont(new Font("Dialog", Font.PLAIN, fontSize));
		lGames.setFont(new Font("Dialog", Font.PLAIN, fontSize));
		lPanel.setLayout(new GridLayout(0, 1));
        lPanel.add(lTime);
        lPanel.add(lGames);
        //Adding everything
		this.getContentPane().add(lPanel, BorderLayout.NORTH);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//Testing
        if(testing){
        	initTesting();
        }
        
		//Redisplaying
		validate();
	}
	private void initTesting(){
		JPanel lPanel2 = new JPanel();
		lPanel2.setLayout(new GridLayout(2,1));
		testingLabel = new JLabel(toString());
		lPanel2.add(testingLabel);
		JButton emergStop = new JButton("Next test case, please!");
		emergStop.addActionListener(this);
		lPanel2.add(emergStop);
		this.getContentPane().add(lPanel2, BorderLayout.SOUTH);
	}
	public void setMenu(boolean newValue){
		menuEnabled = newValue;
	}
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == ascendingItem){
			ascending(true);
		}
		else if (source == descendingItem){
			ascending(false);
		}
		else if (source == recentItem){
			display =recent;
		}
		else if (source == totalItem){
			display = total;
		}
		else if (source == minItem){
			display = min;
		}
		else if (source == maxItem){
			display = max;
		}
		else if (source == averageItem){
			display = average;
		}
		else{
			stop = true;
			reset = true; //reset scores
		}
	}
	private Object[][] getData(){
		Object[][] temp = new Object[stratList.length][3];
		//System.out.println("\n\n Strategies list:");
		for (int count = 0; count < stratList.length; count++){
			//System.out.println(stratList[count].playerName() + " " +
			//stratList[count].score());
			temp[count][0] = stratList[count].playerName();
			temp[count][1] = stratList[count].author();
			if (!stratList[count].crashed()){
				if (display != average)
					temp[count][2] = fixDouble(stratList[count].score()) +
					""; // +"" for conversion to String
				else {
					temp[count][2] =
					fixDouble(stratList[count].score() / games);
				}
			}
			else{
				temp[count][2] = "CRASHED";
			}
		}
		return temp;
	}
	/*void setInterval(int interval){
		updateInterval = interval;
	}*/
	void setFont(int font){
		fontSize = font;
	}
	void setStrategies(Strategy[] strategies){
		stratList = strategies;
		table = new JTable(stratList.length, numCols);
		sort();
	}
	void displayOption(int choice){
		display = choice;
	}
	void ascending(boolean ascend){
		isAscending = ascend;
		for (int x=0; x < stratList.length; x++)
			stratList[x].setAscending(isAscending);
	}
	void stoppingScore(double score, boolean stop){
		scoreStopper = score;
		toStopScore = stop;
	}
	void stoppingTime(int seconds, boolean stop){
		timeStopper = seconds;
		toStopTime = stop;
	}
	void slowTime(int seconds, boolean slow){
		slowTime = seconds;
		slowScores = slow;
	}
	void setTesting(boolean testing){
		this.testing = testing;
	}
	public void outputScores(File file){
		int cWidth = 20; // The maxiumum number of characters in a column that will
						 // be printed out to the file while writing
		if (!file.exists()){
			try {
				file.createNewFile();
			} 
			catch (Exception e) {
				System.out.println("Error: File cannot be created");
				return;
			}
		}
		if (!file.canWrite()){
			System.out.println("Error: Cannot write to file.");
			return;
		}
		try{
			FileWriter out = new FileWriter(file);
			String name = "", author = "", line = "";
			for (int x = 0; x < stratList.length; x++){
				name = stratList[x].playerName();
				author = stratList[x].author();
				if (name.length() > cWidth){
					name = name.substring(0, cWidth);
				}
				if (author.length() > cWidth){
					author = author.substring(0, cWidth);
				}
				for (int y = 1; y <= cWidth; y++){  //Fancy formating 
													//Can be done better but works as is
					if (name.length() < y) name += " ";
					if (author.length() < y) author += " ";
				}
				line = name + author;
				if (stratList[x].crashed()){
					 line += "CRASHED" + "\n";
				}
				else{
					line += fixDouble(stratList[x].score()) + "\n";
				}
				out.write(line);
			}
			out.close();
		 }
		 catch (Exception e){
			e.printStackTrace();
		 	System.out.println("Error during the actual writing to the file");
		 }
	}
	private void sort(){ 
		Arrays.sort(stratList);
		if (isAscending){
			Strategy[] copy = new Strategy[stratList.length];
			for (int count = stratList.length-1, count2 =0; count > -1; count--,count2++){
				copy[count2] = stratList[count];
			}
			stratList = copy;
		}
	}
	private double fixDouble (double num){
		long temp = 100000;
		temp *= num;
		num = temp;
		num /= 100000;
		return num;
	}
	public void playGames(GamePlayer player) {
		stop = false;
		 //synchronize game with system clock
		while(System.currentTimeMillis() % 1000 > 100);
		startTime = System.currentTimeMillis();
		long oldTime = -33;
		long newTime = startTime/1000;
		
		if (slowScores && time()< slowTime){
			//wait 1 second so games = time and not games = time+1
			while(System.currentTimeMillis() % 1000 <= 100);
			while(System.currentTimeMillis() % 1000 > 100);
		}
		
		if (toStopTime  && time() >= timeStopper){
			return;
		}
		games = 0;
		doCreate();
		setVisible(true);
		double[] tempResult = new double[stratList.length];
		boolean[] minSet = new boolean[stratList.length];
		for (int index = 0; index < minSet.length; ++index)
			minSet[index] = false;
		while (!stop){
			if (slowScores && time()< slowTime)
				while(System.currentTimeMillis() % 1000 <= 100);
			//System.out.println("\nrunning.." + Math.random());
			boolean validResult = true;
			while (validResult) { 				
				try {
					tempResult = playOneGame(player);
					validResult = false;		
					games++;
				}
				catch (StrategyCrashedException e){
					stratList[e.getCauseIndex()].setCrashed();  
					/*if (isAscending){
						stratList[e.getCauseIndex()].setScore(-1.0);
					}
					else{
						stratList[e.getCauseIndex()].setScore(Integer.MAX_VALUE);
					}*/
					System.out.println(stratList[e.getCauseIndex()].
					playerName() + " crashed!");
				}
			}
			double temp = 0.0;
			double[] scores = new double[stratList.length];
			//System.out.println(".1");
			for (int x=0; x < stratList.length; x++){
				if (!stratList[x].crashed()){ 
					//System.out.println("Games: " + games);
					//System.out.println("In other method: " + stratList[x] + " " + tempResult[x]);
					//System.out.println("Current Score: = " + stratList[x].score());
					//System.gc();
					temp = tempResult[x];
					//for (int counter= 0; counter< stratList.length; counter++){
						scores[x] = stratList[x].score();
						//System.out.println("BEFORE " + stratList[counter].score());
					//}
					if (display == average){
						//scores[x] *= games - 1;
						scores[x] += temp;
						//scores[x] /= games;
					}
					else if (display == total){
						scores[x] += temp;
					}
					else if (display == recent){
						scores[x] = temp;
					}
					else if (display == max){
						if (temp > scores[x]) {
							scores[x] = temp;
						}
					}
					else if (display == min){
						if (!minSet[x]) {
							minSet[x] = true;
							scores[x] = temp;
						}
						else if (temp < scores[x]) {
							scores[x] = temp;
						}
					}
					//System.out.println("New Score: = " + scores[x]);
					//for (int counter= 0; counter< stratList.length; counter++){
					stratList[x].setScore(scores[x]);
						///System.out.println(
						//"AFTER " + stratList[counter].score());
					//}
				}
				
				//lTime.setText("Time: " + dispTime());
				//lGames.setText("Games: " + games);
				if (toStopTime  && time() >= timeStopper) {
					stop = true;
				}
				if (toStopScore){
					if (scores[x] >= scoreStopper && isAscending)
						stop = true;
					else if (scores[x] <= scoreStopper && !isAscending)
						stop = true;
				}
			}
			sort();
			
			if (slowScores && time()< slowTime){
				//System.out.println("waiting..");
				doCreate();
				while(System.currentTimeMillis() % 1000 > 100);
			} else if (oldTime < newTime) {
				doCreate();
				oldTime = newTime;
			}
			newTime = System.currentTimeMillis()/1000;
		}
		//System.out.println("stopped.");
		doCreate();
		if (reset) {
			for (int x=0; x < stratList.length; x++)
				stratList[x].setScore(0);
			reset=false;	
		}
	}
	private int lastUncrashed(){ //Determines the highest index uncrashed strategy
		for (int count= stratList.length-1; count>=0; count--){
			if (!stratList[count].crashed()){
				return count;
			}
		}
		return 0;
	}
	private double[] playOneGame (GamePlayer player) throws StrategyCrashedException{
		try{
			return player.playAllStrategies(stratList);
		}
		catch (StrategyCrashedException e){
			throw e;
		}
		
	}
	public static int[] newOrder(int size) {
		ArrayList<Integer> indexList = new ArrayList();
		for (int index = 0; index < size; ++index)
			indexList.add(index);
		
		int[] newOrder = new int[size];
		
		for (int index = 0; index < size; ++index)
			newOrder[index] = indexList.remove((int)
			(Math.random() * indexList.size()));
		
		return newOrder;
	}
	
	public int time() {
		return (int)(System.currentTimeMillis()-startTime) / 1000;
	}
}
