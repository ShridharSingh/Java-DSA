package datastructures.hashset;

// Import statement
import java.util.*;

// TRAP 1: a set has NO get() and NO index. You can only ask "is x in it?"
//         If you need extra info about each value (index, count), use a HashMap.
// TRAP 2: no order is kept. Don't rely on the printing order.

public class HashSetBasics {
    public static void main(String[] args) {
        // Declaration:
        // Set<Type> name = new HashSet<>();

        // CREATE: a set of Integers (unique values only)
        Set<Integer> seen = new HashSet<>();

        // add: put a value in. Returns true if it was new, false if already present
        seen.add(5);
        seen.add(3);
        seen.add(5); // add(5) will not succeed
        boolean addedAgain = seen.add(5); // add 5 will not succeed
        System.out.println("after add: " + seen);
        System.out.println("add 5 again returned: " + addedAgain);

        // contains: is this value in the set? (instant, O(1))
        System.out.println("contains 3: " + seen.contains(3));
        System.out.println("contains 9: " + seen.contains(9));

        // remove: take a value out. Returns true if it was there
        boolean removed = seen.remove(3);
        System.out.println("remove 3 returned: " + removed + ", set now: " + seen);

        // size / isEmpty
        System.out.println("size: " + seen.size());
        seen.add(19);
        System.out.println("size after add 19: " + seen.size());

        System.out.println("isEmpty: " + seen.isEmpty());

        // loop over every value (order is NOT guaranteed)
        seen.add(8);
        seen.add(1);

        for (int value : seen) {
            System.out.println("value: " + value);
        }

        // BUILD FROM AN ARRAY: duplicates dissapear automatically
        int[] nums = { 4, 4, 7, 7, 2 };
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }
        System.out.println("unique values: " + unique + ", how many: " + unique.size());

        // addAll: add everything from another set (union)
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Set<Integer> b = new HashSet<>();
        b.add(2);
        b.add(3);
        b.add(4);

        Set<Integer> union = new HashSet<>(a); // start as a copy of a
        union.addAll(b);
        System.out.println("union of a and b: " + union); // still removes duplicates

        // retailAll: keep only values that are ALSO in the other set (intersection)
        Set<Integer> common = new HashSet<>(a);
        common.retainAll(b);
        System.out.println("common to a and b: " + common);

        // clear: empty the set
        seen.clear();
        System.out.println("after clear: " + seen + ", isEmpty: " + seen.isEmpty());

        // FIND DUPLICATES INSIDE ONE ARRAY
        // add() returns false when value is already in the set
        int[] numbers = { 3, 1, 4, 1, 5, 3 };
        Set<Integer> checked = new HashSet<>(); // for every value seen so far
        Set<Integer> duplicates = new HashSet<>(); // for every value seen more than once

        for (int i = 0; i < numbers.length; i++) {
            boolean isNew = checked.add(numbers[i]); // add() adds numbers[i] and returns true, if i already in set
                                                     // returns false
            if (!isNew) {
                duplicates.add(numbers[i]); // add() returned false -> "already here"
            }
        }
        System.out.println("duplicates: " + duplicates);

        // Quick check -> yes/no: if the set is smaller than the array, something
        // repeated
        Set<Integer> quickCheck = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            quickCheck.add(numbers[i]);
        }
        boolean hasDuplicate = quickCheck.size() < numbers.length;
        System.out.println("hasDuplicate: " + hasDuplicate);

    }
}
