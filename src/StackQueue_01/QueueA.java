/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package StackQueue_01;

public class QueueA {

    private Person[] person;
    private int pos;

    public QueueA() {
        person = new Person[10];
        pos = 0;
    }

    public static void main(String[] args) {
        QueueA queue = new QueueA();

        Person person1 = new Person("Paul", 2000, false);
        Person person2 = new Person("Rastislav", 2006, true);


        queue.enqueue(person1);
        queue.enqueue(person2);

        queue.printAllEllements();

        System.out.println(queue.dequeue());
        queue.printAllEllements();

    }

    public Person dequeue() {
        for(int i = 0; i < person.length; i++){
            if(person[i] != null){
                var tempp = person[i];
                person[i] = null;
                reArrange();
                return tempp;
            }
        }
        return null;
    }

    private void reArrange(){
        for(int i = 0; i < person.length; i++){
            if (person[i] != null){
                var temp = person[i];
                person[i - 1] = temp;
                person[i] = null;
            }
        }
    }

    public void enqueue(Person perso) {
        if(pos < person.length){
            person[pos] = perso;
            pos++;
        } else{
            System.out.println("Array ist voll!");
        }
    }

    @SuppressWarnings("unused")
    public Person[] getPerson() {
        return person;
    }

    @SuppressWarnings("unused")
    public void setPerson(Person[] person) {
        this.person = person;
    }

    public void printAllEllements() {
        for (Person person : person) {
            if (person != null) {
                System.out.println(person);
            } else {
                break;
            }

        }
    }
}
