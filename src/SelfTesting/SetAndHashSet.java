/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package SelfTesting;

import java.util.*;
import java.util.function.Consumer;

public class SetAndHashSet {
    public static void main(String[] args) {
        // HashSet uses HashTable for the implementation
        //Set<String> names = new TreeSet<>();
        Set<String> names = new HashSet<>();
        names.add("Walter");
        names.add("Jesse");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");

        /* String x;
        x = (names.contains("Walter")) ? "Walter" : "";

        System.out.println(x);

        names.clear();*/

        System.out.println(names);

        //A few ways to print out a set

        for (String name : names) {
            System.out.println(name);
        }

        names.forEach((Consumer<? super String>) System.out::println);

        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);
        System.out.println(numberList);

        Set<Integer> numberSet = new TreeSet<>(numberList);
        System.out.println(numberSet);
    }
}
