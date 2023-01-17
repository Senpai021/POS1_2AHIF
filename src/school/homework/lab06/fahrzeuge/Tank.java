/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Interface Tank
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
@SuppressWarnings("unused")
public interface Tank {
    // die vorgeschriebenen Methoden:
    float getTankgroesse();

    float getTankinhalt();

    float tanken();
}
