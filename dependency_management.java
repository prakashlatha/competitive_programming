import java.util.*;

class graph_mac {
    int data;
    ArrayList<graph_mac> childs = new ArrayList<>();
    ArrayList<graph_mac> parents = new ArrayList<>();

    graph_mac(int data) {
        this.data = data;
    }

}

public class dependency_management {
    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        int number_of_inputs = in.nextInt();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, graph_mac> macs = new HashMap<>();
        for (int i = 0; i < number_of_inputs; i++) {
            ArrayList<Integer> current_input = new ArrayList<>();
            int parent = in.nextInt();
            int child = in.nextInt();
            current_input.add(parent);
            current_input.add(child);
            input.add(current_input);
        }
        for (int idx = 0; idx < number_of_inputs; idx++) {
            ArrayList<Integer> traversing_input = input.get(idx);
            if (!macs.containsKey(traversing_input.get(0))) {
                macs.put(traversing_input.get(0), new graph_mac(traversing_input.get(0)));
            }
            if (!macs.containsKey(traversing_input.get(1))) {
                macs.put(traversing_input.get(1), new graph_mac(traversing_input.get(1)));
            }
            macs.get(traversing_input.get(0)).childs.add(new graph_mac(traversing_input.get(1)));
            macs.get(traversing_input.get(1)).parents.add(new graph_mac(traversing_input.get(0)));
        }
        ArrayList<Integer> order = new ArrayList<>();
        traverse(macs, visited, input.get(0).get(0), order);
        System.out.println(order);
    }

    public static void traverse(HashMap<Integer, graph_mac> macs, HashSet<Integer> visited, int key,
            ArrayList<Integer> answer) {
        if (visited.contains(key)) {
            return;
        }
        ArrayList<graph_mac> parents = macs.get(key).parents;
        for (graph_mac current : parents) {
            if (!visited.contains(current.data)) {
                traverse(macs, visited, current.data, answer);
            }
        }
        if (!visited.contains(key)) {
            answer.add(key);
            visited.add(key);
        }
        ArrayList<graph_mac> child = macs.get(key).childs;
        for (graph_mac current : child) {
            if (!visited.contains(current.data)) {
                traverse(macs, visited, current.data, answer);
            }
        }
    }
}
