package Yahtzee;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class YahtzeeDiceButton extends JButton implements ActionListener{
	private boolean selected;
	private int number;
	private ArrayList<ImageIcon> reg;
	private ArrayList<ImageIcon> shaded;
	YahtzeeDiceButton()
	{
		super();
		reg = new ArrayList<ImageIcon>();
		shaded = new ArrayList<ImageIcon>();
		selected = true;
		Image img = null;
		Image img2 = null;
		for(int i=1; i<7;i++){
			try {
				switch(i){
					case 1: 
						img = ImageIO.read(new File("YahtzeeDice/dice1Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice1.png"));
						break; 
					case 2: 
						img = ImageIO.read(new File("YahtzeeDice/dice2Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice2.png"));
						break; 
					case 3: 
						img = ImageIO.read(new File("YahtzeeDice/dice3Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice3.png"));
						break; 
					case 4: 
						img = ImageIO.read(new File("YahtzeeDice/dice4Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice4.png"));
						break; 
					case 5: 
						img = ImageIO.read(new File("YahtzeeDice/dice5Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice5.png"));
						break; 
					case 6: 
						img = ImageIO.read(new File("YahtzeeDice/dice6Shade.png"));
						img2 = ImageIO.read(new File("YahtzeeDice/dice6.png"));
						break; 
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			Image resizedShade = img.getScaledInstance(95,95,Image.SCALE_SMOOTH);
			Image resizedReg = img2.getScaledInstance(95,95,Image.SCALE_SMOOTH);
			final ImageIcon Shade = new ImageIcon(resizedShade);
			final ImageIcon Reg = new ImageIcon(resizedReg);
			reg.add(Reg);
			shaded.add(Shade);
		}
		Image blankImg = null;
		try {
			blankImg = ImageIO.read(new File("YahtzeeDice/blank.png"));	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ImageIcon blank = new ImageIcon(blankImg);
		setIcon(blank);
		addActionListener(this);
	}
	public boolean isSelected(){
		return selected;
	}
	public int getNum(){
		return number+1;
	}
	public void roll(){
		number = (int)(Math.random()*6);
		setIcon(reg.get(number));
	}
	public void set(int num, boolean select){
		if(select){
			selected = true;
			setIcon(reg.get(number-1));
		}
		else{
			selected = false;
			setIcon(shaded.get(number-1));
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if(selected){
			selected = false;
			setIcon(shaded.get(number));
		}
		else{
			selected = true;
			setIcon(reg.get(number));
		}
	}
}
