/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package StackQueue_01;

public class StackA {

    private static int pos;
    private final Person[] person;

    public StackA() {
        person = new Person[10];
    }

    public static void main(String[] args) {
        StackA stack = new StackA();
        Person person1 = new Person("", 0, false);

        System.out.println("Hier wird ein Name und ein Alter für die Person definiert, und ob sie eine Brille trägt!");
        String name = "Paul";
        person1.setName(name);

        int jahr = 2002;
        person1.setGebJahr(jahr);

        boolean brille = true;
        person1.setBrille(brille);

        stack.push(person1);
        stack.peek().printInfo();

        System.out.println("--------------------------");

        System.out.println("Jetzt entfernen wir die Person \n");
        stack.pop().printInfo();

        stack.printAllEllements();
    }

    public void push(Person perso) {
        if (pos > person.length - 1) {
            System.err.println("Array ist voll!");
        } else {
            person[pos] = perso;
            pos++;
        }
    }

    public Person pop() {
        if (pos == 0) {
            System.err.println("Array ist leer!");
        } else {
            Person entf = person[pos - 1];
            person[pos - 1] = null;
            pos--;
            return entf;
        }
        return null;
    }

    public Person peek() {
        if (pos == 0) {
            System.err.println("Array ist leer");
        } else {
            return person[pos - 1];
        }
        return null;
    }

    @SuppressWarnings("unused")
    public Person[] getPersonArr() {
        return person;
    }

    public void printAllEllements() {
        for (Person person : person) {
            if (person != null) {
                System.out.println(person);
            } else {
                break;
            }
        }
    }
}
