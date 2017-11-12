/**
 * 
 */
package edu.neu.csye6200.ui;

/**
 * @author Shiqi
 *
 */
public class BGRule {

	public static double[] calculateCenter(double length, double xstart, double ystart, double xend, double yend,double angle) {
		double length_n = length / 2;
		double xstart_n = xend;
		double ystart_n = yend;
		double xend_n = xend;
		double yend_n = yend + length_n;
		double[] result = { length_n, xstart_n, ystart_n, xend_n, yend_n };
		return result;
	}
	
	public static double[] calculateLeft(double length, double xstart, double ystart, double xend, double yend, double angle) {
		double length_n = length / 2;
		double xstart_n = xend;
		double ystart_n = yend;
		double xend_n = xend - length_n * Math.cos(angle);
		double yend_n = yend + length_n * Math.sin(angle);
		double[] result = { length_n, xstart_n, ystart_n, xend_n, yend_n };
		return result;
	}
	
	public static double[] calculateRight(double length, double xstart, double ystart, double xend, double yend, double angle) {
		double length_n = length / 2;
		double xstart_n = xend;
		double ystart_n = yend;
		double xend_n = xend + length_n * Math.cos(angle);
		double yend_n = yend + length_n * Math.sin(angle);;
		double[] result = { length_n, xstart_n, ystart_n, xend_n, yend_n };
		return result;
	}
}
