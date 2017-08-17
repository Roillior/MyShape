/**
 * This is an abstract class that represent Bounded Shapes 
 * extends MyShape
 * 
 * @author Lior Maimon 
 * mmn12 , Question 1
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class MyBoundedShape extends MyShape{
	//instance variables
	private boolean isFill; //say if the bounded shape will be fill or not
	/**
	 * construct a new bounded Shape
	 * @param point1 - represent a point
	 * @param point2 - represent a point
	 * @param myColor - represent the color of the shape
	 * @param myFill represent if shape will be fill with color or not
	 */
	public MyBoundedShape(Point point1 , Point point2 , Color myColor , boolean myFill) throws IllegalArgumentException{
		super(point1, point2, myColor);
		if((point1.getX() >= point2.getX()) || (point1.getY() >= point2.getY())){
			throw new IllegalArgumentException();
		}
		isFill = myFill;
		
	}
	/**
	 * Return boolean that say if shape is fill or not
	 * @return boolean - true for fill shape false for not
	 */
	public boolean getIsFill(){
		return isFill;
	}
	/**
	 * set isFill
	 * @param myFill
	 */
	public void setIsFIll(boolean myFill){
		isFill = myFill;
	}
	/**
	 * set p1 - use method of class point to check x and y of the point
	 * @throws IllegalArgumentException - if p1 not represent the left top point
	 * @param point
	 */
	public void setP1(Point point){
		if((point.getX() >= getP2().getX()) || (point.getY() >= getP2().getY())){
			throw new IllegalArgumentException();
		}
		super.setP1(point);
	}
	/**
	 * set p2 - use method of class point to check x and y of the point
	 * @throws IllegalArgumentException - if p2 not represent right down point
	 * @param point
	 */
	public void setP2(Point point){
		if((point.getX() <= getP1().getX()) || (point.getY() <= getP1().getY())){
			throw new IllegalArgumentException();
		}
		super.setP2(point);
	}
	/**
	 * method clone
	 * @throws CloneNotSupportedException
	 */
	protected Object clone() throws CloneNotSupportedException{
		MyBoundedShape cloned = (MyBoundedShape)super.clone();
		cloned.setIsFIll(this.getIsFill());
		return cloned;
	}
	/**
	 * method equals
	 */
	@Override
	public boolean equals(Object obj){
		double thisWidth = Math.abs(this.getP2().getX() - this.getP1().getX());
		double objWidth = Math.abs(((MyBoundedShape)obj).getP2().getX() - ((MyBoundedShape)obj).getP1().getX());
		double thisHeight = Math.abs(this.getP2().getY() - this.getP1().getY());
		double objHeight = Math.abs(((MyBoundedShape)obj).getP2().getY() - ((MyBoundedShape)obj).getP1().getY());
		if(thisWidth == objWidth && thisHeight == objHeight){
			return true;
		}
		return false;
	}
	/**
	 * abstract method selfPaint(Graphics g)
	 */
	public abstract void selfPaint(Graphics g);
	
}
