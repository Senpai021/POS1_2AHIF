/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - eigene Exception-Klasse
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public class UngueltigerParameterException extends Exception {
    public UngueltigerParameterException(String message) {
        super(message);
    }
}