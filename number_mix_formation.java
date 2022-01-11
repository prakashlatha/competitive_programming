
import java.io.*;
import java.util.*;

public class number_mix_formation {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number_of_inputs = Integer.parseInt(in.readLine());
        int[] input_array = new int[number_of_inputs];
        String input_array_string_format = in.readLine();
        String[] delited = input_array_string_format.split(" ");
        for (int i = 0; i < number_of_inputs; i++) {
            input_array[i] = Integer.parseInt(delited[i]);
        }
        System.out.println("----------------");
        int target_amount = Integer.parseInt(in.readLine());
        System.out.println("----------------");
        if (check_presence(input_array, target_amount)) {
            System.out.println("target amount can be formed");
        } else if (addons_check_process(0, input_array, target_amount, new ArrayList<Integer>())) {
            System.out.println("target amount can be formed");
        } else {
            System.out.println("Cannot be formed");
        }
    }

    public static boolean check_presence(int[] input_array, int target_amount) {
        for (int i = 0; i < input_array.length; i++) {
            if (input_array[i] == target_amount) {
                return true;
            }
        }
        return false;
    }

    public static boolean addons_check_process(int current_amount, int[] input_array, int target_amount,
            ArrayList<Integer> already_visited) {
        System.out.println("executed");
        if (current_amount > target_amount) {
            return false;
        } else if (current_amount == target_amount) {
            return true;
        }
        for (int i = 0; i < input_array.length; i++) {
            if (!already_visited.contains(input_array[i])) {
                ArrayList<Integer> current_visited = new ArrayList<>(already_visited);
                current_visited.add(input_array[i]);
                int as_parameters = Integer
                        .parseInt(Integer.toString(current_amount) + Integer.toString(input_array[i]));
                if (addons_check_process(as_parameters, input_array, target_amount, current_visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}