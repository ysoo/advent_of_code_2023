package advent_of_code_2023;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

class Main {
    /*
     * The newly-improved calibration document consists of lines of text;
     * each line originally contained a specific calibration value that the Elves
     * now need to recover.
     * On each line, the calibration value can be found by combining the first
     * digit and the last digit (in that order) to form a single two-digit number.
     * 
     * For example:
     * 
     * 1abc2
     * pqr3stu8vwx
     * a1b2c3d4e5f
     * treb7uchet
     * In this example, the calibration values of these four lines are 12, 38, 15,
     * and 77. Adding these together produces 142.
     * 
     * Consider your entire calibration document. What is the sum of all of the
     * calibration values?
     */
    public static void main(String args[]) {
        try{
            List<String> list = Files.readAllLines(new File("1.txt").toPath(), Charset.defaultCharset() );
            int value = calculateValue(list);
            System.out.println(value);
        } catch(Exception e) {
            System.out.println("Failed");
        }
    }

    private static int calculateValue(List<String> list) {
        int value = 0;
        for(String str: list) {
            char first = '0';
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    first = str.charAt(i);
                }
            }
            char last = '0';
            for(int i = str.length() - 1; i >= 0; i--) {
                if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    last = str.charAt(i);
                }
            }
            String temp = new StringBuilder().append(last).append(first).toString();
            int currValue = Integer.valueOf(temp);
            value += currValue;
        }
        return value;
    }

    private static int calculateValueString(List<String> list) {
        int value = 0;
        HashMap<String, Character> test = new HashMap<String, Character>();
        for(String str: list) {
            char first = '0';
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    first = str.charAt(i);
                }
            }
            char last = '0';
            for(int i = str.length() - 1; i >= 0; i--) {
                if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    last = str.charAt(i);
                }
            }
            String temp = new StringBuilder().append(last).append(first).toString();
            int currValue = Integer.valueOf(temp);
            value += currValue;
        }
        return value;
    }
}