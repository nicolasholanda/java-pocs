package com.github.nicolasholanda.guava;

import com.google.common.collect.*;

public class GuavaCollections {

    static void execute() {
        ListMultimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruits", "apple");
        multimap.put("fruits", "banana");
        multimap.put("veggies", "carrot");
        System.out.println("Multimap: " + multimap);
        System.out.println("Multimap fruits: " + multimap.get("fruits"));

        Multiset<String> multiset = HashMultiset.create();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("banana");
        System.out.println("Multiset: " + multiset);
        System.out.println("Apple count: " + multiset.count("apple"));

        BiMap<String, Integer> bimap = HashBiMap.create();
        bimap.put("one", 1);
        bimap.put("two", 2);
        bimap.put("three", 3);
        System.out.println("BiMap: " + bimap);
        System.out.println("Inverse BiMap: " + bimap.inverse());

        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("Alice", "Math", 95);
        table.put("Alice", "Science", 88);
        table.put("Bob", "Math", 72);
        System.out.println("Table: " + table);
        System.out.println("Alice Math: " + table.get("Alice", "Math"));
        System.out.println("Math column: " + table.column("Math"));

        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c");
        System.out.println("ImmutableList: " + immutableList);

        ImmutableMap<String, Integer> immutableMap = ImmutableMap.of("x", 1, "y", 2);
        System.out.println("ImmutableMap: " + immutableMap);

        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1, 2, 3, 2, 1);
        System.out.println("ImmutableSet (no dupes): " + immutableSet);
    }
}

