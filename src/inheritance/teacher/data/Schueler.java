/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package inheritance.teacher.data;

public class Schueler extends Person {
    private int schuelerNummer;

    public Schueler(String name, int geburtsjahr, int schuelerNummer) {
        super(name, geburtsjahr);
        setSchuelerNummer(schuelerNummer);

    }

    public int getSchuelerNummer() {
        return schuelerNummer;
    }

    public void setSchuelerNummer(int schuelerNummer) {
        this.schuelerNummer = schuelerNummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", schuelerNummer=" + schuelerNummer;
    }

}
