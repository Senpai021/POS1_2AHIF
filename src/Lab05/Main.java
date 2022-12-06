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

            fr.MapInput();

            System.out.println(fr.tstring);

        } catch (IOException io){
            io.printStackTrace();
            throw new IOException();
        }
    }
}
