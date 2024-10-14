/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab01;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Person {

    private String name = "Paul";
    private int gebJahr = 1999;
    private boolean brille = true;

    public Person(String name, int gebJahr, boolean brille) {
        setName(name);
        setGebJahr(gebJahr);
        setBrille(brille);
    }

    public int berechneAlter() {
        return LocalDate.now().getYear() - gebJahr;
    }
    
    public int berechneAlterMitJahr(int aktuellesJahr) {
        return aktuellesJahr - gebJahr;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Geburtsjahr: " + gebJahr);
        System.out.println("Alter: " + berechneAlter());
        System.out.println("Brillenträger: " + brille);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{")
                .append("name='").append(name).append('\'')
                .append(", gebJahr=").append(gebJahr)
                .append(", brille=").append(brille)
                .append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Person p = new Person("Paul", 1999, true);
        p.printInfo();
        System.out.println(p.berechneAlter());
        System.out.println(p.berechneAlterMitJahr(2024));
    }
}

