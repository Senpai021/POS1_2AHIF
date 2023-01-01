/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;
/*
 * Musterlösung zur Fuhrpark-Aufgabe - Comparator für die Fahrzeugnummer
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */

import java.util.Comparator;

public class VergleichFahrzeugnummer implements Comparator<Fahrzeug> {
    @Override
    public int compare(Fahrzeug f1, Fahrzeug f2) {
        return Integer.compare(f1.getFahrzeugnummer(), f2.getFahrzeugnummer());
    }
}