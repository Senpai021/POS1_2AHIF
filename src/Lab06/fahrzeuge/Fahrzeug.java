/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Basisklasse Fahrzeug
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public abstract class Fahrzeug /* implements Comparable<Fahrzeug> */ {
    private int fahrzeugnummer;
    private float leergewicht;
    private float zulaessigesGesamtgewicht;
    private int sitzplaetze;
    private int insassen;

    public Fahrzeug(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen) throws UngueltigerParameterException {
        super();
        setFahrzeugnummer(fahrzeugnummer);
        setLeergewicht(leergewicht);
        setZulaessigesGesamtgewicht(zulaessigesGesamtgewicht);
        setSitzplaetze(sitzplaetze);
        setInsassen(insassen);
    }

    public int getFahrzeugnummer() {
        return fahrzeugnummer;
    }

    public void setFahrzeugnummer(int fahrzeugnummer) throws UngueltigerParameterException {
        if (fahrzeugnummer >= 0)  // 0 ... als Kennung für "noch nicht vergeben"
        {
            this.fahrzeugnummer = fahrzeugnummer;
        } else {
            throw new UngueltigerParameterException("ungültige Fahrzeugnummer (" + fahrzeugnummer + ")");
        }
    }

    public float getLeergewicht() {
        return leergewicht;
    }

    public void setLeergewicht(float leergewicht) throws UngueltigerParameterException {
        if (leergewicht > 0) {
            this.leergewicht = leergewicht;
        } else {
            throw new UngueltigerParameterException("ungültiges Leergewicht (" + leergewicht + ")");
        }
    }

    @SuppressWarnings("unused")
    public float getZulaessigesGesamtgewicht() {
        return zulaessigesGesamtgewicht;
    }

    public void setZulaessigesGesamtgewicht(float zulaessigesGesamtgewicht) throws UngueltigerParameterException {
        if (zulaessigesGesamtgewicht > leergewicht) {
            this.zulaessigesGesamtgewicht = zulaessigesGesamtgewicht;
        } else {
            throw new UngueltigerParameterException("unzulaessiges Gesamtgewicht (" + zulaessigesGesamtgewicht + ")");
        }
    }

    public int getSitzplaetze() {
        return sitzplaetze;
    }

    public void setSitzplaetze(int sitzplaetze) throws UngueltigerParameterException {
        if (sitzplaetze > 0) // wenn man davon ausgeht das jedes Fahrzeug zumindest 1 Sitzplatz hat
        {
            this.sitzplaetze = sitzplaetze;
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl von Sitzplätzen (" + sitzplaetze + ")");
        }
    }

    public int getInsassen() {
        return insassen;
    }

    public void setInsassen(int insassen) throws UngueltigerParameterException {
        if (insassen >= 0 && insassen <= sitzplaetze) {
            this.insassen = insassen;
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl von Insassen (" + insassen + ")");
        }
    }

    public abstract float berechneGewicht();  // Annahme: wir wissen noch nicht wie man das Gewicht berechnet

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fahrzeug other = (Fahrzeug) obj;
        return fahrzeugnummer == other.fahrzeugnummer; // zwei Fahrzeuge gelten als gleich (im Fuhrpark), wenn ihre Fahrzeugnummer identisch ist
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()             // um auch in abgeleiteten Klassen die richtige Bezeichnung auszugeben
                + ": Fahrzeugnummer=" + fahrzeugnummer
                + ", Leergewicht=" + leergewicht
                + ", zulässiges Gesamtgewicht=" + zulaessigesGesamtgewicht
                + ", Sitzplätze=" + sitzplaetze
                + ", Insassen=" + insassen
                + ", Gesamtgewicht=" + berechneGewicht() + "kg";  // Aufruf der vorerst abstrakte Methode kann hier schon vorgesehen werden!
    }

    public short printInfo()  // nur in der Basisklasse, wird sich nie mehr ändern - vererbt
    {
        System.out.println(this);
        return 0;
    }

/*	
	@Override
	public int compareTo(Fahrzeug f) 
	{
		return Integer.compare(this.getSitzplaetze(), f.getSitzplaetze());
	}
*/
}