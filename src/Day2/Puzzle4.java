package Day2;

import java.io.File;
import java.util.Scanner;


public class Puzzle4 {
    public static void main(String[] args) throws Exception{
        
        File file1 = new File("puzzle3input.txt");

        Scanner scan = new Scanner(file1);

        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        String[] scanInput;
        while(scan.hasNextLine()){
            scanInput= scan.nextLine().split(" ");
            int magnitude = Integer.parseInt(scanInput[1]);
            String direction = scanInput[0];
            switch(direction){
            case "forward":
                horizontal += magnitude;
                depth += magnitude*aim;
                break;
            case "up":
                aim -= magnitude;
                break;
            case "down":
                aim += magnitude;
                break;
            }



            System.out.println("Horizontal: " + horizontal + ", Depth: " + depth);
        }
        System.out.println(horizontal*depth);
    }
}
