/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab05;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Frequency fr = new Frequency();

            /*
            counting the words(HashMapKey) with their frequency(HashMapValues)
            */
            fr.MapInput();

            /*
            printing the words(HashMapKey) with their frequency(HashMapValues)
            writeToFile = true  if the method should write it's output to the console and vice versa
            */
            fr.MapOutput(false);

            System.out.println(fr.tstring);

        } catch (IOException io){
            io.printStackTrace();
            throw new IOException();
        }
    }
}
