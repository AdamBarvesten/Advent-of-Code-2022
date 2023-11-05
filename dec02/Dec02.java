package dec02;

import java.io.*;
import java.util.Scanner;

public class Dec02 {
    private static final int WIN = 6;
    private static final int DRAW = 3;
    private static final int LOOSE = 0;
    private static final char ROCK = 'A';
    private static final char PAPER = 'B';
    private static final char SCISSORS = 'C';
    private static final int ROCK_POINTS = 1;
    private static final int PAPER_POINTS = 2;
    private static final int SCISSORS_POINTS = 3;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec02/input.txt");
        System.out.println("Answer part one: " + partOne(new Scanner(file)));
        System.out.println("Answer part two: " + partTwo(new Scanner(file)));
    }

    private static int partOne(Scanner scanner) {
        String[] moves;
        int score = 0;

        while(scanner.hasNextLine()){
            moves = scanner.nextLine().split(" ");
            score += matchScore(moves[0].charAt(0), moves[1].charAt(0)) + moveScore(moves[1].charAt(0));
        }

        return score;
    }

    private static int moveScore(char player) {
        return switch (player) {
            case 'X' -> ROCK_POINTS;
            case 'Y' -> PAPER_POINTS;
            case 'Z' -> SCISSORS_POINTS;
            default -> Integer.MIN_VALUE;
        };
    }

    private static int matchScore(Character opponent, Character player){
        if(opponent == ROCK){
            switch (player){
                case 'X': return DRAW;
                case 'Y': return WIN;
                case 'Z': return LOOSE;
            }
        }
        if(opponent == PAPER){
            switch (player){
                case 'X': return LOOSE;
                case 'Y': return DRAW;
                case 'Z': return WIN;
            }
        }
        if(opponent == SCISSORS){
            switch (player){
                case 'X': return WIN;
                case 'Y': return LOOSE;
                case 'Z': return DRAW;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int partTwo(Scanner scanner){
        String[] moves;
        int score = 0;

        while(scanner.hasNextLine()){
            moves = scanner.nextLine().split(" ");
            score += matchScore2(moves[1].charAt(0)) + moveScore2(moves[0].charAt(0), moves[1].charAt(0));
        }

        return score;
    }

    private static int matchScore2(Character player){
        return switch (player) {
            case 'X' -> LOOSE;
            case 'Y' -> DRAW;
            case 'Z' -> WIN;
            default -> Integer.MIN_VALUE;
        };
    }

    private static int moveScore2(char opponent, char player) {
        if(player == 'X'){
            switch (opponent){
                case ROCK : return SCISSORS_POINTS;
                case PAPER : return ROCK_POINTS;
                case SCISSORS : return PAPER_POINTS;
            }
        }
        if(player == 'Y'){
            switch (opponent){
                case ROCK : return ROCK_POINTS;
                case PAPER : return PAPER_POINTS;
                case SCISSORS : return SCISSORS_POINTS;
            }
        }
        if(player == 'Z'){
            switch (opponent){
                case ROCK : return PAPER_POINTS;
                case PAPER : return SCISSORS_POINTS;
                case SCISSORS : return ROCK_POINTS;
            }
        }
        return Integer.MIN_VALUE;
    }
}
