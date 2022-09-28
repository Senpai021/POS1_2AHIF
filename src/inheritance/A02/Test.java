/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.A02;

public class Test {
    public static void main(String[] args) throws ConException {
        Fahrrad f = new Fahrrad(17, 1, 150, 1, 50);
        PersonenKraftWagen pkw = new PersonenKraftWagen(1200, 4, 1600, 3, 200, 90, 500000, ArtDesFahrzeugs.Cabrio);
        Motorrad m = new Motorrad(200, 2, 400, 2, 130, 45, 100000, false);
        LastKraftWagen lkw = new LastKraftWagen(5, 2, 12, 1, 140, 449, 300000, 12);

        System.out.println(f.printInfo() + " ignore fahrzeugNummer");
        System.out.println(pkw.printInfo() + " ignore fahrzeugNummer");
        System.out.println(m.printInfo() + " ignore fahrzeugNummer");
        System.out.println(lkw.printInfo() + " ignore fahrzeugNummer LKW");
    }
}
