/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab03.tests;

import school.homework.lab03.Player;
import school.homework.lab03.Team;

public class test {
    public static void main(String[] args) {
        Team t = new Team();

        t.put(new Player("John", 5, 10));
        t.put(new Player("Gabriel", 15, 12));
        t.put(new Player("Paul", 12, 6));
        t.put(new Player("Walter", 7, 4));
        t.put(new Player("Björn", 4, 13));
        t.put(new Player("Frederik", 6, 14));
        t.put(new Player("Fritz", 19, 3));
        t.put(new Player("Chris", 25, 1));
        t.put(new Player("Nico", 22, 2));
        t.put(new Player("Pascal", 18, 7));


        t.print();


        System.out.println(t.sumScores());

        System.out.println(t.averageScore());

        System.out.println(t.get("John").toString());

        System.out.println(t.remove(14).toString() + " wurde entfernt!");

        System.out.println(t.minNumber().toString());

        System.out.println("Die größe des Teams ist zur Zeit: " + t.size() + " Spieler");

        System.out.println(t.maxScore().toString() + " hat den höchsten Score!" + "\n");

        System.out.println("Hier wird das Alphabetisch ausgegeben!");

        t.printSortedbyName();

        System.out.println("\nHier wird das Team nach ihrer Nummer sortiert!");

        t.printSortedbyNumber();

        System.out.println("\n");

        System.out.println(t.findPlayersWithName("Nico").toString());
        System.out.println(t.findPlayersWithName("John").toString());

        System.out.println("\n");

        System.out.println(t.findPlayersWithScore(5, 10));
    }
}
