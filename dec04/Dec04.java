package dec04;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Dec04 {
    private static final int MIN_1 = 0;
    private static final int MAX_1 = 1;
    private static final int MIN_2 = 2;
    private static final int MAX_2 = 3;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec04/input.txt");
        System.out.println("Answer part one: " + partOne(new Scanner(file)));
        System.out.println("Answer part two: " + partTwo(new Scanner(file)));
    }

    private static int partOne(Scanner scanner) {
        Predicate<int[]> fullyContain = in -> (in[MIN_1] <= in[MIN_2] && in[MAX_1] >= in[MAX_2]) || (in[MIN_2] <= in[MIN_1] && in[MAX_2] >= in[MAX_1]);
        return testRanges(scanner,fullyContain);
    }

    private static int partTwo(Scanner scanner) {
        Predicate<int[]> overlap = in -> in[MIN_1]<=in[MAX_2] && in[MIN_2]<=in[MAX_1];
        return testRanges(scanner,overlap);
    }

    private static int testRanges(Scanner scanner, Predicate<int[]> condition){
        int sum = 0;
        int[] in;

        while(scanner.hasNextLine()){
            in = Arrays.stream(scanner.nextLine().split("\\D+")).mapToInt(Integer::parseInt).toArray();
            if(condition.test(in)) sum+=1;
        }
        return sum;
    }



}
