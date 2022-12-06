/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab05;

import java.io.*;
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
                    } else {
                        list.add(tstring.toString());
                        tstring = new StringBuilder();
                    }
                }
            }

            // puting the words into the map
            for (String k : list) {
                if (frequency.containsKey(k)) {
                    frequency.replace(k, frequency.get(k), frequency.get(k) + 1);
                } else {
                    frequency.put(k, 1);
                }
            }

            /*
            printing the words(HashMapKey) with their counts(HashMapValues)
            writeToFile = true  if the method should write it's output to the console and vice versa
            */

            MapOutput(true);

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    public void MapOutput(boolean writeToFile) throws IOException { //In der Angabe "ausgeben()"
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./DolezalOutput.txt"))); // This line creates a new File and I don't know how to prevent this
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry != null) {
                    if (!writeToFile) {
                        System.out.println(entry.getKey().equals("") ? "{EmptyString}: " + entry.getValue() : entry.getKey() + ": " + entry.getValue());
                    } else {
                        out.write(entry.getKey().equals("") ? "{EmptyString}: " + entry.getValue() + "\n" : entry.getKey() + ": " + entry.getValue() + "\n");
                    }
                }
            }
            out.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new IOException();
        }


    }
}
