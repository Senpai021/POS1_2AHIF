/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;

/*
 * Musterlösung zur Fuhrpark-Aufgabe - Klasse Fahrrad
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public class Fahrrad extends Fahrzeug {
    private float rahmenhoehe;

    public Fahrrad(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen, float rahmenhoehe) throws UngueltigerParameterException {
        super(fahrzeugnummer, leergewicht, zulaessigesGesamtgewicht, sitzplaetze, insassen);
        setRahmenhoehe(rahmenhoehe);
    }

    // Einschänken der möglichen Anzahl durch Überschreiben der set-Methode.
    // Der Aufruf dieser Methode erfolgt nicht im Fahrrad-Konstruktor direkt, sondern im zu Beginn
    // via super(...) aufgerufenen Konstruktor der Fahrzeugklasse, der damit nicht seine, sonder diese
    // setSitzplaetze(...) aufruft - dynamische Zuordnung zur Laufzeit (virtual method invocation)
    @Override
    public void setSitzplaetze(int sitzplaetze) throws UngueltigerParameterException {
        if (sitzplaetze > 0 && sitzplaetze <= 2) {
            super.setSitzplaetze(sitzplaetze);
        } else {
            throw new UngueltigerParameterException("ungültige Anzahl von Sitzplätzen (" + sitzplaetze + ")");
        }
    }

    @SuppressWarnings("unused")
    public float getRahmenhoehe() {
        return rahmenhoehe;
    }

    public void setRahmenhoehe(float rahmenhoehe) throws UngueltigerParameterException {
        if (rahmenhoehe > 0) {
            this.rahmenhoehe = rahmenhoehe;
        } else {
            throw new UngueltigerParameterException("ungültige Rahmenhöhe (" + rahmenhoehe + ")");
        }
    }

    @Override
    public float berechneGewicht() // hier wird die abstrakte Methode erstmals realisiert
    {
        return getLeergewicht() + (getInsassen() * 80); // angenommen 1 Person wiegt durchschnittlich 80 kg
    }

    @Override
    public String toString() {
        return super.toString() + ", Rahmenhöhe=" + rahmenhoehe;
    }

    // printInfo)= muss nicht überschrieben werden, die geerbten Anweisungen passen auch hier
}