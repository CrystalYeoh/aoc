package Day1;

import java.io.File;
import java.util.Scanner;


public class SonarSweep {
    public static void main(String[] args) throws Exception{
        
        File file1 = new File("puzzle1input.txt");

        Scanner scan = new Scanner(file1);

        int next;
        int prev = scan.nextInt();
        int countIncrease = 0;
        System.out.println("The count is" + countIncrease);
    
        while (scan.hasNextInt()) {
            next = scan.nextInt();
            if (next>prev){
                countIncrease++;
            }
            prev = next;
            System.out.println("The count is " + countIncrease);
        }   
    }
}
