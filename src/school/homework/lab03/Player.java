/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab03;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    @Setter
    private String name;
    private int score;
    private int number;

    public Player(String name, int number, int score) {
        if (number < 0 || score < 0)
            throw new RuntimeException("Violation detected: The number and score fields are expected to be at least 0!");

        setName(name);
        setNumber(number);
        setScore(score);
    }


    public void setScore(int score) {
        if (score < 0) throw new RuntimeException("Violation detected: The score is expected to be at least 0.");

        this.score = score;
    }


    public void setNumber(int number) {
        if (number < 0) throw new RuntimeException("Violation detected: The number is expected to be at least 0.");

        this.number = number;
    }


    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", score=" + score + ", number=" + number + '}';
    }

    public void printInfo() {
        System.out.println(this);
    }
}
