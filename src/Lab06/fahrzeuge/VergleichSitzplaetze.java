/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;
/*
 * Musterlösung zur Fuhrpark-Aufgabe - Comparator für die Sitzplätze
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */

import java.util.Comparator;

public class VergleichSitzplaetze implements Comparator<Fahrzeug> {
    @Override
    public int compare(Fahrzeug f1, Fahrzeug f2) {
        return Integer.compare(f1.getSitzplaetze(), f2.getSitzplaetze());
    }
}