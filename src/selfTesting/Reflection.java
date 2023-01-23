/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package selfTesting;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;

import java.lang.reflect.Field;

public class Reflection {
    @Getter
    @Setter
    private final int number;
    @Getter
    @Setter
    private final String name;
    @Contract(pure = true)
    public Reflection(int number1, String name1){
        this.number = number1;
        this.name = name1;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Reflection rft = new Reflection(5, "John");
        Field[] rftFields = rft.getClass().getDeclaredFields();

        for (Field field : rftFields) {
            if (field.getName().equals("name")){
                field.setAccessible(true);
                field.set(rft, "Jimmy McGill");
            }
        }
        System.out.println(rft.getName());
    }


}
