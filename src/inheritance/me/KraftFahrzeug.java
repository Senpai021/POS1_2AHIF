/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.me;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KraftFahrzeug extends Fahrzeug{

    private int hoechstGeschwindigkeit;
    private long leistung;
    private long kilometerstand;

    public KraftFahrzeug(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen, int hoechstGeschwindigkeit, long leistung, long kilometerstand) {
        super(leerGewicht, maxSitzplatz, zuGesamtGewicht, insassen);
        setHoechstGeschwindigkeit(hoechstGeschwindigkeit);
        setLeistung(leistung);
        setKilometerstand(kilometerstand);
    }

    public long berechneGewicht() {
        return super.getLeerGewicht() + super.getInsassen() * 80L;
    }

}
