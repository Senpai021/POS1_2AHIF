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

    public KraftFahrzeug(int hoechstGeschwindigkeit, long leistung, long kilometerstand) {
        super(1000L, 4, 2000, 4);
        setHoechstGeschwindigkeit(hoechstGeschwindigkeit);
        setLeistung(leistung);
    }


}
