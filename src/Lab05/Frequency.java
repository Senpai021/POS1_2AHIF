/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Frequency {
    HashMap<String, Integer> frequency;

    //output word for word, not char for char
    StringBuilder tstring = new StringBuilder();

    public Frequency() {
        frequency = new HashMap<>();
    }

    public void MapInput() throws IOException { //In der Angabe "analysieren()"
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\IdeaProjects\\POS1_2AHIF\\src\\Lab05\\Dolezal.txt"))) {
            String line;
            StringBuilder tline = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();

            // lowercase + without . and , word per word
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '.' || line.charAt(i) == ',') {
                        tline.append(' ');
                    } else {
                        tline.append(line.charAt(i));
                    }
                }
                StringBuilder tstring = new StringBuilder();
                for (int i = 0; i < tline.length(); i++) {
                    if (tline.charAt(i) != ' ') {
                        tstring.append(tline.charAt(i));
                    } else{
                        list.add(tstring.toString());
                        tstring = new StringBuilder();
                    }
                }
            }

            // puuting the words into the map
            for (String k : list) {
                if (frequency.containsKey(k)){
                    frequency.replace(k, frequency.get(k), frequency.get(k) + 1);
                } else {
                    frequency.put(k, 1);
                }
            }

            //printing the words(HashMapKey) with their counts(HashMapValues)
            MapOutput();

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    public void MapOutput() { //In der Angabe "ausgeben()"
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry != null) {
                System.out.println(entry.getKey().equals("") ? "{EmptyString}: " + entry.getValue() : entry.getKey() + ": " + entry.getValue());
            }
        }
    }


}
