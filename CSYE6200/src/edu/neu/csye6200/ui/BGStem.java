/**
 * 
 */
package edu.neu.csye6200.ui;

/**
 * @author Shiqi
 *
 */
public class BGStem {
	double length;
	double xstart;
	double ystart;
	double xend;
	double yend;
	double angle;
	
	
	public BGStem(double length, double xstart, double ystart, double xend, double yend, double angle) {
		this.length = length;
		this.xstart = xstart;
		this.ystart = ystart;
		this.xend = xend;
		this.yend = yend;
		this.angle = angle;
	}

//	public BGStem(double[] a) {
//		this.length = a[0];
//		this.xstart = a[1];
//		this.ystart = a[2];
//		this.xend = a[3];
//		this.yend = a[4];
//	}
	
	/**
	 * 
	 */
	public BGStem() {
	}

	public void calculate(double length, double xstart, double ystart, double xend, double yend,double angle) {
		this.length = length / 2;
		this. xstart = xend;
		this.ystart = yend;
		this.xend = xend + this.length * Math.cos(Math.toRadians(angle));
		System.out.println("cos(" + angle +") : "+ Math.cos(angle));
		this.yend = yend + this.length * Math.sin(Math.toRadians(angle));
		System.out.println("sin(" + angle +") : "+ Math.sin(angle));
		this.angle = angle + 90;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BGStem [length=" + length + ", start: (" + xstart + " , " + ystart + "), end: (" + xend + " , "
				+ yend + ")]";
	}
	
	
}
