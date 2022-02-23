import java.util.ArrayList;
import java.util.Scanner;

public class island_in_matrix {
    public static int number_of_islands = 0;
    public static int[][] matrix;
    public static int row, col;

    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        row = in.nextInt();
        col = in.nextInt();
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    number_of_islands++;
                    find_island_surface(i, j);
                }
            }
        }
        System.out.println(number_of_islands);

    }

    public static void find_island_surface(int current_row, int current_col) {
        if (matrix[current_row][current_col] == 0) {
            return;
        }
        matrix[current_row][current_col] = 0;
        if (current_row + 1 < row) {
            find_island_surface(current_row + 1, current_col);
        }
        if (current_col + 1 < col) {
            find_island_surface(current_row, current_col + 1);
        }
        if (current_row - 1 >= 0) {
            find_island_surface(current_row - 1, current_col);
        }
        if (current_col - 1 >= 0) {
            find_island_surface(current_row, current_col - 1);
        }
    }
}
