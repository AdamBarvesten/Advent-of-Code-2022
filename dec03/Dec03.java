package dec03;

import java.io.*;
import java.util.Scanner;

public class Dec03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec03/input.txt");
        System.out.println("Answer part one: " + partOne(new Scanner(file)));
        System.out.println("Answer part two: " + partTwo(new Scanner(file)));
    }

    private static int partOne(Scanner scanner) {
        String rucksack;
        String[] compartments = new String[2];
        int sum = 0;

        while (scanner.hasNextLine()) {
            rucksack = scanner.nextLine();
            compartments[0] = rucksack.substring(0, (rucksack.length() / 2));
            compartments[1] = rucksack.substring((rucksack.length() / 2));

            char commonItem = compartments[0].chars()
                    .filter(c -> compartments[1].contains(String.valueOf((char)c)))
                    .mapToObj(c -> (char)c)
                    .findFirst()
                    .orElse('\0');
            sum += calculatePriority(commonItem);
        }
        return sum;
    }

    private static int partTwo(Scanner scanner) {
        String[] rucksacks = new String[3];
        int sum = 0;

        while (scanner.hasNextLine()) {
            for (int i = 0; i < 3 ; i++) rucksacks[i] = scanner.nextLine();
            char badge = rucksacks[0].chars()
                    .filter(c -> rucksacks[1].contains(String.valueOf((char)c)))
                    .filter(c -> rucksacks[2].contains(String.valueOf((char)c)))
                    .mapToObj(c -> (char)c)
                    .findFirst()
                    .orElse('\0');
            sum += calculatePriority(badge);
        }
        return sum;
    }

    private static int calculatePriority(char c){
        return Character.isLowerCase(c) ? c - 96 : c - 38;
    }
}
