/**
 * This class represent the panel 
 * extends JPanel
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyShapePanel extends JPanel{
	//instance variables
	ArrayList<MyShape> shapes = new ArrayList<MyShape>(); //will contain the shapes for disply on panel
	
	//no constructor use the father(JPanel) empty constructor
	
	//method to set the arrayList with the needed shapes
	public void setShapes(ArrayList<MyShape> shape){
		for(int i = 0; i < shape.size(); i++){
			shapes.add(shape.get(i));
		}
	}
	/**
	 * method paintComponent
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i = 0; i < shapes.size(); i++){
			shapes.get(i).selfPaint(g);
		}
	}
}
