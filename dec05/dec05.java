package dec05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dec05 {
    private static final int MAX = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dec05/input.txt"));
        String line = reader.readLine();

        HashMap<Integer,ArrayDeque<Character>> map9000 = new HashMap<>();
        HashMap<Integer,ArrayDeque<Character>> map9001 = new HashMap<>();

        for (int i = 1; i <= MAX; i++) {
            map9000.put(i, new ArrayDeque<>());
            map9001.put(i, new ArrayDeque<>());

        }

        while(!line.contains("1")){
            for (int i = 1; i <= MAX; i++) {
                char c = line.charAt(1 + (4*(i-1)));
                if(c != ' ') map9000.get(i).addFirst(c);
                if(c != ' ') map9001.get(i).addFirst(c);
            }
            line = reader.readLine();
        }
        line = reader.readLine();
        line = reader.readLine();

        while(line != null){
            line = line.replaceAll("[a-z]", "");
            Integer[] list = Arrays.stream(line.split(" "))
                                      .filter(s -> !s.equals(""))
                                      .map(s -> Integer.parseInt(s))
                                      .toArray(Integer[]::new);
            map9000 = move9000(map9000, list[0], list[1], list[2]);
            map9001 = move9001(map9001, list[0], list[1], list[2]);
            
            line = reader.readLine();
        }

        reader.close();

        
        for (int i = 1; i <= map9000.size(); i++) {
            System.out.print(map9000.get(i).peekLast());
        }
        System.out.println("");

        for (int i = 1; i <= map9001.size(); i++) {
            System.out.print(map9001.get(i).peekLast());
        }
    }

    private static HashMap<Integer, ArrayDeque<Character>> move9000(HashMap<Integer, ArrayDeque<Character>> map, int amount, int from, int to) {
        for (int i = 0; i < amount; i++) {
            char box = map.get(from).pollLast();
            map.get(to).addLast(box);
        }
        return map;
    }

    private static HashMap<Integer, ArrayDeque<Character>> move9001(HashMap<Integer, ArrayDeque<Character>> map, int amount, int from, int to) {
        List<Character> boxes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            boxes.add(map.get(from).pollLast());
        }

        for (int j = boxes.size()-1 ; j >= 0 ; j--){
            map.get(to).addLast(boxes.get(j));
        }

        return map;
    }
    

    
}
