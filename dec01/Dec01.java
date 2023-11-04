package dec01;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dec01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dec01/input.txt");

        System.out.println("Answer part one: " + partOne(new Scanner(file)));
        System.out.println("Answer part two: " + partTwo(new Scanner(file)));
    }

    private static int partOne(Scanner scanner) {
        int elf = 0, max = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            elf = line.equals("") ? 0 : elf + Integer.parseInt(line);
            max = Math.max(elf, max);
        }
        return max;
    }

    private static int partTwo(Scanner scanner){
        int elf = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.nCopies(3, 0));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.equals("")){
                updateQueueIfNecessary(elf, pq);
                elf=0;
                continue;
            }

            elf += Integer.parseInt(line);

            if(!scanner.hasNextLine()) updateQueueIfNecessary(elf, pq);
        }
        return pq.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * This method updates the queue if an elf has more than any of the top three most calories
     *
     * @param elf The amount of calories the elf has.
     * @param pq The priority queue with top three most calories
     */
    private static void updateQueueIfNecessary(int elf, PriorityQueue<Integer> pq) {
        if (elf > pq.peek()) {
            pq.poll();
            pq.offer(elf);
        }
    }
}
