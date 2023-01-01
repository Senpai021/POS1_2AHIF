/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package Lab06.test;

import Lab06.fahrzeuge.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FuhrparkTest {
    Fuhrpark fh;
    Motorrad m;
    PKW pkw;
    LKW lkw;

    @BeforeEach
    void setUp() throws UngueltigerParameterException {
        fh = new Fuhrpark();
        m = new Motorrad(1, 200f, 400f, 2, 0, 300, 150, 4521.4f, 40f, false);
        pkw = new PKW(2, 1000f, 2000f, 4, 2, 300, 200, 5284.4f, 80f, "Porsche");
        lkw = new LKW(2, 1000f, 2000f, 2, 2, 300, 200, 5284.4f, 80f, 500f, 1000);
    }

    @Test
    void TestHinzufuegen() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
            fh.hinzufuegen(lkw);
            fh.hinzufuegen(pkw);

            assertEquals(3, fh.size());
        } catch (UngueltigerParameterException upe) {
            upe.printStackTrace();
            throw new UngueltigerParameterException(upe.getMessage());
        }
    }

    @Test
    void TestEntfernen() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
        assertEquals(1, fh.size());
    }

    @Test
    void TestAusgabePKW() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(pkw);
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
        assertEquals(pkw.printInfo(), fh.ausgabeFahrzeuge(true));
    }

    @Test
    void TestAusgabeLKW() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(lkw);
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
        assertEquals(lkw.printInfo(), fh.ausgabeFahrzeuge(true));
    }

    @Test
    void TestAusgabeMotorrad() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
        assertEquals(m.printInfo(), fh.ausgabeFahrzeuge(true));
    }

    @Test
    void TestSucheFreiesFahrzeug() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
        assertEquals(m, fh.sucheFreiesFahrzeug(2));
    }

    @Test
    void TestFahrzeugeSortiertNachFahrzeugnummer() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
            fh.hinzufuegen(pkw);
            fh.hinzufuegen(lkw);
            assertEquals("[Motorrad: Fahrzeugnummer=1, Leergewicht=200.0, zulässiges Gesamtgewicht=400.0, Sitzplätze=2, Insassen=0, Gesamtgewicht=200.0kg, Höchstgeschwindigkeit=300km/h, Leistung=150PS, Kilometerstand=4521.4km, Tankinhalt=0.0l, Tankgröße=40.0l, ohne Beiwagen, PKW: Fahrzeugnummer=2, Leergewicht=1000.0, zulässiges Gesamtgewicht=2000.0, Sitzplätze=4, Insassen=2, Gesamtgewicht=1160.0kg, Höchstgeschwindigkeit=300km/h, Leistung=200PS, Kilometerstand=5284.4km, Tankinhalt=0.0l, Tankgröße=80.0l, Art=Porsche, LKW: Fahrzeugnummer=2, Leergewicht=1000.0, zulässiges Gesamtgewicht=2000.0, Sitzplätze=2, Insassen=2, Gesamtgewicht=1660.0kg, Höchstgeschwindigkeit=300km/h, Leistung=200PS, Kilometerstand=5284.4km, Tankinhalt=0.0l, Tankgröße=80.0l, Lademenge=500.0kg, max.Lademenge= 1000.0t]", fh.fahrzeugeSortiertNachFahrzeugnummer().toString());
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
    }

    @Test
    void TestFahrzeugeSortiertNachSitzplaetze() throws UngueltigerParameterException {
        try {
            fh.hinzufuegen(m);
            fh.hinzufuegen(pkw);
            fh.hinzufuegen(lkw);
            assertEquals("[Motorrad: Fahrzeugnummer=1, Leergewicht=200.0, zulässiges Gesamtgewicht=400.0, Sitzplätze=2, Insassen=0, Gesamtgewicht=200.0kg, Höchstgeschwindigkeit=300km/h, Leistung=150PS, Kilometerstand=4521.4km, Tankinhalt=0.0l, Tankgröße=40.0l, ohne Beiwagen, PKW: Fahrzeugnummer=2, Leergewicht=1000.0, zulässiges Gesamtgewicht=2000.0, Sitzplätze=4, Insassen=2, Gesamtgewicht=1160.0kg, Höchstgeschwindigkeit=300km/h, Leistung=200PS, Kilometerstand=5284.4km, Tankinhalt=0.0l, Tankgröße=80.0l, Art=Porsche, LKW: Fahrzeugnummer=2, Leergewicht=1000.0, zulässiges Gesamtgewicht=2000.0, Sitzplätze=2, Insassen=2, Gesamtgewicht=1660.0kg, Höchstgeschwindigkeit=300km/h, Leistung=200PS, Kilometerstand=5284.4km, Tankinhalt=0.0l, Tankgröße=80.0l, Lademenge=500.0kg, max.Lademenge= 1000.0t]", fh.fahrzeugeSortiertNachFahrzeugnummer().toString());
        } catch (UngueltigerParameterException e) {
            throw new UngueltigerParameterException(e.getMessage());
        }
    }

    @Test
    void TestTankeKraftfahrzeuge() {
        float tempmt = m.getTankinhalt();
        m.tanken();
        assertNotEquals(tempmt, m.getTankinhalt());
    }

    @Test
    void TestSpeicherFuhrpark() throws IOException {
        try {
            assertTrue(fh.SpeicherFuhrpark("./Fuhrpark.ser"));
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Test
    void ladeFuhrpark() throws IOException, ClassNotFoundException {
        try {
            assertTrue(fh.LadeFuhrpark("./Fuhrpark.ser"));
        } catch (IOException e) {
            throw new IOException(e);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(e.getMessage());
        }
    }
}