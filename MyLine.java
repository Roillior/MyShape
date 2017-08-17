/**
 * This class represent a line 
 * extends MyShape
 * 
 * @author Lior Maimon  
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyLine extends MyShape{
	/**
	 * construct a new line
	 * @param point1 - represent a point
	 * @param point2 - represent a point
	 * @param myColor - represent the color of the shape
	 */
	public MyLine(Point point1, Point point2, Color myColor){
		super(point1, point2, myColor); //use father constructor
	}
	/**
	 * method selfPaint - paint a line using drawLine from graphics
	 */
	@Override
	public void selfPaint(Graphics g){
		g.setColor(this.getColor());
		g.drawLine((int)this.getP1().getX(), (int)this.getP1().getY(), (int)this.getP2().getX(), (int)this.getP2().getY());
	}
	/**
	 * method equals
	 */
	@Override
	public boolean equals(Object obj){
		if((this instanceof MyLine) && (obj instanceof MyLine)){
			if(((MyLine)this).getLength() == ((MyLine)obj).getLength()){
				return true;
			}
		}
		return false;
	}
	/**
	 * method clone
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException{
		MyLine cloned = (MyLine)super.clone();
		return cloned;
	}
	//private method check the length of the line - used to compare tw lines
	private double getLength(){
		int x1 = (int)this.getP1().getX();
		int y1 = (int)this.getP1().getY();
		int x2 = (int)this.getP2().getX();
		int y2 = (int)this.getP2().getY();
		
		double res = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		return res;
	}

}
