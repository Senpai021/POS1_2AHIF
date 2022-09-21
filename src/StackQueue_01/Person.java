/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package StackQueue_01;

import java.util.UUID;

public class Person {
@SuppressWarnings("unused")
    public UUID getFahrzeugID() {
        return fahrzeugID;
    }

    UUID fahrzeugID = UUID.randomUUID();

    private String name = "Paul";
    private int gebJahr = 1999;
    private boolean brille = true;

    public Person(String name, int gebJahr, boolean brille) {
        setName(name);
        setGebJahr(gebJahr);
        setBrille(brille);
    }


    @SuppressWarnings({"unused"})
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings({"unused"})
    public int getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(int gebJahr) {
        this.gebJahr = gebJahr;
    }

    @SuppressWarnings({"unused"})
    public boolean getBrille() {
        return brille;
    }

    public void setBrille(boolean brille) {
        this.brille = brille;
    }

    public int berechneAlter() {
        return 2021 - gebJahr;
    }

    @SuppressWarnings({"unused"})
    public int berechneAlter2(int aktuellesJahr) {
        return aktuellesJahr - gebJahr;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("GeburtsJahr: " + gebJahr);
        System.out.println("Alter: " + berechneAlter());
        System.out.println("Brillenträger: " + brille);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gebJahr=" + gebJahr +
                ", brille=" + brille +
                '}';
    }
}

