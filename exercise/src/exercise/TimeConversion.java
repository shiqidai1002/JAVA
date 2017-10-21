package exercise;

import java.util.*;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class TimeConversion {
    static String timeConversion(String s) throws Exception {
        // Complete this function
        SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date();
        SimpleDateFormat m = new SimpleDateFormat("hh:mm:ssa");
        d = m.parse(s);
        String result = t.format(d);
        return result;
    }


	public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
