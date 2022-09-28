/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.A02.a.Test;

import inheritance.A02.a.*;
import inheritance.A02.b.Fuhrpark;
import inheritance.A02.b.containException;

public class Test {
    public static void main(String[] args) {
        try {
            Fahrrad f = new Fahrrad(17, 1, 150, 1, 50);
            PersonenKraftWagen pkw = new PersonenKraftWagen(1200, 4, 1600, 3, 200, 90, 500000, ArtDesFahrzeugs.Cabrio);
            Motorrad m = new Motorrad(200, 2, 400, 2, 130, 45, 100000, false);
            LastKraftWagen lkw = new LastKraftWagen(5, 2, 12, 1, 140, 449, 300000, 12);


            System.out.println(f.printInfo());
            System.out.println(pkw.printInfo());
            System.out.println(m.printInfo());
            System.out.println(lkw.printInfo());

            Fuhrpark fp = new Fuhrpark();
            try {
                fp.hinzufuegen(f);
                try {
                    fp.ausgabeFahrzeuge(false);
                } catch (AssertionError ae) {
                    System.out.println(ae.getMessage());
                }
                fp.hinzufuegen(lkw);
                try {
                    fp.ausgabeFahrzeuge(true);
                } catch (AssertionError ae) {
                    System.out.println(ae.getMessage());
                }
                if (fp.entfernen(lkw.getFahrzeugNummer())) {
                    fp.ausgabeFahrzeuge(false);
                }

                System.out.println(fp.clear());

                fp.hinzufuegen(f);
                fp.hinzufuegen(pkw);
                fp.hinzufuegen(m);
                fp.hinzufuegen(lkw);

                try {
                    fp.ausgabeFahrzeuge(false);
                } catch (AssertionError ae){
                    System.out.println(ae.getMessage());
                }

                System.out.println(fp.sucheFreiesFahrzeug(1));
            } catch (containException ce) {
                System.out.println(ce.getMessage());
            }
        } catch (ConException Ce) {
            System.out.println(Ce.getMessage());
        }

    }
}
