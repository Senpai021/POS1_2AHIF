/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.me;

import lombok.Getter;
import lombok.Setter;
//import org.jetbrains.annotations.Nullable;

import java.util.UUID;


public abstract class Fahrzeug {
    @Getter
    private UUID fahrzeugNummer;
    @Getter
    @Setter
    private long leerGewicht;
    @Getter
    @Setter
    private int maxSitzplatz;
    @Getter
    @Setter
    private long zuGesamtGewicht;
    @Getter
    @Setter
    private int insassen;

    public Fahrzeug(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen) {
        setFahrzeugNummer();
        setLeerGewicht(leerGewicht);
        setMaxSitzplatz(maxSitzplatz);
        setZuGesamtGewicht(zuGesamtGewicht);
        setInsassen(insassen);
    }

    public void setFahrzeugNummer() {
        this.fahrzeugNummer = UUID.randomUUID();
    }

    public long berechneGewicht() {
        return leerGewicht + insassen * 80L;
    }

    @Override
    public String toString() {
        return "Fahrzeug: " +
                "fahrzeugNummer=" + fahrzeugNummer +
                ", leerGewicht=" + leerGewicht +
                ", maxSitzplatz=" + maxSitzplatz +
                ", zuGesamtGewicht=" + zuGesamtGewicht +
                ", insassen=" + insassen +
                ", aktuelleGewicht=" + berechneGewicht();
    }

    public String printInfo() {
        return toString();
    }

    /*public static void main(String[] args) {
        Fahrzeug f = new Fahrzeug(1000L, 4, 1500L, 4);
        f.printInfo();
    }*/

}
