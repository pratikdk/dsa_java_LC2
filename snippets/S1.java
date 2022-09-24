package snippets;

import java.util.Arrays;

public class S1 {
    public static void main(String[] args) {
        int[] s = {1};
        int x = Arrays.binarySearch(s, 2);
        System.out.println("index is " + x);
    }
}
