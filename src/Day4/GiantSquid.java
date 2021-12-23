package Day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GiantSquid {
    public static void main(String[] args) throws Exception {

        File file = new File("src/Day4/input.txt");
        System.out.println("Starting problem");
        Scanner scan = new Scanner(file);

        int answer = puzzle1(scan);
        System.out.println(answer);

    }

    private static int puzzle1(final Scanner scan) {
        String[] bingoNumbers = scan.nextLine().split(",");
        List<Integer> boardSum = new ArrayList<>();
        HashMap<Integer, List<String>> boardMap = new HashMap<>();
        HashMap<String, Integer> boardCount = new HashMap<>();
        int row = 0;
        int col = 0;
        int board = 0;
        int sum = 0;
        while (scan.hasNextInt()) {
            int x = scan.nextInt();
            if (boardMap.containsKey(x)) {
                boardMap.get(x).add(String.format("%d,%d,%d", board, row, col));
            } else {
                List<String> l = new ArrayList<>();
                l.add(String.format("%d,%d,%d", board, row, col));
                boardMap.put(x, l);
            }
            sum += x;
            row++;
            if (row == 5) {
                row = 0;
                col++;
            }
            if (col == 5) {
                col = 0;
                boardSum.add(sum);
                sum = 0;
                board++;
            }
        }

        for (int i = 0; i < board; i++) {
            for (int x = 0; x < 5; x++) {
                boardCount.put(String.format("%d,R,%d", i, x), 5);
                boardCount.put(String.format("%d,C,%d", i, x), 5);
            }
        }

        Iterator bingo = Arrays.stream(bingoNumbers).iterator();

        int boardKey = -1;
        int currBingo = -1;
        boolean notdone = true;
        while (bingo.hasNext()&&notdone) {
            currBingo = Integer.parseInt((String) bingo.next());
            List<String> called = boardMap.get(currBingo);
            for (int i = 0; i < called.size(); i++) {
                String[] marked = called.get(i).split(",");
                boardKey = Integer.parseInt(marked[0]);
                boardSum.set(boardKey, boardSum.get(boardKey) - currBingo);
                String rowKey = String.format("%s,R,%s", marked[0], marked[1]);
                String colKey = String.format("%s,C,%s", marked[0], marked[2]);
                int currRowCount = boardCount.get(rowKey) - 1;
                int currColCount = boardCount.get(colKey) - 1;
                if (currRowCount == 0 || currRowCount == 0) {
                    notdone = false;
                    break;
                }

                boardCount.put(rowKey, currRowCount);
                boardCount.put(colKey, currColCount);
            }

        }
        return boardSum.get(boardKey) * currBingo;
    }

}
