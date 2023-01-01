/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.fahrzeuge;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Klasse KFZ (Kraftfahrzeug) + Interace Tank
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */
public class KFZ extends Fahrzeug implements Tank // an der Stelle kommt die Betankungsmöglichkeit via Interface hinzu ...
{
    private int hoechstgeschwindigkeit;
    private int leistung;
    private float kilometerstand;
    // ... das erfordert eine Erweitreung der Attribute:
    private float tankinhalt = 0;
    private float tankgroesse;


    public KFZ(int fahrzeugnummer, float leergewicht, float zulaessigesGesamtgewicht, int sitzplaetze, int insassen, int hoechstgeschwindigkeit, int leistung, float kilometerstand, float tankgroesse) throws UngueltigerParameterException {
        super(fahrzeugnummer, leergewicht, zulaessigesGesamtgewicht, sitzplaetze, insassen);
        setHoechstgeschwindigkeit(hoechstgeschwindigkeit);
        setLeistung(leistung);
        setKilometerstand(kilometerstand);
        setTankgroesse(tankgroesse);  // tankinhalt bleibt 0 (könnte aber auch ein zusätzlicher Übergabeparameter sein)
    }

    @SuppressWarnings("unused")
    public int getHoechstgeschwindigkeit() {
        return hoechstgeschwindigkeit;
    }

    public void setHoechstgeschwindigkeit(int hoechstgeschwindigkeit) throws UngueltigerParameterException {
        if (hoechstgeschwindigkeit >= 25)   // selbst gewählter Mindestwert
        {
            this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
        } else {
            throw new UngueltigerParameterException("ungültige Höchstgeschwindigkeit (" + hoechstgeschwindigkeit + ")");
        }
    }

    @SuppressWarnings("unused")
    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) throws UngueltigerParameterException {
        if (leistung >= 0) {
            this.leistung = leistung;
        } else {
            throw new UngueltigerParameterException("ungültiger Wert für Leistung (" + leistung + ")");
        }
    }

    @SuppressWarnings("unused")
    public float getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(float kilometerstand) throws UngueltigerParameterException {
        // Kilometerstand darf nicht kleiner werden
        if (kilometerstand >= 0 && kilometerstand >= this.kilometerstand) {
            this.kilometerstand = kilometerstand;
        } else {
            throw new UngueltigerParameterException("ungültiger Wert für den neuen Kilometerstand (" + kilometerstand + ")");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Höchstgeschwindigkeit=" + hoechstgeschwindigkeit
                + "km/h, Leistung=" + leistung
                + "PS, Kilometerstand=" + kilometerstand + "km"
                // Ergänzung wegen Implementation des Interfaces Tank:
                + ", Tankinhalt=" + tankinhalt + "l, Tankgröße=" + tankgroesse + "l";
    }

    @Override
    public float berechneGewicht() {
        return getLeergewicht() + (getInsassen() * 80);
    }

    // für das Interface Tank erforderlich:
    public float getTankgroesse() {
        return tankgroesse;
    }

    // Ergänzunen, im Zusammenhang mit dem Interface Tank sinnvoll:
    // private, weil die Tankgröße nur vom Konstruktor einmalig gesetzt werden soll
    private void setTankgroesse(float tankgroesse) throws UngueltigerParameterException {
        if (tankgroesse <= 0)
            throw new UngueltigerParameterException("ungültige Wert für Tankgröße (" + tankgroesse + ")");

        this.tankgroesse = tankgroesse;
    }

    public float getTankinhalt() {
        return tankinhalt;
    }

    public float tanken() // voll tanken
    {
        float menge = tankgroesse - tankinhalt;
        tankinhalt = tankgroesse;
        return menge;
    }
}