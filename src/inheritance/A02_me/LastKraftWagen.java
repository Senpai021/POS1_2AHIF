/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.A02_me;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LastKraftWagen extends KraftFahrzeug {
    private long ladeMenge; // in Tonnen

    public LastKraftWagen(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen, int hoechstGeschwindigkeit, long leistung, long kilometerstand, long ladeMenge) throws ConException {
        super(leerGewicht, maxSitzplatz, zuGesamtGewicht, insassen, hoechstGeschwindigkeit, leistung, kilometerstand);
        setLadeMenge(checkLadeMenge(ladeMenge));
    }

    private long checkLadeMenge(long ladeMenge) throws ConException {
        if(ladeMenge <= 40 && ladeMenge >= 0){
            if(ladeMenge == 0) return ladeMenge;
            return ladeMenge;
        } else {
            throw new ConException("ladeMenge must be between 40 and 0 tons");
        }
    }

}
