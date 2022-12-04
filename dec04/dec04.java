package dec04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class dec04 {
    
    public static void main(String[] args) throws IOException {

        List<String> input = Files.readAllLines(Paths.get("dec04/input.txt"));
        List<String> contained = Arrays.stream(input.toArray(new String[0]))
            .filter(s -> checkFullyContains(s))
            .collect(Collectors.toList());

        List<String> overlapped = Arrays.stream(input.toArray(new String[0]))
            .filter(s -> checkOverlapped(s))
            .collect(Collectors.toList());

        System.out.println(contained.size());
        System.out.println(overlapped.size());
    
    }

    private static boolean checkFullyContains(String s) {
        String[] s1 = s.split(",");
    
        int a = Integer.parseInt(s1[0].split("-")[0]);
        int b = Integer.parseInt(s1[0].split("-")[1]);
        int c = Integer.parseInt(s1[1].split("-")[0]);
        int d = Integer.parseInt(s1[1].split("-")[1]);

        if(a <= c && b >= d || c <= a && d >= b) return true;

        return false;
    }

    private static boolean checkOverlapped(String s) {
        String[] s1 = s.split(",");
    
        int a = Integer.parseInt(s1[0].split("-")[0]);
        int b = Integer.parseInt(s1[0].split("-")[1]);
        int c = Integer.parseInt(s1[1].split("-")[0]);
        int d = Integer.parseInt(s1[1].split("-")[1]);

        if(a <= d && c <= b) return true;

        return false;
    }


}
