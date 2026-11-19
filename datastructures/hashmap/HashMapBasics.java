package datastructures.hashmap;

//Import statement
import java.util.*;

public class HashMapBasics {
    public static void main(String[] args) {

        // CREATE: key = name (String), value = age (Integer)
        Map<String, Integer> ages = new HashMap<>();

        // put: add a pair (or replace the value of k)
        ages.put("Sam", 25);
        ages.put("Lee", 30);
        ages.put("Sam", 26); // replaces existing entry for Sam and updates age

        System.out.println("after put: " + ages);

        // get: value for a key (null if missing)
        System.out.println("get Sam: " + ages.get("Sam"));
        System.out.println("get Zoe: " + ages.get("Zoe"));

        // TRAP: int x = ages.get("Nobody"); -> crashes (NullPointerException)
        // get() returns null for a missing key, and null can't go into an int.
        // Use getOrDefault, or check containsKey first.

        // getOrDefault: value for a key, or a fallback if missing
        System.out.println("getOrDefault Zoe: " + ages.getOrDefault("Zoe", 24));
        System.out.println("getOrDefault Martin: " + ages.getOrDefault("Martin", 0));

        // containsKey: is this key in the map?
        System.out.println("containsKey Lee: " + ages.containsKey("Lee"));
        System.out.println("containsKey Mary: " + ages.containsKey("Mary"));

        // containsValue: is the value anywhere in the map? (slow: checks every pair)
        System.out.println("containsValue 30: " + ages.containsValue(30));
        System.out.println("containsValue 8: " + ages.containsValue(8));

        // putIfAbsent: add only if the key is NOT already there
        ages.putIfAbsent("Lee", 99); // does not change Lee's age
        ages.putIfAbsent("Ann", 40);
        System.out.println("after putIfAbsent: " + ages);

        // replace: change the value only if the key already exists
        ages.replace("Ann", 41);
        ages.replace("Zoe", 27); // Zoe isnt part of Map
        System.out.println("after replace: " + ages);

        // size / isEmpty
        System.out.println("size: " + ages.size());
        ages.put("Zoe", 27);
        System.out.println("size after Zoe: " + ages.size());
        System.out.println("isEmpty: " + ages.isEmpty());

        // keySet: loop over every key
        for (String name : ages.keySet()) {
            System.out.println("key: " + name);
        }

        // values: loop over every value
        for (int age : ages.values()) {
            System.out.println("value: " + age);
        }

        // entrySet: loop over every key AND value together
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue());
        }

        // remove: delete a key and its value
        ages.remove("Zoe");
        System.out.println("after remove: " + ages);

        // COUNTING (most common use): add 1 to a key's count
        Map<Character, Integer> counts = new HashMap<>();
        String word = "banana";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int current = counts.getOrDefault(c, 0);
            counts.put(c, current + 1);
        }
        System.out.println("letter counts: " + counts);

        // clear: empty the whole map
        ages.clear();
        System.out.println("after clear: " + ages + ", isEmpty: " + ages.isEmpty());

    }
}