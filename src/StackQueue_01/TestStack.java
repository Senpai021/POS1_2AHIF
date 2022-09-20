/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package StackQueue_01;

public class TestStack {

    public static void main(String[] args)
    {
        Person person1 = new Person("Paul", 2000, true);
        Person person2 = new Person("Rastislav", 2004, false);
        Person person3 = new Person("Elias", 2005, false);

        StackA stack = new StackA();

        stack.push(person1);
        stack.push(person2);
        stack.push(person3);

        stack.printAllEllements();

        stack.pop();
        stack.peek();

        QueueA queue = new QueueA();
        queue.enqueue(person1);
        queue.enqueue(person2);
        queue.enqueue(person3);

        queue.printAllEllements();
        queue.dequeue();
        queue.printAllEllements();

    }

}
