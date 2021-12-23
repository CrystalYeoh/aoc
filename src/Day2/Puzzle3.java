package Day2;

import java.io.File;
import java.util.Scanner;


public class Puzzle3 {
    public static void main(String[] args) throws Exception{
        
        File file1 = new File("puzzle3input.txt");

        Scanner scan = new Scanner(file1);

        int depth = 0;
        int horizontal = 0;
        String[] scanInput;
        while(scan.hasNextLine()){
            scanInput= scan.nextLine().split(" ");

            switch(scanInput[0]){
            case "forward":
                horizontal += Integer.parseInt(scanInput[1]);
                break;
            case "up":
                depth -= Integer.parseInt(scanInput[1]);
                break;
            case "down":
                depth += Integer.parseInt(scanInput[1]);
                break;
            }



            System.out.println("Horizontal: " + horizontal + ", Depth: " + depth);
        }
    }
}
