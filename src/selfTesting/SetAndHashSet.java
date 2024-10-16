/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package selfTesting;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

public class SetAndHashSet {
    public static void main(String[] args) {
        /*
            Tree-set uses Treemap for the implementation
            Set<String> names = new TreeSet<>();
         */
        //HashSet uses HashTable for the implementation
        TreeMap<LocalDate, Integer> reservations = new TreeMap<>();

        reservations.put(LocalDate.now(), 5);
        reservations.put(LocalDate.of(2022, 12, 10), 4);
        System.out.println(reservations);

        Set<String> names = new TreeSet<>(Arrays.asList("Walter", "Jesse", "Skyler", "Mike", "Saul"));
        names.add("Walter");

        String x;
        x = (names.contains("Walter")) ? "Walter" : "";

        System.out.println(x);

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
        int k = 1;
        for (int i = 0; i < 5; i++) {
            numberList.add(k);
            if (i < 2) {
                k++;
            } else {
                k--;
            }
        }
        System.out.println(numberList);

        Set<Integer> numberSet = new TreeSet<>(numberList);
        System.out.println(numberSet);
    }
}
