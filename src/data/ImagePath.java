package data;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;

public class ImagePath
{
	
	public static final String path = "assets/";
	
	public static Image HUD_BANNER;
	public static Image RIGHT_ARROW;
	public static Image LEFT_ARROW;
	public static Image UP_ARROW;
	public static Image DOWN_ARROW;
		
	public static Image CYTO_BACK, PETRI_BACK, ORG_BACK;
	public static Image CYTOSOL_CARD, ECTOPLASM_CARD, CYTOSKELETON_CARD, LARGE_S_ORG_CARD, MED_S_ORG_CARD, SMALL_S_ORG_CARD;
	public static Image CHLOROPLAST_CARD, HELPERT_CARD, KILLERT_CARD, LYMPH_CARD,MITO_CARD,PRIMARYMEM_CARD,VAC_CARD;
	public static Image NULL_BUILD_SLOT;
	
	public static Image DESTROY_VIRUS_ALL, TILE_DESTROYER, DRAW_3, DISCARD_ALL;
	
    public static void init()
    {
    	try{
    		HUD_BANNER = ImageIO.read(new File(path + "HUD_Banner.png"));
    		LEFT_ARROW = ImageIO.read(new File(path + "Left_Arrow.png"));
    		RIGHT_ARROW = ImageIO.read(new File(path + "Right_Arrow.png"));
    		CYTO_BACK = ImageIO.read(new File(path + "CytoplasmBack.png"));
    		PETRI_BACK = ImageIO.read(new File(path + "PetriDishBack.png"));
    		ORG_BACK = ImageIO.read(new File(path + "OrganismBack.png"));
    		LARGE_S_ORG_CARD = ImageIO.read(new File(path + "OrganismFront5.png"));
    		MED_S_ORG_CARD = ImageIO.read(new File(path + "OrganismFront4.png"));
    		SMALL_S_ORG_CARD = ImageIO.read(new File(path + "OrganismFront3.png"));
    		CYTOSOL_CARD = ImageIO.read(new File(path + "Cytoplasm.png"));
    		ECTOPLASM_CARD = ImageIO.read(new File(path + "Ectoplasm.png"));
    		CYTOSKELETON_CARD = ImageIO.read(new File(path + "Cytoskeleton.png"));
    		CHLOROPLAST_CARD = ImageIO.read(new File(path + "Chloroplast.png"));
    		HELPERT_CARD = ImageIO.read(new File(path + "help.png"));
    		KILLERT_CARD = ImageIO.read(new File(path + "angryFire.png"));
    		LYMPH_CARD = ImageIO.read(new File(path + "stupp.png"));
    		MITO_CARD = ImageIO.read(new File(path + "Powerhouse.png"));
    		PRIMARYMEM_CARD = ImageIO.read(new File(path + "prim.png"));
    		VAC_CARD = ImageIO.read(new File(path + "Vacuole.png"));
    		NULL_BUILD_SLOT = ImageIO.read(new File(path + "emptySpace.png"));
    		DOWN_ARROW = ImageIO.read(new File(path + "Down_Arrow.png"));
    		UP_ARROW = ImageIO.read(new File(path + "Up_Arrow.png"));
    	}catch(Exception e){e.printStackTrace(); System.exit(1);}
    	
    	scale();
    	
    }
    
    private static void scale()
    {
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	int height = screen.height;
    	int width = screen.width;
    	HUD_BANNER = HUD_BANNER.getScaledInstance(width,height/7, Image.SCALE_SMOOTH);
    	LEFT_ARROW = LEFT_ARROW.getScaledInstance(40, 120, Image.SCALE_SMOOTH);
    	RIGHT_ARROW = RIGHT_ARROW.getScaledInstance(40, 120, Image.SCALE_SMOOTH);
    }
}