package client;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.ImagePath;

public class resourcePane extends JPanel{


	JLabel ATP = null;
	JLabel Tox = null;
	JLabel Res = null;
	
	public resourcePane()
	{
		setLayout(null);
		setOpaque(false);
		try{
			Image labelImg = ImagePath.ATP_VIAL;
			ATP = new JLabel("0",new ImageIcon(labelImg),JLabel.CENTER);
			labelImg = ImagePath.TOXIN_VIAL;
			Tox = new JLabel("0",new ImageIcon(labelImg),JLabel.CENTER);
			labelImg = ImagePath.SMALL_SHIELD;
			Res = new JLabel("0",new ImageIcon(labelImg),JLabel.CENTER);
			add(ATP);
			ATP.setBounds(0, 0, 60, 60);
			add(Tox);
			Tox.setBounds(0,60,60,60);
			add(Res);
			Res.setBounds(0, 120, 60, 60);
		}catch(Exception e){}
	}
	
	public void updateATP(int x)
	{
		ATP.setText(""+x);
	}
	
	public void updateTox(int x)
	{
		Tox.setText(""+x);
	}
	
	public void updateRes(int x)
	{
		Res.setText(""+x);
	}
}
