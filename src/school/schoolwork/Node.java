/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.schoolwork;

import org.jetbrains.annotations.Contract;
import school.homework.lab01.Person;

public class Node {
    private Person person;
    private Node next;

    @Contract(pure = true)
    public Node(Person _person, Node _next) {
        setValue(_person);
        setNext(_next);
    }

    public Person getPerson() {
        return person;
    }

    public void setValue(Person _person) {
        this.person = _person;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node _next) {
        this.next = _next;
    }

    @Override
    public String toString() {
        return "Node{" + "person=" + person + ", next=" + next + '}';
    }
}

class LinkedList {
    private Node root = null;

    public boolean addFirst(Person _person) {
        if (_person == null) {
            return false;
        } else {
            root = new Node(_person, root);
            return true;
        }
    }

    public boolean addLast(Person _person) {
        boolean success = false;
        if (_person != null) {
            if (root == null) {
                root = new Node(_person, null);
            } else {
                Node n = root;
                while (n != null) {
                    if (n.getNext() == null) {
                        n.setNext(new Node(_person, null));
                        success = true;
                        break;
                    } else {
                        n = n.getNext();
                    }
                }
            }
        }
        return success;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "root=" + root + '}';
    }
}

class Main {
    public static void main(String[] args) {
        var n0 = new Node(new Person("John", 2010, false), null);
        var n1 = new Node(new Person("George", 2004, true), null);

        var ll = new LinkedList();

        System.out.println(ll.addFirst(n0.getPerson()));

        System.out.println(ll.addLast(n1.getPerson()));

        System.out.println(ll);
    }
}