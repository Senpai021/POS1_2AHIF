/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab02.A02.b;

import school.homework.lab02.A02.a.Fahrzeug;
import school.homework.lab02.A02.a.KraftFahrzeug;
import org.jetbrains.annotations.Contract;
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


    @Contract(pure = true)
    private boolean checkfahrzeugNummer(@NotNull Fahrzeug fuep) {
        for (Fahrzeug fahrzeug : fahrzeuge) {
            if (fuep.equals(fahrzeug)) return true;
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
                    assert kraftFahrzeug != null;
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

    @SuppressWarnings("unused")
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


