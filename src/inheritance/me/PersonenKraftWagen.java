/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.me;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonenKraftWagen extends KraftFahrzeug{
    ArtDesFahrzeugs art;

    public PersonenKraftWagen(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen, int hoechstGeschwindigkeit, long leistung, long kilometerstand, ArtDesFahrzeugs art) throws ConException {
        super(leerGewicht, checkMaxSitzPlatz(maxSitzplatz), zuGesamtGewicht, insassen, hoechstGeschwindigkeit, leistung, kilometerstand);
        setArt(art);
    }

    private static int checkMaxSitzPlatz(int maxSitzplatz) throws ConException {
        if (maxSitzplatz <= 4 && maxSitzplatz >= 1){
            return maxSitzplatz;
        } else {
            throw new ConException("maxSitzPlatz must be bewtween 5 and 0");
        }
    }
}
