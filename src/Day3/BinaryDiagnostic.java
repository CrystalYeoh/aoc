package Day3;

import com.sun.tools.hat.internal.parser.Reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinaryDiagnostic {
    public static void main(String[] args) throws Exception {

        File file1 = new File("src/Day3/day3.txt");
        System.out.println("Starting problem");
        Scanner scan = new Scanner(file1);
        // puzzle1(scan);

        List<String> input = new ArrayList<>();
        while(scan.hasNextLine()) {
            input.add(scan.nextLine());
        }

//        List<String> input = new ArrayList<>();
//        input.add("1101");
//        input.add("1011");
//        input.add("0100");

        puzzle2(input);

    }

    public static void puzzle1(Scanner scan) {
        int ones[] = new int[12];
        int counter = 0;
        String[] scanInput;
        while (scan.hasNextLine()) {
            scanInput = scan.nextLine().split("");
            for (int i = 0; i < 12; i++) {
                ones[i] += Integer.parseInt(scanInput[i]);
            }
            counter += 1;
        }
        String gammaStr = "";
        String epsilonStr = "";

        for (int i = 0; i < 12; i++) {
            if (ones[i] > counter / 2) {
                gammaStr += "1";
                epsilonStr += "0";
            } else {
                gammaStr += "0";
                epsilonStr += "1";
            }
        }

        System.out.println("Gamma is " + gammaStr);
        System.out.println("Epsilon is " + epsilonStr);

        int gamma = Integer.parseInt(gammaStr, 2);
        int epsilon = Integer.parseInt(epsilonStr, 2);

        System.out.println("Power is " + gamma * epsilon);
    }

    public static void puzzle2(List<String> input) {
        int oxygen = Integer.parseInt(findRating(input, true, 0), 2);
        int C02 = Integer.parseInt(findRating(input, false, 0), 2);

        System.out.println("Life support is " + oxygen * C02);
    }

    public static String findRating(final List<String> bitCriteriaSatisfied, final boolean oxygen, final int bitCount) {
        if (bitCriteriaSatisfied.size() == 1) {
            return bitCriteriaSatisfied.get(0);
        }

        boolean one = findMostBit(bitCriteriaSatisfied, bitCount);
        char keep = ((oxygen && one) || (!oxygen && !one)) ? '1' : '0';
        List<String> output = bitCriteriaSatisfied.stream()
                .filter(s -> s.charAt(bitCount) == keep)
                .collect(Collectors.toList());
        return findRating(output, oxygen, bitCount + 1);
    }

    private static boolean findMostBit(final List<String> bitCriteriaSatisfied, final int bitCount) {
        return (bitCriteriaSatisfied.stream()
                .filter(s -> s.charAt(bitCount) == '1')
                .count()) >= ((float) bitCriteriaSatisfied.size() / 2);
    }
}
