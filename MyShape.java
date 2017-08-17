/**
 * This is an abstract class that represent Shapes 
 * implement interface Cloneable
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class MyShape implements Cloneable {
	//instance variables
	private Point p1; //represent point 1
	private Point p2; //represent point 2
	private Color color; 
	/**
	 * construct a new Shape
	 * @param point1 - represent a point
	 * @param point2 - represent a point
	 * @param myColor - represent the color of the shape
	 */
	public MyShape(Point point1, Point point2, Color myColor){
		p1 = point1;
		p2 = point2;
		color = myColor;
	}
	/**
	 * Return a pointer to a new point that have the same coordinates like p1
	 * @return an address to a point
	 */
	public Point getP1(){
		Point p = new Point(p1);
		return  p;
	}
	/**
	 * Return a pointer to a new point that have the same coordinates like p2
	 * @return an address to a point
	 */
	public Point getP2(){
		Point p = new Point(p2);
		return p;
	}
	/**
	 * Return the color of the shape
	 * @return a color
	 */
	public Color getColor(){
		return color;
	}
	/**
	 * set the point coordinates
	 * @param point - the new point with the coordinate we want 
	 */
	public void setP1(Point point){
		p1 = new Point (point);
	}
	/**
	 * set the point coordinates
	 * @param point - the new point with the coordinate we want 
	 */
	public void setP2(Point point){
		p2 = new Point(point);
	}
	/**
	 * set the color of the shape
	 * @param myColor - represent the color 
	 */
	public void setColor(Color myColor){
		color = myColor;
	}
	/**
	 * abstract method selfPaint(Graphics g) 
	 */
	public abstract void selfPaint(Graphics g);
	/**
	 * abstract method equals(Object obj) 
	 */
	public abstract boolean equals(Object obj);
	/**
	 * method clone()
	 * @throws CloneNotSupportedException 
	 */
	protected Object clone() throws CloneNotSupportedException{
		MyShape cloned = (MyShape)super.clone(); //use Object method and down casting
		cloned.setP1(new Point(this.getP1())); //set the clone point 1 - make a copy and not pointer
		cloned.setP2(new Point(this.getP2()));// set the clone point 2 - make a copy and not pointer
		return cloned;
		
	}
	
}
