import java.util.*;

public class component_dependency {
    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<int[]> input = new ArrayList<int[]>();
        int times = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        Map<Integer, ArrayList<Integer>> childholder = new HashMap<>();
        Map<Integer, ArrayList<Integer>> parentholder = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < times; i++) {
            int[] current_input = new int[2];
            current_input[0] = in.nextInt();
            current_input[1] = in.nextInt();
            input.add(current_input);
            set.add(current_input[0]);
            set.add(current_input[1]);
            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            if (childholder.containsKey(current_input[0])) {
                temp1 = new ArrayList<>(childholder.get(current_input[0]));
            }
            if (parentholder.containsKey(current_input[1])) {
                temp2 = new ArrayList<>(parentholder.get(current_input[1]));
            }
            temp2.add(current_input[0]);
            temp1.add(current_input[1]);
            visited.put(current_input[1], true);
            visited.put(current_input[0], true);
            parentholder.put(current_input[1], temp2);
            childholder.put(current_input[0], temp1);
        }
        int idx_start = 0;
        for (int KEY : set) {
            System.out.println(parentholder.get(KEY) + "   " + KEY + "   " + childholder.get(KEY));
            if (parentholder.get(KEY) == null) {
                idx_start = KEY;
            }
        }
        ArrayList<Integer> order_to_be_processed = new ArrayList<>();
        solution(visited, order_to_be_processed, childholder, parentholder, idx_start);
        for (int i = 0; i < order_to_be_processed.size(); i++) {
            System.out.printf("-> %d", order_to_be_processed.get(i));
        }
    }

    public static void solution(HashMap<Integer, Boolean> visited, ArrayList<Integer> order_to_be_processed,
            Map<Integer, ArrayList<Integer>> childholder, Map<Integer, ArrayList<Integer>> parentholder,
            int start_idx_key) {
        if (visited.get(start_idx_key) == false) {
            return;
        }
        ArrayList<Integer> parents = new ArrayList<Integer>();
        ArrayList<Integer> children = new ArrayList<Integer>();
        int current_node = start_idx_key;
        if (parentholder.get(start_idx_key) != null) {
            parents = new ArrayList<Integer>(parentholder.get(start_idx_key));
        }
        if (childholder.get(start_idx_key) != null) {
            children = new ArrayList<Integer>(childholder.get(start_idx_key));
        }
        for (int i = 0; i < parents.size(); i++) {
            int current_child_idx = parents.get(i);
            if (visited.get(current_child_idx) == true) {
                solution(visited, order_to_be_processed, childholder, parentholder, current_child_idx);
            }
        }
        if (visited.get(start_idx_key) == true) {
            visited.put(current_node, false);
            order_to_be_processed.add(current_node);
        }
        for (int i = 0; i < children.size(); i++) {
            int current_child_idx = children.get(i);
            if (visited.get(current_child_idx) == true) {
                solution(visited, order_to_be_processed, childholder, parentholder, current_child_idx);
            }
        }

    }
}