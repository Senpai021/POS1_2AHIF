/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab04.Lab04a.main;

import Lab04.Lab04a.Maths;

import java.io.File;

public class Main_Test {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\IdeaProjects\\POS1_2AHIF\\src");
        Maths m = new Maths(file);

        System.out.println(m.gcd(10, 44) + "\n");

        System.out.println(m.fibonacci(1) + "\n");

        System.out.println(m.fibonacci(5) + "\n");

        System.out.println(m.fibonacci(10) + "\n");

        //   m.printMap();
        System.out.println(m.listDirectory(file.toString()));
    }
}
