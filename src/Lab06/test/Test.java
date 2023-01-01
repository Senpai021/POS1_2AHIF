/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.test;

import Lab06.fahrzeuge.*;

/**
 * Musterlösung zur Fuhrpark-Aufgabe - Testklasse
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */

public class Test {
    // Beispiel einer klassischen Test-Methode (unvollständig)
    public static void main(String[] args) {
        einfacheTestsOK();
        System.out.println("--------------------------------------------------------------------------------");
        einfacherTestFehlerFahrzeug();
        System.out.println("--------------------------------------------------------------------------------");
        einfacherTestFehlerFuhrpark();
    }

    public static void einfacheTestsOK() {
        Fuhrpark fp = new Fuhrpark();
        Fahrzeug f1;
        Fahrzeug f2;
        Fahrzeug f3;

        try {
            f1 = new Motorrad(2000, 100, 250, 2, 1, 150, 60, 2555, 10, true);
            f2 = new PKW(1000, 1300, 1600, 5, 0, 190, 100, 13248, 50, "Cabrio");
            f3 = new Fahrrad(0, 8, 120, 1, 0, 14);
            // Fahrzeugnummer 0 wird beim Hinzufügen auf 2001 gesetzt

            fp.hinzufuegen(f1);
            fp.hinzufuegen(f2);
            fp.hinzufuegen(f3);

            fp.ausgabeFahrzeuge(false); // false ... alle Fahrzeuge ausgeben

            System.out.println("-----");

            System.out.println("freies Fahrzeug mit nindestens 2 Plätzen: "
                    + fp.sucheFreiesFahrzeug(2));

            System.out.println("-----");

            System.out.println("Liste sortiert nach Fahrzeugnummer:");
            System.out.println(fp.fahrzeugeSortiertNachFahrzeugnummer());
            System.out.println("Liste sortiert nach Sitzplätze:");
            System.out.println(fp.fahrzeugeSortiertNachSitzplaetze());

            System.out.println("-----");

            System.out.println("KFZ ausgeben:");
            fp.ausgabeFahrzeuge(true);
            System.out.println("alle Fahrzeuge ausgeben:");
            fp.ausgabeFahrzeuge(false);

            System.out.println("-----");

            System.out.println("alle Fahrzeuge getankt, Treibstoffmenge: "
                    + fp.tankeKraftfahrzeuge() + " Liter");
        } catch (UngueltigerParameterException e) {
            System.err.println("unererwartete Exception:");
            System.err.println(e.getMessage());
            // oder: e.printStackTrace();
        }
    }

    public static void einfacherTestFehlerFahrzeug() {
        Fahrzeug f3;

        try {
            f3 = new Fahrrad(0, -8, 120, 1, 0, 14);
            // negativer Wert beim Leergewict
            f3.printInfo();
        } catch (UngueltigerParameterException e) {
            System.err.println("unererwartete Exception:");
            System.err.println(e.getMessage());
            // oder: e.printStackTrace();
        }
    }

    public static void einfacherTestFehlerFuhrpark() {
        Fuhrpark fp = new Fuhrpark();
        Fahrzeug f1;
        Fahrzeug f2;
        Fahrzeug f3;

        try {
            f1 = new Motorrad(2000, 100, 250, 2, 1, 150, 60, 2555, 10, true);
            f2 = new PKW(1000, 1300, 1600, 5, 0, 190, 100, 13248, 50, "Cabrio");
            f3 = new Fahrrad(2000, 8, 120, 1, 0, 14);
            // gleiche Fahrzeugnummern bei Morrad und Fahrrad

            fp.hinzufuegen(f1);
            fp.hinzufuegen(f2);
            fp.hinzufuegen(f3);

            fp.ausgabeFahrzeuge(false); // false ... alle Fahrzeuge ausgeben
        } catch (UngueltigerParameterException e) {
            System.err.println("unerwartete Exception:");
            System.err.println(e.getMessage());
            // oder: e.printStackTrace();
        }
    }

}