/*
 * Copyright (c) 2022-2023 Stefan Psutka
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
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\POS1\\Labs\\src\\Lab05\\Shakespeare.txt"))) {
            String line;
            StringBuilder tline = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();

            // lowercase + without . and , word per word
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();

                // reset tline and tstring here


                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '.' || line.charAt(i) == ',') {
                        tline.append(' ');
                    } else {
                        tline.append(line.charAt(i));
                    }
                }

                for (int i = 0; i < tline.length(); i++) {
                    if (tline.charAt(i) != ' ') {
                        tstring.append(tline.charAt(i));
                    } else {
                        list.add(tstring.toString());
                        tstring = new StringBuilder();
                    }
                }
            }


            // putting the words into the map
            for (String k : list) {
                if (frequency.containsKey(k)) {
                    frequency.replace(k, frequency.get(k), frequency.get(k) + 1);
                } else {
                    frequency.put(k, 1);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    public void MapOutput(boolean writeToFile) throws IOException { //In der Angabe "ausgeben()"
        try {
            var out = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\POS1\\Labs\\src\\Lab05\\DolezalOutput.txt")); // This line creates a new File and I don't know how to prevent this
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry != null && !entry.toString().equals("")) {
                    if (writeToFile) {
                        out.write(entry.getKey() + ": " + entry.getValue() + "\n");
                    } else {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + "\n");
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
