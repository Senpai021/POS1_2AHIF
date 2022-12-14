/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lab04.Lab04a;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Maths {

    private final HashMap<Integer, Integer> fibomap = new HashMap<>();
    private final File file;

    private final ArrayList<File> fileList = new ArrayList<>();

    // In the constructor, the first two fibonacci numbers are predefined
    public Maths(File file) {
        this.file = file;
        fibomap.put(0, 0);
        fibomap.put(1, 1);
    }

    @SuppressWarnings("unused")
    public void clearMap() {
        fibomap.clear();
    }

    @SuppressWarnings("unused")
    public double gcd(double a, double b) {
        if (a < b) {
            return gcd(b, a);
        } else if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    /* Code vom Lehrer
        public int fibonacci(int zahl) {
            if (zahl <= 2) {
                return 1;
        } else {
            return fibonacci(zahl - 1) + fibonacci(zahl - 2);
        }
    }*/

    public int fibonacci(int zahl) {
        if (fibomap.get(zahl) != null) {
            return fibomap.get(zahl);
        } else {
            var tf = fibonacci(zahl - 1) + fibonacci(zahl - 2);
            fibomap.put(zahl, tf);
            return tf;
        }
    }

    //This method is used for the already done calculations
    @SuppressWarnings("unused")
    public void printMap() {
        for (Integer i :
                fibomap.values()) {
            System.out.println(i);
        }
    }

    private int counter = 0;
    private int count = 0;
    private int size = 0;
    public int listDirectory(@NotNull File path){
        counter ++;
        File[] list = path.listFiles();
        for (File file : Objects.requireNonNull(list)) {
            if(!file.isDirectory()){
                size += (file.getTotalSpace() / 1024d);
                dateiAusgabe(file);
            } else {
                System.out.println(file.getAbsolutePath());
                listDirectory(file);
                count ++;
            }
        }

        if (counter == 1) {
            System.out.println("\n" + "Total size:\n " + size);
            System.out.println("Total count:");
        }
        counter --;
        return count;
    }

    @SuppressWarnings("unused")
    public File getPath() {
        return new File(file.getPath());
    }

    //Not finished
    public ArrayList<File> dateiAusgabe(File file){
        for (File file1 : fileList) {
            if (file != null) {
                fileList.add(file);
            }
        }

        return fileList;
    }
}