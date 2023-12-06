package advent_of_code_2023;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

class Main {
    private static HashMap<String, Integer> number_of_cubes;
    public static void main(String args[]) {
        number_of_cubes = new HashMap<>();
        number_of_cubes.put("red", 12);
        number_of_cubes.put("green", 13);
        number_of_cubes.put("blue", 14);

        try{
            List<String> list = Files.readAllLines(new File("2.txt").toPath(), Charset.defaultCharset() );
            int value = calculateValue(list);
            System.out.println(value);
        } catch(Exception e) {
            System.out.println("Failed");
        }
    }

    private static int calculateValue(List<String> list) {
        int value = 0;
        for(String str: list) {
            String[] game_parts = str.split(":");
            String[] individual_game = game_parts[1].split(";");
            boolean possible_game = true;
            for(int i = 0; i < individual_game.length; i++) {
                if(!possibleGame(individual_game[i])) {
                    possible_game = false;
                    break;
                }
            }
            if(possible_game) {
                value += Integer.parseInt(game_parts[0].replaceAll("[\\D]", ""));
            }
        }
        return value;
    }

    private static boolean possibleGame(String game) {
        String[] each_game = game.split(",");
        for(int i = 0; i < each_game.length; i++) {
            int number = Integer.parseInt(each_game[i].replaceAll("[\\D]", ""));
            String color = each_game[i].replaceAll("[^A-Za-z]+", "");
            if(number > number_of_cubes.get(color)) {
                return false;
            }
        }
        return true;
    }

}