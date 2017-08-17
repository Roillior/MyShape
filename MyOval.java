/**
 * This class represent an oval 
 * extends MyBoundedShape
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyOval extends MyBoundedShape{
	/**
	 * construct a new oval
	 * @param point1 - represent a point
	 * @param point2 - represent a point
	 * @param myColor - represent the color of the shape
	 * @param myFill - represent fill situation with the shape
	 */
	public MyOval(Point point1 , Point point2 , Color myColor , boolean myFill){
		super(point1 , point2 , myColor , myFill); // use father constructor
	}
	/**
	 * method clone
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException{
		MyOval cloned = (MyOval)super.clone();
		return cloned;
	}
	/**
	 * method equals
	 */
	@Override
	public boolean equals(Object obj){
		if((this instanceof MyOval) && (obj instanceof MyOval)){
			return super.equals(obj);
			}
		return false;
	}
	/**
	 * method selfPaint - paint an oval using fillOval or drawOval from graphics
	 */
	@Override
	public void selfPaint(Graphics g){
		g.setColor(this.getColor());
		if(this.getIsFill()){ //check if the oval need to be full with color or not
			g.fillOval((int)this.getP1().getX(), (int)this.getP1().getY(), Math.abs((int)(this.getP2().getX() - this.getP1().getX())), Math.abs((int)(this.getP2().getY() - this.getP1().getY())));
		}
		else {
			g.drawOval((int)this.getP1().getX(), (int)this.getP1().getY(), Math.abs((int)(this.getP2().getX() - this.getP1().getX())), Math.abs((int)(this.getP2().getY() - this.getP1().getY())));
		}
	}

}
