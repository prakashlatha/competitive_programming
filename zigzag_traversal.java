import java.lang.reflect.Array;
import java.util.*;

public class zigzag_traversal {
    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> current_row = new ArrayList<Integer>();
            for (int j = 0; j < col; j++) {
                int input = in.nextInt();
                current_row.add(input);
            }
            matrix.add(current_row);
        }
        System.out.println(matrix.get(0).get(0));
        if (1 > row) {
            solution(0, 0, row, col, matrix, true);
        } else {
            solution(1, 0, row, col, matrix, true);
        }
    }

    public static void solution(int row, int col, int max_row, int max_col, ArrayList<ArrayList<Integer>> matrix,
            boolean down) {
        boolean indic = true;
        while (row < max_row && row >= 0 && col < max_col && col >= 0 && indic) {
            System.out.println(matrix.get(row).get(col));
            if (row - 1 >= 0 && col + 1 < max_col) {
                row--;
                col++;
            } else {
                indic = false;
                if (col + 1 < max_col) {
                    col++;
                } else if (row + 1 < max_row) {
                    row++;
                } else {
                    return;
                }
            }
        }
        indic = true;
        while (row < max_row && row >= 0 && col < max_col && col >= 0 && indic) {
            System.out.println(matrix.get(row).get(col));
            if (row + 1 < max_row && col - 1 >= 0) {
                row++;
                col--;
            } else {
                indic = false;
                if (row + 1 < max_row) {
                    row++;
                } else if (col + 1 < max_col) {
                    col++;
                } else {
                    return;
                }
            }
        }
        solution(row, col, max_row, max_col, matrix, down);
    }
}
