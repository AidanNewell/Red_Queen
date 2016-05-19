package SahilAndAllisonsExcellentAdventure;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;

import cards.*;
import data.ImagePath;
public class AllisonsScrubTester {
	public static void lol(){
		JFrame yo = new JFrame();
		AdventureGame g = new AdventureGame();
		AdventurePlayer p = new AdventurePlayer("why");
		AdventureOrganismPanel testPanel = new AdventureOrganismPanel(g, "User");
		MitochondriaCard mito = new MitochondriaCard();
		testPanel.addCard(new CytosolCard());
		testPanel.addCard(mito);
		testPanel.addCard(new PrimaryMembraneCard());
		testPanel.removeCard(mito);
		
		yo.setContentPane(testPanel);
		yo.pack();
		yo.setVisible(true);
	}
	public static void haha(){
		JFrame yo = new JFrame();
		JPanel hello = new JPanel();
		JButton plz = new JButton();
		CytosolCard crd = new CytosolCard();
		Image i = crd.getCardArt();
		//ImageIcon icon = new ImageIcon("assets/Cytoplasm.png");
		//Icon icon = (Icon) crd.getCardArt();
		//plz.setIcon((Icon)crd.getCardArt());
		plz.setIcon(new ImageIcon(i));
		hello.add(plz);
		yo.setContentPane(hello);
		yo.pack();
		yo.setVisible(true);
	}
	public static void lmao(){
		JFrame yo = new JFrame();
		AdventureGame g = new AdventureGame();
		JPanel contentPane = new JPanel();
		AdventurePlayer player = new AdventurePlayer("player");
		AdventureOrganismPanel me = new AdventureOrganismPanel(g, "User");
		AdventureMiddlePanel testPanel = new AdventureMiddlePanel(g);
		yo.setContentPane(contentPane);
		yo.setLayout(new BoxLayout(contentPane,BoxLayout.LINE_AXIS));
		yo.add(testPanel);
		yo.add(me);
		yo.pack();
		yo.setVisible(true);
	}
	public static void strings(){
		HelperTCellCard help = new HelperTCellCard();
		AdventureActionPanel pls = new AdventureActionPanel(null, null);
		System.out.println(pls.makeThisCardAString(help));
		PrimaryMembraneCard lol = new PrimaryMembraneCard();
		CytosolCard what = new CytosolCard();
		System.out.println(what.getCost());
		
	}
	public static void main(String args[]){
		ImagePath.init();
		CardLoader.init();
		strings();
	}
}
