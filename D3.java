package advent_of_code_2023;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

class D3 {
    public static void main(String args[]) {
        try {
            List<String> list = Files.readAllLines(new File("D3.txt").toPath(), Charset.defaultCharset());
            char[][] charArray = createCharArray(list);
            int value = findValue(charArray);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    private static char[][] createCharArray(List<String> list) {
        char[][] charArray = new char[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            charArray[i] = list.get(i).toCharArray();
        }

        return charArray;
    }

    private static int findValue(char[][] schematic) {
        int value = 0;
        for (int i = 0; i < schematic.length; i++) {
            for (int j = 0; j < schematic[i].length; j++) {
                int st = j;
                int temp = 0;
                if (schematic[i][j] <= '9' && schematic[i][j] >= '0') {
                    while (j < schematic[i].length && schematic[i][j] <= '9' && schematic[i][j] >= '0') {
                        temp = temp * 10 + schematic[i][j] - '0';
                        j++;
                    }
                    if (moveOut(schematic, i, st, j)) {
                        value += temp;
                    }
                }
            }
        }

        return value;
    }

    private static boolean moveOut(char[][] schematic, int i, int st, int j) {
        boolean result = false;
        for (int k = st - 1; k <= j; k++) {
            if (k < 0)
                continue;
            if (k > schematic.length - 1)
                break;
            if (i - 1 >= 0) {
                if (schematic[i - 1][k] != '.' && !Character.isDigit(schematic[i - 1][k])) {
                    result = true;
                    break;
                }
            }
            if (schematic[i][k] != '.' && !Character.isDigit(schematic[i][k])) {
                result = true;
                break;
            }
            if (i + 1 < schematic.length) {
                if (schematic[i + 1][k] != '.' && !Character.isDigit(schematic[i + 1][k])) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
