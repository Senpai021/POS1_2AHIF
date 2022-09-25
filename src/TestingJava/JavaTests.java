/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package TestingJava;public class JavaTests {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        System.out.println(x + ", " + y);
        x = x + y;

        y = x - y;

        x = x - y;

        System.out.println(x + ", " + y);
    }
}
