package ch03_ex3_DownloadTime;
import java.util.*;
public class DownloadTimeApp {
	public static void main(String[] args){
		String loop = null;
		do{
			System.out.println("Welcome to the Download Time Estimator");
			System.out.println("");
			System.out.print("Enter file size (MB): ");
			//enter
			Scanner sc = new Scanner(System.in);
			double mb = sc.nextDouble();
			System.out.print("Enter download speed (MB/sec): ");
			//enter
			double speed = sc.nextDouble();
			//calculate
			int totalSec = (int) (mb / speed);
			int h = totalSec / 3600;
			int m = (totalSec - h * 3600) / 60;
			int s = (totalSec - h *3600 ) % 60;
			//output
			System.out.println("");
			System.out.println("This download will approximately " 
								+ h + " hours " + m + " minutes " + s + " seconds.");
			System.out.println("");
			System.out.print("Continue? (y/n): " );
			loop = sc.next();
			System.out.println("--------------------------------------------------");
		}
		while (!loop.equalsIgnoreCase("n"));
	}
}
