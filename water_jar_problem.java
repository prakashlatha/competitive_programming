import java.util.*;

class tumblers {
    int left_tumbler;
    int right_tumbler;

    tumblers(int left_tumbler, int right_tumbler) {
        this.left_tumbler = left_tumbler;
        this.right_tumbler = right_tumbler;
    }
}

public class water_jar_problem {

    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("maximum capacity of jar 1      ->    ");
        int tumbler1 = in.nextInt();
        System.out.print("maximum capacity of jar 2   ->     ");
        int tumbler2 = in.nextInt();
        System.out.print("target amount    ->     ");
        int target = in.nextInt();
        Queue<tumblers> tumbler_list = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        tumbler_list.add(new tumblers(0, 0));
        boolean path_found = false;
        while (!tumbler_list.isEmpty()) {
            tumblers current_tumblers = tumbler_list.remove();
            int left_tumbler = current_tumblers.left_tumbler;
            int right_tumbler = current_tumblers.right_tumbler;
            tumblers empty_and_pour_left = new tumblers(left_tumbler, 0);
            tumblers empty_and_pour_right = new tumblers(0, right_tumbler);
            String tumbler_string_left = empty_and_pour_left.left_tumbler + " " + empty_and_pour_left.right_tumbler;
            String tumbler_string_right = empty_and_pour_right.left_tumbler + " " + empty_and_pour_right.right_tumbler;
            if (empty_and_pour_left.left_tumbler == target || empty_and_pour_left.right_tumbler == target
                    || empty_and_pour_right.left_tumbler == target || empty_and_pour_right.right_tumbler == target) {

                String answer = (empty_and_pour_left.left_tumbler == target
                        || empty_and_pour_left.right_tumbler == target) ? (tumbler_string_left)
                                : (tumbler_string_right);
                visited.add(answer);
                path_found = true;
                break;
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(empty_and_pour_left);
                visited.add(tumbler_string_left);
            }
            if (!visited.contains(tumbler_string_right)) {
                tumbler_list.add(empty_and_pour_right);
                visited.add(tumbler_string_right);
            }
            tumblers filling_tumblers_left = new tumblers(tumbler1, right_tumbler);
            tumblers filling_tumblers_right = new tumblers(left_tumbler, tumbler2);
            tumbler_string_left = filling_tumblers_left.left_tumbler + " " + filling_tumblers_left.right_tumbler;
            tumbler_string_right = filling_tumblers_right.left_tumbler + " " + filling_tumblers_right.right_tumbler;
            if (filling_tumblers_left.left_tumbler == target || filling_tumblers_left.right_tumbler == target
                    || filling_tumblers_right.left_tumbler == target
                    || filling_tumblers_right.right_tumbler == target) {

                String answer = (filling_tumblers_left.left_tumbler == target
                        || filling_tumblers_left.right_tumbler == target) ? (tumbler_string_left)
                                : (tumbler_string_right);
                visited.add(answer);
                path_found = true;
                break;
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(filling_tumblers_left);
                visited.add(tumbler_string_left);
            }
            if (!visited.contains(tumbler_string_right)) {
                tumbler_list.add(filling_tumblers_right);
                visited.add(tumbler_string_right);
            }
            tumblers empty_one_fill_another_left = new tumblers(filler_fully(left_tumbler, tumbler1, right_tumbler), 0);
            tumblers empty_one_fill_another_right = new tumblers(0,
                    filler_fully(right_tumbler, tumbler2, left_tumbler));
            tumbler_string_left = empty_one_fill_another_left.left_tumbler + " "
                    + empty_one_fill_another_left.right_tumbler;
            tumbler_string_right = empty_one_fill_another_right.left_tumbler + " "
                    + empty_one_fill_another_right.right_tumbler;
            if (empty_one_fill_another_left.left_tumbler == target
                    || empty_one_fill_another_left.right_tumbler == target
                    || empty_one_fill_another_right.left_tumbler == target
                    || empty_one_fill_another_right.right_tumbler == target) {

                String answer = (empty_one_fill_another_left.left_tumbler == target
                        || empty_one_fill_another_left.right_tumbler == target) ? (tumbler_string_left)
                                : (tumbler_string_right);
                visited.add(answer);
                path_found = true;
                break;
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(empty_one_fill_another_left);
                visited.add(tumbler_string_left);
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(empty_one_fill_another_right);
                visited.add(tumbler_string_right);
            }
            int[] over_flow_tracker_left_temp = filler_fully_with_out_overflow(left_tumbler, tumbler1, right_tumbler);
            int[] over_flow_tracker_right_temp = filler_fully_with_out_overflow(right_tumbler, tumbler2, left_tumbler);
            tumblers over_flow_tracker_left = new tumblers(over_flow_tracker_left_temp[0],
                    over_flow_tracker_left_temp[1]);
            tumblers over_flow_tracker_right = new tumblers(over_flow_tracker_right_temp[1],
                    over_flow_tracker_right_temp[0]);
            tumbler_string_left = over_flow_tracker_left.left_tumbler + " " + over_flow_tracker_left.right_tumbler;
            tumbler_string_right = over_flow_tracker_right.left_tumbler + " " + over_flow_tracker_right.right_tumbler;
            if (over_flow_tracker_left.left_tumbler == target || over_flow_tracker_left.right_tumbler == target
                    || over_flow_tracker_right.left_tumbler == target
                    || over_flow_tracker_right.right_tumbler == target) {

                String answer = (over_flow_tracker_left.left_tumbler == target
                        || over_flow_tracker_left.right_tumbler == target) ? (tumbler_string_left)
                                : (tumbler_string_right);
                visited.add(answer);
                path_found = true;
                break;
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(over_flow_tracker_left);
                visited.add(tumbler_string_left);
            }
            if (!visited.contains(tumbler_string_left)) {
                tumbler_list.add(over_flow_tracker_right);
                visited.add(tumbler_string_right);
            }
            tumblers catalag = new tumblers(tumbler1, tumbler2);
            String catalag_string = catalag.left_tumbler + " " + catalag.right_tumbler;
            if (catalag.left_tumbler == target || catalag.right_tumbler == target) {
                path_found = true;
                visited.add(catalag_string);
                break;
            }
            if (!visited.contains(catalag_string)) {
                tumbler_list.add(catalag);
                visited.add(catalag_string);
            }

        }
        if (path_found) {
            System.out.println("found path ---->     " + visited);
        } else {
            System.out.println("cant achieve the formed liter of water in the jug");
        }
    }

    public static int[] filler_fully_with_out_overflow(int amount_in_our_jar, int maximum_level,
            int amount_in_other_jar) {
        int[] returns = new int[2];
        if (amount_in_our_jar == 0 && maximum_level >= amount_in_other_jar) {
            returns[0] = amount_in_other_jar;
            returns[1] = 0;
        } else if (amount_in_our_jar == 0 && maximum_level < amount_in_other_jar) {
            returns[0] = maximum_level;
            returns[1] = amount_in_other_jar - maximum_level;
        } else if (amount_in_our_jar > 0 && maximum_level >= amount_in_other_jar + amount_in_our_jar) {
            returns[0] = amount_in_other_jar + amount_in_our_jar;
            returns[1] = 0;
        } else if (amount_in_our_jar > 0 && maximum_level < amount_in_other_jar + amount_in_our_jar) {
            int spaces_available = maximum_level - amount_in_our_jar;
            returns[0] = maximum_level;
            returns[1] = amount_in_other_jar - spaces_available;
        } else {
            returns[0] = 0;
            returns[1] = 0;
        }

        return returns;
    }

    public static int filler_fully(int amount_in_our_jar, int maximum_level, int amount_in_other_jar) {
        if (amount_in_other_jar >= maximum_level || amount_in_our_jar == maximum_level
                || amount_in_our_jar + amount_in_other_jar > maximum_level) {
            return maximum_level;
        } else {
            return amount_in_our_jar + amount_in_other_jar;
        }
    }
}
