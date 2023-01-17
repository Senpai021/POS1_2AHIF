/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Klasse LKW (Lastkraftwagen)
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
@SuppressWarnings("unused")
public class LKW extends KFZ {
    private float lademenge;
    private float maximaleLademenge; // (damit es kompatibel bleibt in kg!)

    public LKW(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen, int hoechstgeschwindigkeit, int leistung, float kilometerstand, float tankgroesse, float lademenge, float maximaleLademenge) throws UngueltigerParameterException {
        super(fahrzeugnummer, leergewicht, zulaessigesGesamtgewicht, sitzplaetze, insassen, hoechstgeschwindigkeit, leistung, kilometerstand, tankgroesse);
        setMaximaleLademenge(maximaleLademenge); // zuerst die Grenze festlegen,
        setLademenge(lademenge);                 // dann den tatsächlichen Wert setzen
    }

    @Override
    public void setSitzplaetze(int sitzplaetze) throws UngueltigerParameterException {
        if ((sitzplaetze > 0 && sitzplaetze <= 3) || sitzplaetze == 5)  // auch hier eine Einschränkung der Sitzplätze
        {
            super.setSitzplaetze(sitzplaetze);
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl an Sitzplätzen (" + sitzplaetze + ")");
        }
    }

    public float getLademenge() {
        return lademenge;
    }

    public void setLademenge(float lademenge) throws UngueltigerParameterException {
        if (lademenge > 0) {
            this.lademenge = lademenge;
        } else {
            throw new UngueltigerParameterException("Fehler bei lademenge! (" + lademenge + ")");
        }
    }

    public float getMaximaleLademenge() {
        return maximaleLademenge;
    }

    // ev. private deklarieren, falls die maximale Lademenge später nicht mehr veränderbar sein soll
    public void setMaximaleLademenge(float maximaleLademenge) throws UngueltigerParameterException {
        if (maximaleLademenge > lademenge) {
            this.maximaleLademenge = maximaleLademenge;
        } else {
            throw new UngueltigerParameterException("Fehler bei maximaleLademenge!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Lademenge=" + lademenge + "kg, max.Lademenge= " + maximaleLademenge + "t";
    }

    @Override
    public float berechneGewicht() {
        return super.berechneGewicht() + lademenge;
        // bzw. returm getLeergewicht()+(getInsassen()*80)+lademenge;
    }
}