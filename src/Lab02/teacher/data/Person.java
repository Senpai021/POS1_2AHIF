/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package Lab02.teacher.data;

public class Person {
    private String name;
    private int geburtsjahr;

    public Person(String name, int geburtsjahr) {
        super();
        setName(name);
        setGeburtsjahr(geburtsjahr);
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "Christopher";
        }
    }

    @SuppressWarnings("unused")
    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        if (geburtsjahr > 1900) {
            this.geburtsjahr = geburtsjahr;
        } else {
            this.geburtsjahr = 2000;
        }
    }

    @Override
    public String toString() {
        return "Class: [" + getClass().getSimpleName() + ", name=" + name + ", geburtsjahr=" + geburtsjahr + "]";
    }

    public void printInfo() {
        System.out.println(this);
    }
}
