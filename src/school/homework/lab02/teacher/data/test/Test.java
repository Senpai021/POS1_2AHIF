/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab02.teacher.data.test;

import school.homework.lab02.teacher.data.Person;
import school.homework.lab02.teacher.data.Schueler;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Person p = new Person("Luka", 2002);
        Schueler s = new Schueler("Luka", 2002, 12345);
        System.out.println(p);

        Person x;
        x = s;
        if (x instanceof Schueler) {
            System.out.println("Schuelernummer: " + ((Schueler) x).getSchuelerNummer());
        }

        x.printInfo();

        Scanner sc = new Scanner(System.in);
        System.out.println("Eingabe Zahl: ");
        System.out.println("Zahl: " + sc.nextFloat());
        System.out.println("Eingabe Text");
        System.out.println("Text: >" + sc.next() + "<");


    }

}
