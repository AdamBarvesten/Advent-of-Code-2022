package dec01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dec01 {
    public static void main(String[] args) throws IOException {        
        BufferedReader reader = new BufferedReader(new FileReader("dec01/input.txt"));
        String line = reader.readLine();
        int[] topCal = new int[]{0, 0, 0};
        int tempcal = 0;

        while(line != null){
            if(line.equals("")){
                if(tempcal > topCal[0] ){
                    topCal[2] = topCal[1];
                    topCal[1] = topCal[0];
                    topCal[0] = tempcal;
                }
                else if(tempcal > topCal[1]){
                    topCal[2] = topCal[1];
                    topCal[1] = tempcal;
                }
                else if(tempcal > topCal[2]){
                    topCal[2] = tempcal;
                }

                tempcal = 0;
                line = reader.readLine();
                
            }else{
                tempcal += Integer.parseInt(line);
                line = reader.readLine();
            }
        }
        reader.close();

        System.out.println(topCal[0]);
        System.out.println(topCal[0] + topCal[1] + topCal[2]);
    }
}
