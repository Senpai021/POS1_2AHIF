/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab02.A02.a;

import lombok.Getter;
import lombok.Setter;


public class Motorrad extends KraftFahrzeug {
    @Getter
    @Setter
    private static boolean beiwagen;

    public Motorrad(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen, int hoechstGeschwindigkeit, long leistung, long kilometerstand, boolean beiwagen) throws ConException {
        super(leerGewicht, checkMaxSitzPlatz(maxSitzplatz), zuGesamtGewicht, checkInsassen(insassen), hoechstGeschwindigkeit, leistung, kilometerstand);
        setBeiwagen(beiwagen);
    }

    private static int checkMaxSitzPlatz(int maxSitzplatz) throws ConException {
        if (maxSitzplatz < 4 && maxSitzplatz >= 1) {
            return maxSitzplatz;
        } else {
            throw new ConException("maxSitzplatz must be between 4 or 1");
        }
    }

    private static int checkInsassen(int insassen) throws ConException {
        if (beiwagen) {
            if (insassen < 4 && insassen > 0) {
                return insassen;
            } else {
                throw new ConException("insassen must be between 4 and 1 ");
            }
        } else if (insassen < 3 && insassen > 0) {
            return insassen;
        } else {
            throw new ConException("There can only be two on the bike!");
        }
    }
}
