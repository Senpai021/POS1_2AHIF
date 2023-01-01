/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Klasse PKW (Personenkraftfahrzeug)
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public class PKW extends KFZ {
    private String art;

    public PKW(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen, int hoechstgeschwindigkeit, int leistung, float kilometerstand, float tankgroesse, String art) throws UngueltigerParameterException {
        super(fahrzeugnummer, leergewicht, zulaessigesGesamtgewicht, sitzplaetze, insassen, hoechstgeschwindigkeit, leistung, kilometerstand, tankgroesse);
        setArt(art);
    }

    @Override
    public void setSitzplaetze(int sitzplaetze) throws UngueltigerParameterException {
        if (sitzplaetze > 0 && sitzplaetze <= 9) // auch hier eine Einschränkung der Sitzplätze
        {
            super.setSitzplaetze(sitzplaetze);
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl von Sitzplätzen (" + sitzplaetze + ")");
        }
    }

    @SuppressWarnings("unused")
    public String getArt() {
        return art;
    }

    public void setArt(String art) throws UngueltigerParameterException {
        if (art != null && !art.isEmpty()) {
            this.art = art;
        } else {
            throw new UngueltigerParameterException("Art muss angegeben werden (" + art + ")");
        }
    }

    //  berechneGewicht() wird unverändert von KFZ übernommen - geerbt

    @Override
    public String toString() {
        return super.toString() + ", Art=" + art;
    }
}