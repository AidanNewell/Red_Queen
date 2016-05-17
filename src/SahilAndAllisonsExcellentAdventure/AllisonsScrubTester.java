package SahilAndAllisonsExcellentAdventure;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;

import cards.*;
public class AllisonsScrubTester {
	public static void lol(){
		JFrame yo = new JFrame();
		AdventureGame g = new AdventureGame();
		AdventureOrganismPanel testPanel = new AdventureOrganismPanel(g);
		testPanel.addCard(new CytosolCard());
		testPanel.addCard(new MitochondriaCard());
		yo.setContentPane(testPanel);
		yo.pack();
		yo.setVisible(true);
	}
	public static void haha(){
		JFrame yo = new JFrame();
		JPanel hello = new JPanel();
		JButton plz = new JButton();
		CytosolCard crd = new CytosolCard();
		System.out.println(crd);
		Image i = crd.getCardArt();
		System.out.println(i);
		//ImageIcon icon = new ImageIcon("assets/Cytoplasm.png");
		//Icon icon = (Icon) crd.getCardArt();
		//plz.setIcon((Icon)crd.getCardArt());
		plz.setIcon(new ImageIcon(i));
		hello.add(plz);
		yo.setContentPane(hello);
		yo.pack();
		yo.setVisible(true);
	}
	public static void main(String args[]){
		haha();
	}
}
