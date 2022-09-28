/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.A02.b;

import inheritance.A02.a.Fahrzeug;
import inheritance.A02.a.KraftFahrzeug;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class Fuhrpark {
    private final ArrayList<Fahrzeug> fahrzeuge;

    public Fuhrpark() {
        fahrzeuge = new ArrayList<>();
    }

    //checkfahrzeugNummer() ist eine Hilfsmethode
    public void hinzufuegen(Fahrzeug fuep) throws containException {
        if (checkfahrzeugNummer(fuep)) {
            throw new containException("Fahrzeug schon vorhanden");
        } else {
            fahrzeuge.add(fuep);
        }
    }


    private boolean checkfahrzeugNummer(@NotNull Fahrzeug fuep) {
        for (int i = 0; i < fahrzeuge.size(); i++) {
            if (fuep.equals(fahrzeuge)) return true;
        }
        return false;
    }

    public boolean entfernen(UUID uuid) {
        for (int i = 0; i < fahrzeuge.size(); i++) {
            if (uuid.equals(fahrzeuge.get(i).getFahrzeugNummer())) {
                fahrzeuge.remove(fahrzeuge.get(i));
                return true;
            }
        }
        return false;
    }

    public void ausgabeFahrzeuge(boolean nurKraftfahrzeuge) {
        for (Fahrzeug f : fahrzeuge) {
            if (nurKraftfahrzeuge) {
                var kraftFahrzeug = f instanceof KraftFahrzeug ? ((KraftFahrzeug) f) : null;
                try {
                    kraftFahrzeug.printInfo();
                } catch (NullPointerException npe) {
                    System.out.println("No vehicle of type kraftFahrzeug found!");
                }
            } else {
                try {
                    f.printInfo();
                } catch (NullPointerException npe) {
                    npe.getCause();
                }
            }
        }
    }


    public Fahrzeug sucheFreiesFahrzeug(int hatPlatzFuer) {
        for (Fahrzeug f : fahrzeuge) {
            if ((f.getMaxSitzplatz() - f.getInsassen()) >= hatPlatzFuer) {
                return f;
            } else {
                System.err.println("not enough Space");
            }
        }
        return null;
    }

    public int getFahrzeugesize() {
        return fahrzeuge.size();
    }

    public String clear() {
        if (fahrzeuge.size() > 0) {
            fahrzeuge.clear();
            return "clear call worked!";
        }
        return "already clear!";
    }
}


