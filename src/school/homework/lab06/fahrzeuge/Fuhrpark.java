/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab06.fahrzeuge;
/*
 * Musterlösung zur Fuhrpark-Aufgabe - Verwaltungsklasse Fuhrpark
 * <p>
 * KEINE Erweiterung von Fahrzeug!!!
 *
 * @author Gerald Schildberger
 * @version 2022-11-08
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fuhrpark implements Serializable {
    private ArrayList<Fahrzeug> fahrzeuge;

    public Fuhrpark() {
        fahrzeuge = new ArrayList<>();
    }

    public void hinzufuegen(Fahrzeug fahrzeug) throws UngueltigerParameterException {
        if (fahrzeug == null) {
            throw new UngueltigerParameterException("kein Fahrzeug übergeben");
        }

        if (fahrzeuge.contains(fahrzeug))  // contains verwendet equals aus Fahrzeug!
        {
            throw new UngueltigerParameterException("Fahrzeugnummer (" + fahrzeug.getFahrzeugnummer() + ") schon in Verwendung");
        }

        // wenn die Fahrzeugnummer 0 ist, wird sie durch diese Methode auf eine noch nicht vorhendene gesetzt (Maxiumum + 1):
        if (fahrzeug.getFahrzeugnummer() == 0) {
            int max = 0;
            for (Fahrzeug f : fahrzeuge) {
                if (f.getFahrzeugnummer() > max) max = f.getFahrzeugnummer();
            }
            fahrzeug.setFahrzeugnummer(max + 1);
        }

        fahrzeuge.add(fahrzeug);
    }

    @SuppressWarnings("unused")
    public boolean entfernen(int fahrzeugnummer) {
        Iterator<Fahrzeug> it = fahrzeuge.iterator();

        while (it.hasNext()) {
            Fahrzeug f = it.next();
            if (f.getFahrzeugnummer() == fahrzeugnummer) {
                it.remove();
                return true;  // Fahrzeugnummer ist eindeutog, d.h. wir sind fertig
            }
        }
        return false; // falls die Fahrzeugnummer nicht gefunden wurde
    }

    public short ausgabeFahrzeuge(boolean nurKFZ) {
        System.out.println((nurKFZ ? "Kraftfahrzeuge" : "Fahrzeuge") + " im Fuhrpark:");
        for (Fahrzeug f : fahrzeuge) {
            if (!nurKFZ || f instanceof KFZ)  // print wenn alle auszugeben sind (NICHT nurKFZ)
            {                                //       ODER es ein KFZ ist
                f.printInfo();
                // System.out.println();
            }
        }
        return 0;
    }

    public Fahrzeug sucheFreiesFahrzeug(int hatPlatzFuer) {
        for (Fahrzeug f : fahrzeuge) {
            if (f.getInsassen() == 0 && f.getSitzplaetze() >= hatPlatzFuer) {
                return f;
            }
        }
        return null;  // kein passendes Fahrzeug gefunden
    }

    public List<Fahrzeug> fahrzeugeSortiertNachFahrzeugnummer() {
        // man kann natürlich die originale Fahrzeugliste sortieren und returnieren,
        // hier wird aber eine Kopie sortiert ... d.h. die originale Liste bleibt unverändert
        List<Fahrzeug> liste = new ArrayList<>(fahrzeuge);
        liste.sort(new VergleichFahrzeugnummer());
        return liste;
    }

    public List<Fahrzeug> fahrzeugeSortiertNachSitzplaetze() {
        List<Fahrzeug> liste = new ArrayList<>(fahrzeuge);
        liste.sort(new VergleichSitzplaetze());
        return liste;
    }


    // alterativ lässt sich EINE Sortierung auch ohne Comperator realisieren, wenn man dafür
    // die Klasse Fahrzeug "comparable" macht - siehe auch Fahrzeug /*...*/ am Beginn und Ende
/*
	public List<Fahrzeug> fahrzeugeSortiertNachSitzplaetze_Version2()
	{
		List<Fahrzeug> liste = new ArrayList<>(fahrzeuge);
		Collections.sort(liste);
		return liste;
	}
*/

    // Teil 3 (Interface):

    public float tankeKraftfahrzeuge() {
        float treibstoffmenge = 0;

        for (Fahrzeug f : fahrzeuge) {
            if (f instanceof KFZ) {
                treibstoffmenge += ((KFZ) f).tanken(); // Wichtig hier der Typecast auf KFZ, da erst ab dieser Klasse die tanken()-Methode zur Verfügung steht
            }
        }
        return treibstoffmenge;
    }

    public boolean SpeicherFuhrpark(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(fahrzeuge);
            return true; // No exception
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public boolean LadeFuhrpark(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            try {
                fahrzeuge = (ArrayList<Fahrzeug>) ois.readObject();
                return true; // No exception
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public int size() {
        return fahrzeuge.size();
    }
}
