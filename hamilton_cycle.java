import java.util.*;
import java.io.*;

public class hamilton_cycle {
    public static class graph {
        int node;
        HashSet<graph> connects = new HashSet<>();

        public graph(int node) {
            this.node = node;
        }
    }

    public static int number_of_nodes;
    public static HashMap<Integer, graph> nodes = new HashMap<>();
    public static ArrayList<ArrayList<graph>> ans_path = new ArrayList<>();

    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        number_of_nodes = in.nextInt();
        int[][] matrix = new int[number_of_nodes][number_of_nodes];
        for (int i = 0; i < number_of_nodes; i++) {
            for (int j = 0; j < number_of_nodes; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < number_of_nodes; i++) {
            for (int j = 0; j < number_of_nodes; j++) {
                if (matrix[i][j] == 1) {
                    if (!nodes.containsKey(i)) {
                        nodes.put(i, new graph(i));
                    }
                    if (!nodes.containsKey(j)) {
                        nodes.put(j, new graph(j));
                    }
                    graph x = nodes.get(i);
                    graph y = nodes.get(j);
                    x.connects.add(nodes.get(j));
                    y.connects.add(nodes.get(i));
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        ArrayList<graph> visited = new ArrayList<>();
        iterate(nodes.get(0), visited, nodes.get(0));
        if (ans_path.size() == 0) {
            System.out.println("No Hamilton cycles");
            return;
        }
        for (int i = 0; i < ans_path.size(); i++) {
            for (int j = 0; j < ans_path.get(i).size(); j++) {
                System.out.print("->" + ans_path.get(i).get(j).node);
            }
            System.out.println();
        }
    }

    public static void iterate(graph current, ArrayList<graph> visited, graph head) {
        if (current.equals(head) && visited.size() == number_of_nodes) {
            ans_path.add(new ArrayList<graph>(visited));
            visited.add(current);
            return;
        }
        if (visited.contains(current)) {
            return;
        }
        ArrayList<graph> visited_copy = new ArrayList<>(visited);
        visited_copy.add(current);
        HashSet<graph> list = nodes.get(current.node).connects;
        for (graph hold : list) {
            iterate(hold, visited_copy, head);
        }
        return;
    }
}
