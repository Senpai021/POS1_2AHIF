/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Klasse Motorrad
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public class Motorrad extends KFZ {
    private boolean beiwagen;

    public Motorrad(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen, int hoechstgeschwindigkeit, int leistung, float kilometerstand, float tankgroesse, boolean beiwagen) throws UngueltigerParameterException {
        super(fahrzeugnummer, leergewicht, zulaessigesGesamtgewicht, sitzplaetze, insassen, hoechstgeschwindigkeit, leistung, kilometerstand, tankgroesse);
        setBeiwagen(beiwagen);
    }

    @Override
    public void setSitzplaetze(int sitzplaetze) throws UngueltigerParameterException {
        if (sitzplaetze > 0 && sitzplaetze <= 2) // auch hier eine Einschränkung der Sitzplätze
        {
            super.setSitzplaetze(sitzplaetze);
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl von Sitzplätzen (" + sitzplaetze + ")");
        }
    }

    @SuppressWarnings("unused")
    public boolean getBeiwagen() {
        return beiwagen;
    }

    public void setBeiwagen(boolean beiwagen) {
        this.beiwagen = beiwagen;
    }

    //  berechneGewicht() wird unverändert von KFZ übernommen - geerbt

    @Override
    public String toString() {
        String s = super.toString();
        if (beiwagen) {
            s += ", mit Beiwagen";
        } else {
            s += ", ohne Beiwagen";
        }
        return s;
    }
}