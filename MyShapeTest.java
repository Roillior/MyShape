/**
 * Class that represent the main method
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MyShapeTest {

	public static void main(String[] args) {
		SecureRandom randomNumbers = new SecureRandom(); //random object will produce secure random numbers
		Color color = Color.BLUE;

		MyOval oval1 = makeOval(color, true);
		MyOval oval2 = makeOval(color, true);
		MyRectangle rec1 = makeRec(color, false);
		MyRectangle rec2 = makeRec(color, false);
		MyLine line1 = new MyLine(new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)), new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)) , color);
		MyLine line2 = new MyLine(new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)) , new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)) , color);
		
		ArrayList<MyShape> shapes = new ArrayList<MyShape>(); //array list that will contain the shapes
		shapes.add(line1);
		shapes.add(line2);
		shapes.add(oval1);
		shapes.add(oval2);
		shapes.add(rec1);
		shapes.add(rec2);
		
		
		ArrayList<MyShape> cloneShapes = new ArrayList<MyShape>(); //clone the array list
		for(int ind = 0; ind < shapes.size(); ind++){
			try{
				cloneShapes.add((MyShape)(shapes.get(ind).clone()));
				cloneShapes.get(ind).setP2(new Point((int)cloneShapes.get(ind).getP2().getX() + 10, (int)cloneShapes.get(ind).getP2().getY() + 10 )); //add to p2 10pic to x and 10pic to y
				cloneShapes.get(ind).setP1(new Point((int)cloneShapes.get(ind).getP1().getX() + 10, (int)cloneShapes.get(ind).getP1().getY() + 10 )); //add to p1 10pic to x and 10pic to y
				if(cloneShapes.get(ind) instanceof MyBoundedShape){
					cloneShapes.get(ind).setColor(Color.GRAY);
				}
			}
			catch(CloneNotSupportedException e){}
		}
		
		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyShapePanel panel = new MyShapePanel();
		panel.setShapes(shapes); //copy the array list that contain the shapes to the panel array list
		panel.setShapes(cloneShapes); //copy the array list that contain the clone shapes to the panel array list
		application.add(panel);
		application.setSize(400, 400);
		application.setVisible(true);
		
		
	}
	
	//make an oval check that the points are good
	private static MyOval makeOval(Color color, boolean isFill){
		SecureRandom randomNumbers = new SecureRandom(); //random object will produce secure random numbers
		int counter = 0;
		MyOval oval = null;
		do{
			try {
				oval = new MyOval(new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)), new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)) , color , isFill);
				counter ++;
			}
			catch(IllegalArgumentException e){}
		}while(counter < 1);
		return oval;
	}
	//make an rectangle check that the points are good
	private static MyRectangle makeRec(Color color, boolean isFill){
		SecureRandom randomNumbers = new SecureRandom(); //random object will produce secure random numbers
		int counter = 0;
		MyRectangle rec = null;
		do{
			try {
				rec = new MyRectangle(new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)), new Point(randomNumbers.nextInt(200) , randomNumbers.nextInt(200)) , color , isFill);
				counter ++;
			}
			catch(IllegalArgumentException e){}
		}while(counter < 1);
		return rec;
	}

}
