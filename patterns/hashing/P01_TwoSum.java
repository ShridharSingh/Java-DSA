package patterns.hashing;

import java.util.*;

/*
 * PROBLEM: Two Sum
 * Given an array of integers nums and an integer target, return the indices
 * of the two numbers that add up to target. Exactly one solution exists.
 * The same element can't be used twice. Return [-1, -1] if no pair exists.
 *
 * IDEA: (write in your own words once solved)
 */

public class P01_TwoSum {
    public static List<Integer> twoSum(List<Integer> nums, int target) {
        // your code here

        List<Integer> indecies = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);

            if (map.containsKey(complement)) {
                indecies.add(map.get(complement));
                indecies.add(i);
                return indecies;
            }

            map.put(nums.get(i), i);// key is number, value is index
        }

        if (indecies.isEmpty()) {
            indecies.add(-1);
            indecies.add(-1);
        }
        return indecies;
    }

    static void check(String name, List<Integer> got, List<Integer> expected) {
        boolean pass = got.equals(expected);
        System.out.println((pass ? "PASS " : "FAIL ") + name + " (got " + got + ", expected " + expected + ")");
    }

    public static void main(String[] args) {
        check("example", twoSum(Arrays.asList(2, 7, 11, 15), 9), Arrays.asList(0, 1));
        check("not neighbours", twoSum(Arrays.asList(2, 5, 7), 9), Arrays.asList(0, 2));
        check("pair at the end", twoSum(Arrays.asList(3, 2, 4), 6), Arrays.asList(1, 2));
        check("same value twice", twoSum(Arrays.asList(3, 3), 6), Arrays.asList(0, 1));
        check("no pair", twoSum(Arrays.asList(1, 2, 3, 4), 8), Arrays.asList(-1, -1));
        check("negatives", twoSum(Arrays.asList(-3, 4, 3, 90), 0), Arrays.asList(0, 2));
    }
}
