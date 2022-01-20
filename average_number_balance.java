import java.util.*;

public class average_number_balance {

    public static HashSet<String> combinations_holder = new HashSet<>();

    class arraylist {
        ArrayList<Integer> left;
        ArrayList<Integer> right;

        public arraylist(ArrayList<Integer> left, ArrayList<Integer> right) {
            this.left = new ArrayList<>(left);
            this.right = new ArrayList<>(right);
        }
    }

    public static ArrayList<arraylist> answer_holders = new ArrayList<>();

    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> number_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            number_list.add(input);
        }
        permute(new ArrayList<Integer>(), new ArrayList<Integer>(), number_list);

    }

    public static void permute(ArrayList<Integer> visited_idx, ArrayList<Integer> number_holder,
            ArrayList<Integer> number_list) {
        if (number_holder.size() == number_list.size()) {
            check_divisions(number_holder);
            return;
        }
        for (int i = 0; i < number_list.size(); i++) {
            if (!visited_idx.contains(i)) {
                ArrayList<Integer> temp_number_holder = new ArrayList<>(number_holder);
                ArrayList<Integer> new_visited = new ArrayList<>(visited_idx);
                new_visited.add(i);
                temp_number_holder.add(number_list.get(i));
                permute(new_visited, temp_number_holder, number_list);
            }
        }
    }

    public static void check_divisions(ArrayList<Integer> number_holder) {
        for (int i = 0; i < number_holder.size() - 1; i++) {
            ArrayList<Integer> left = getleft(i, number_holder);
            ArrayList<Integer> right = getright(i + 1, number_holder);
            Double left_sum = 0.0;
            Double right_sum = 0.0;
            Double left_size = left.size() + 0.0;
            Double right_size = right.size() + 0.0;
            for (int idx = 0; idx < left.size(); idx++) {
                left_sum += left.get(idx);
            }
            for (int idx = 0; idx < right.size(); idx++) {
                right_sum += right.get(idx);
            }

            if (left_sum / left_size == right_sum / right_size) {
                if (isdupliucate(left, right)) {
                    System.out.println(left + " " + right);
                }

            }
        }
    }

    public static ArrayList<Integer> getleft(int idx, ArrayList<Integer> number_holder) {
        ArrayList<Integer> returns = new ArrayList<>();
        for (int i = 0; i <= idx && i < number_holder.size() - 1; i++) {
            returns.add(number_holder.get(i));
        }
        return returns;
    }

    public static ArrayList<Integer> getright(int idx, ArrayList<Integer> number_holder) {
        ArrayList<Integer> returns = new ArrayList<>();
        for (int i = idx; i < number_holder.size(); i++) {
            returns.add(number_holder.get(i));
        }
        return returns;
    }

    public static boolean isdupliucate(ArrayList<Integer> left, ArrayList<Integer> right) {
        String left_combo_string = string_it(left);
        String right_combo_string = string_it(right);
        for (String combos : combinations_holder) {
            if (left_combo_string.equals(combos) || right_combo_string.contains(combos)) {
                return false;
            }
        }
        combinations_holder.add(left_combo_string);
        combinations_holder.add(right_combo_string);
        return true;
    }

    public static String string_it(ArrayList<Integer> nodes) {
        String return_val = "";
        Collections.sort(nodes);
        for (int i = 0; i < nodes.size(); i++) {
            return_val += nodes;
        }
        return return_val;
    }

}
