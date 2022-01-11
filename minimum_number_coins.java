import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class sorts_descending implements Comparator<Integer> {
    public int compare(Integer idx1, Integer idx2) {
        return Integer.compare(idx2, idx1);
    }
}

public class minimum_number_coins {
    public static void main(String argv[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number_of_inputs = Integer.parseInt(in.readLine());
        String str = in.readLine();
        String[] splits = str.split(" ");
        Integer[] coins_available = new Integer[number_of_inputs];
        for (int i = 0; i < number_of_inputs; i++) {
            coins_available[i] = Integer.parseInt(splits[i]);
        }
        System.out.println("-------------------");
        int target_amount = Integer.parseInt(in.readLine());
        Arrays.sort(coins_available, new sorts_descending());
        System.out.println("-------------------");
        problem_solver(0, coins_available, target_amount, "");
    }

    public static boolean problem_solver(int amount_having, Integer[] coins_available, int target_amount,
            String amount_train) {
        if (amount_having > target_amount) {
            return false;
        }
        if (amount_having == target_amount) {
            return true;
        }
        for (int i = 0; i < coins_available.length; i++) {
            String str = amount_train + " " + coins_available[i];
            if (problem_solver(amount_having + coins_available[i], coins_available, target_amount, str)) {
                System.out.println(str);
                System.exit(0);
            }
        }
        return false;
    }
}
