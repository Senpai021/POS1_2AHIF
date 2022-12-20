/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package SelfTesting;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

public class SetAndHashSet {
    public static void main(String[] args) {
        /*
            Treeset uses Treemap for the implamentation
            Set<String> names = new TreeSet<>();
         */
        //HashSet uses HashTable for the implementation
        Set<String> names = new TreeSet<>();
        Map<LocalDate, Integer> reservierungen = new TreeMap<>();

        reservierungen.put(LocalDate.now(), 5);
        reservierungen.put(LocalDate.of(2022, 12, 10), 4);
        System.out.println(reservierungen);

        names.add("Walter");
        names.add("Jesse");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");
        names.add("Walter");

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
        while (true) {
            if (!namesIterator.hasNext()) break;
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
