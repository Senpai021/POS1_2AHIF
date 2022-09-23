/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.me;

public class Test {
    public static void main(String[] args) throws ConException {
        Fahrrad f = new Fahrrad(16, 1, 150, 1, 40);
        PersonenKraftWagen pkw = new PersonenKraftWagen(1200, 4, 1600, 3, 200, 90, 500000, ArtDesFahrzeugs.Cabrio);
        Motorrad m = new Motorrad(200, 2, 400, 2, 130, 45, 100000, false);
        LastKraftWagen lkw = new LastKraftWagen(5, 2, 12, 1, 140, 449, 300000, 12);

    }
}
