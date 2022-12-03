package dec02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dec02 {
    public static void main(String[] args) throws IOException {

        List<String> input = Files.readAllLines(Paths.get("dec02/input.txt"));

        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }

    private static int solve2(List<String> input){
        int score = 0;

        for (String line : input) {
            switch(line.charAt(2)){
                case 'X':  // loose
                    score += 0;
                    score += Loose(line.charAt(0));
                    break;
                case 'Y': 
                    score += 3;
                    score += Draw(line.charAt(0));
                    break;
                case 'Z': 
                    score += 6;
                    score += Win(line.charAt(0));
                    break;
            }
        }
        return score;
    }

    private static int solve1(List<String> input){
        int score = 0;

        for (String line : input) {
            switch(line.charAt(2)){
                case 'X': 
                    score += 1;
                    score += Rock(line.charAt(0));
                    break;
                case 'Y': 
                    score += 2;
                    score += Paper(line.charAt(0)); 
                    break;
                case 'Z': 
                    score += 3;
                    score += Scissors(line.charAt(0)); 
                    break;
            }
        }
        return score;
    }

    private static int Loose(char p1){
        if(p1 == 'A') return 3;
        if(p1 == 'B') return 1;
        return 2;
    }

    private static int Draw(char p1){
        if(p1 == 'A') return 1;
        if(p1 == 'B') return 2;
        return 3;
    }

    private static int Win(char p1){
        if(p1 == 'A') return 2;
        if(p1 == 'B') return 3;
        return 1;
    }

    // loose: -1 , draw: 0 , win: 1
    private static int Rock(char p1){
        if(p1 == 'C') return 6;
        if(p1 == 'A') return 3;
        
        return 0;
    }

    private static int Paper(char p1){
        if(p1 == 'A') return 6;
        if(p1 == 'B') return 3;
        
        return 0;
    }

    private static int Scissors(char p1){
        if(p1 == 'B') return 6;
        if(p1 == 'C') return 3;
        
        return 0;
    }
    
}
