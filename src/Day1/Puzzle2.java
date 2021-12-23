package Day1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Puzzle2 {
    public static void main(String[] args) throws Exception{
        
        File file1 = new File("puzzle1input.txt");

        Scanner scan = new Scanner(file1);

        int[] window = new int[3];
        
        int sum = 0;
        int scanInt;
        for (int i = 0;  i<3;i ++){
            scanInt = scan.nextInt();
            window[i] = scanInt;
            sum += scanInt;
        }

        int nextSum = sum;
        int countIncrease = 0;
        
        int count = 0;
        while(scan.hasNextInt()){
            scanInt= scan.nextInt();
            nextSum += - window[count] + scanInt;
            if (nextSum>sum){
                countIncrease++;
            }
            window[count] = scanInt;
            count = (count + 1)%3;
            sum = nextSum;


            System.out.println("The count is " + countIncrease);
        }
    }
}
