/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.A02.a;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
public abstract class Fahrzeug {
    private UUID fahrzeugNummer;
    @Setter
    private long leerGewicht;
    @Setter
    private int maxSitzplatz;
    @Setter
    private long zuGesamtGewicht;
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
        return getClass().getSimpleName() + "={fahrzeugNummer=" + fahrzeugNummer + ", leerGewicht=" + leerGewicht + ", maxSitzplatz=" + maxSitzplatz + ", zuGesamtGewicht=" + zuGesamtGewicht + ", insassen=" + insassen + ", aktuelleGewicht=" + berechneGewicht() + "}";
    }

    public String printInfo() {
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return getFahrzeugNummer().equals(fahrzeug.getFahrzeugNummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFahrzeugNummer());
    }

}
