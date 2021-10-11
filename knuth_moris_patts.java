import java.lang.reflect.Array;
import java.text.NumberFormat.Style;
import java.util.*;

public class knuth_moris_patts {
    public static void main(String argv[]) {
        Scanner in = new Scanner(System.in);
        String str1 = "abcdabcaabcabcdebcdeabcd";
        String str2 = "abcabcde";
        int[] pattern = new int[str2.length()];
        Arrays.fill(pattern, -1);
        pattern = patternfinder(pattern, str2);
        for (int i = 0; i < pattern.length; i++) {
            System.out.print(pattern[i] + " ");
        }
        if (doesconatin(str1, str2, pattern)) {
            System.out.println("contains ");
        } else {
            System.out.println("Not contains ");
        }

    }

    public static boolean doesconatin(String str1, String str2, int[] pattern) {
        int i = 0;
        int j = 0;
        while ((i + str1.length() - j) < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                if (j == str2.length() - 1) {
                    return true;
                }
                i++;
                j++;
            } else if (j > 0) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    public static int[] patternfinder(int[] pattern, String str2) {
        int i = 1;
        int j = 0;
        while (i < str2.length()) {
            if (str2.charAt(i) == str2.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }
}

\
