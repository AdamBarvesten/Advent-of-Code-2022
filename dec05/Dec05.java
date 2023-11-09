package dec05;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dec05 {
    private static final int STACKS = 9;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec1/input.txt");
        System.out.println("Answer part one: " + partOne(new Scanner(file)));
        System.out.println("Answer part two: " + partTwo(new Scanner(file)));
    }

    private static String partOne(Scanner scanner) {
        String[] stacks =  new String[STACKS];
        Arrays.fill(new String[STACKS], "");
        String line;

        while(scanner.hasNextLine()){
            line = scanner.nextLine();

            if(line.matches(".*[A-Z].*")) stacks = addStackInfo(stacks,line);

            if(line.contains("move")){
                int[] instructions = Arrays.stream(line.split("[^0-9]+"))
                        .filter(s -> s.matches("-?\\d+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                stacks = moveStack9000(stacks,instructions[0],instructions[1],instructions[2]);
            }
        }

        return Arrays.stream(stacks).map(s -> s.substring(s.length() - 1)).collect(Collectors.joining());
    }

    private static String partTwo(Scanner scanner) {
        String[] stacks =  new String[STACKS];
        Arrays.fill(stacks, "");
        String line;

        while(scanner.hasNextLine()){
            line = scanner.nextLine();

            if(line.matches(".*[A-Z].*")) stacks = addStackInfo(stacks,line);

            if(line.contains("move")){
                int[] instructions = Arrays.stream(line.split("[^0-9]+"))
                        .filter(s -> s.matches("-?\\d+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                stacks = moveStack9001(stacks,instructions[0],instructions[1],instructions[2]);
            }
        }

        return Arrays.stream(stacks).map(s -> s.substring(s.length() - 1)).collect(Collectors.joining());
    }

    private static String[] addStackInfo(String[] stacks, String line){
        for(int i = 1; i < line.length(); i = i+4){
            int position = (i+3)/4 -1;
            if(line.charAt(i) != ' ') stacks[position] = line.charAt(i) + stacks[position];
        }
        return stacks;
    }

    private static String[] moveStack9000(String[] stacks, int times, int from, int to){
        from = from-1;
        to = to-1;
        for(int i = 1; i <= times ; i++) {
            stacks[to] = stacks[to] + stacks[from].charAt(stacks[from].length()-1);
            stacks[from] = stacks[from].substring(0,stacks[from].length()-1);
        }
        return stacks;
    }

    private static String[] moveStack9001(String[] stacks, int amount, int from, int to){
        from = from-1;
        to = to-1;
        stacks[to] = stacks[to] + stacks[from].substring(stacks[from].length()-amount);
        stacks[from] = stacks[from].substring(0,stacks[from].length()-amount);

        return stacks;
    }

}
