package dec03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class dec03 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("dec03/input.txt"));
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }

    private static int solve1(List<String> input){
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            String s1 = s.substring(0,s.length()/2);
            String s2 = s.substring(s.length()/2);
            char ch = findCommonChar(s1,s2);

            sum += Character.isLowerCase(ch) ? ch - 96 : ch - 38;
        }
        return sum;
    }

    private static int solve2(List<String> input){
        int sum = 0;
        for (int i = 0; i < input.size(); i = i+3) {
            char ch = findCommonChar(input.get(i), input.get(i+1), input.get(i+2));
            sum += Character.isLowerCase(ch) ? ch - 96 : ch - 38;
        }
        return sum;
    }

    private static Character findCommonChar(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) return s1.charAt(i);
            }
        }
        return ' ';
    }

    private static Character findCommonChar(String s1, String s2, String s3){
        List<Character> commonChars = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) commonChars.add(s1.charAt(i));
            }
        }

        for (int i = 0; i < commonChars.size() ; i++) {
            if(s3.contains(commonChars.get(i).toString())) return commonChars.get(i);
        }
        return ' ';
    }
    
}
