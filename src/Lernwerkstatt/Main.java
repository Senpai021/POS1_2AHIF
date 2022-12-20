/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lernwerkstatt;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Moebel m1 = new Moebel("Table", true);
            Moebel m2 = new Moebel("Sessel", true);
            Moebel m3 = new Moebel("Sofa", true);

            Moebelhaus mh = new Moebelhaus();
            System.out.println("hinzu (m1): " + mh.hinzu(m1));
            System.out.println("hinzu (m2): " + mh.hinzu(m2));
            System.out.println("hinzu (m3): " + mh.hinzu(m3));

            System.out.println("Möbelangebot: ");
            mh.printAngebot();

            System.out.println("Teste Speichern / Laden: ");
            mh.angebotSpeichernSerialisierung("./moebel.ser");
            Moebelhaus mh_neu = new Moebelhaus();
            mh_neu.angebotLadenDeserialisierung("./moebel.ser");
            mh_neu.printAngebot();

            System.out.println("Möbelangebot: ");
            mh.printAngebot();

            //m.print();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

class Moebel implements Serializable {
    private String art;
    private boolean verschiebbar;

    public Moebel(String art, boolean verschiebbar) throws Exception {
        try {
            setArt(art);
            setVerschiebbar(verschiebbar);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) throws Exception {
        if (art == null || art.isEmpty()) {
            throw new Exception("Keine Möbel art angegeben");
        }
        this.art = art;
    }

    public boolean isVerschiebbar() {
        return verschiebbar;
    }

    public void setVerschiebbar(boolean verschiebbar) {
        this.verschiebbar = verschiebbar;
    }

    @Override
    public String toString() {
        return "Moebel{" + "art='" + art + '\'' + ", verschiebbar=" + verschiebbar + '}';
    }

    public void print() {
        System.out.println(this);
    }
}

class Moebelhaus {
    private ArrayList<Moebel> angebot;

    public Moebelhaus() {
        this.angebot = new ArrayList<>();
    }

    public boolean hinzu(Moebel m) {
        return angebot.add(m);
    }

    public void printAngebot() {
        for (Moebel m : angebot) {
            m.print();
        }
    }

    public void angebotSpeichernSerialisierung(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(angebot);
        }
    }

    public void angebotLadenDeserialisierung(String fileName) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            try{
                angebot = (ArrayList<Moebel>) ois.readObject();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    public void generiereMoebelRekursiv(int anzahl) {
        try {
            hinzu(new Moebel("Sofa"+anzahl, true));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (anzahl > 1){
            generiereMoebelRekursiv(anzahl - 1);
        }
    }
}
