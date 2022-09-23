/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.me;

import lombok.Getter;
import lombok.Setter;

public class Fahrrad extends Fahrzeug {
    @Setter
    @Getter
    private int rahmenhoehe; // zoll

    public Fahrrad(long leerGewicht, int maxSitzplatz, long zuGesamtGewicht, int insassen, int rahmenhoehe) throws ConException {
        super(checkLG(leerGewicht), checkMaxSitzPlatz(maxSitzplatz), checkzuGesamtGewicht(zuGesamtGewicht), checkInsassen(insassen));
        setRahmenhoehe(checkRahmenhoehe(rahmenhoehe));
    }

    private int checkRahmenhoehe(int rahmenh) throws ConException {
        if (rahmenh <= 52 && rahmenh >= 48) {
            return rahmenh;
        } else {
            throw new ConException("rahmenhoehe must be below 53 or above 47");
        }
    }

    private static long checkzuGesamtGewicht(long gGewicht) throws ConException {
        if (gGewicht > 0 && gGewicht <= 160) {
            return gGewicht;
        } else {
            throw new ConException("gGweicht must be above 0 and must be either equal or below 160");
        }
    }

    private static int checkMaxSitzPlatz(int platz) throws ConException {
        if (platz < 5 && platz > 1) {
            return platz;
        } else {
            throw new ConException("maxSitzplatz must be below 5 and above 1");
        }
    }

    private static long checkLG(long lG) throws ConException {
        if (lG < 19 && lG > 16) {
            return lG;
        } else {
            throw new ConException("leerGewicht must be below 19 and above 16");
        }
    }

    private static int checkInsassen(int insassen) throws ConException {
        if (insassen < 3 && insassen > 0) {
            return insassen;
        } else {
            throw new ConException("insassen must be below 2 and above 0");
        }
    }

    public long zollBerechnen(int rahmenh) {
        return (long) (rahmenh / 2.54);
    }

    @Override
    public String toString() {
        return super.toString() + ", rahmenhoehe in cm=" + rahmenhoehe + ", rahmenhoehe in Zoll=" + zollBerechnen(rahmenhoehe);
    }

    public String printInfo() {
        return toString();
    }
}
