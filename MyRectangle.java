/**
 * This class represent a rectangle 
 * extends MyBoundedShape
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyRectangle extends MyBoundedShape{
	/**
	 * construct a new rectangle
	 * @param point1 - represent a point
	 * @param point2 - represent a point
	 * @param myColor - represent the color of the shape
	 * @param myFill - represent fill situation with the shape
	 */
	public MyRectangle(Point point1, Point point2, Color myColor, boolean myFill) {
		super(point1, point2, myColor, myFill); //use father constructor
	}
	/**
	 * method selfPaint - paint a rectangle using fillRectangle or drawRectangle from graphics
	 */
	@Override
	public void selfPaint(Graphics g){
		g.setColor(this.getColor());
		if(this.getIsFill()){ //check if rectangle need to be full with color or not
			g.fillRect((int)this.getP1().getX(), (int)this.getP1().getY(), Math.abs((int)(this.getP2().getX() - this.getP1().getX())), Math.abs((int)(this.getP2().getY() - this.getP1().getY())));
		}
		else {
			g.drawRect((int)this.getP1().getX(), (int)this.getP1().getY(), Math.abs((int)(this.getP2().getX() - this.getP1().getX())), Math.abs((int)(this.getP2().getY() - this.getP1().getY())));
		}
	}
	/**
	 * method clone
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException{
		MyRectangle cloned = (MyRectangle)super.clone();
		return cloned;
	}
	/**
	 * method equals
	 */
	@Override
	public boolean equals(Object obj){
		if((this instanceof MyRectangle) && (obj instanceof MyRectangle)){
			return super.equals(obj);
			}
		return false;
	}
}
