/*
 * Copyright (c) 2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab8;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Node implements Comparable {
    private Cat cat;
    private Node next;

    @Contract(pure = true)
    public Node(Cat _cat, Node _next) {
        setCat(_cat);
        setNext(_next);
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node _next) {
        this.next = _next;
    }

    @Override
    public String toString() {
        return "Node{" + "cat=" + getCat() + ", next=" + getNext() + '}';
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Node n = (Node) o;
        Node _n = ((Node) o).getNext();
        if (_n.getNext() == null) return 0;
        return Integer.compare(n.getCat().getAge(), _n.getCat().getAge());
    }
}

class LinkedList {
    private Node root = null;

    public boolean addFirst(Cat cat) {
        if (cat == null) {
            return false;
        } else {
            root = new Node(cat, root);
            return true;
        }
    }

    public boolean addLast(Cat cat) {
        boolean successfull;
        successfull = false;
        if (cat != null) {
            if (root == null) {
                root = new Node(cat, null);
            } else {
                Node n = root;
                while (n != null) if (n.getNext() == null) {
                    n.setNext(new Node(cat, null));
                    successfull = true;
                    break;
                } else {
                    n = n.getNext();
                }
            }
        }
        return successfull;
    }

    /**
     * This function compares the Node (Cat -> name) you want to implement into the list with the other Nodes [Not working D;]
     * @param n -> Node you want to implement into the LinkedList
     * @return -> true when the implementation was successfully done / false when the implementation wasn't successfully done
     */
    public boolean sortedImplemend(Node n) {
        return false;
    }

    public void printWithIterator() {
        Node n = root;
        while (true) {
            if (n != null) {
                System.out.println(n.getCat());
                n = n.getNext();
            } else {
                return;
            }
        }
    }

    public void printRekursiv() {
        printRekursiv(root);
    }

    public void printRekursiv(@NotNull Node n) {
        System.out.println(n.getCat());
        if (n.getNext() != null) printRekursiv(n.getNext());
    }

    @Override
    public String toString() {
        return "LinkedList{" + "root=" + root + '}';
    }
}

class Main {
    public static void main(String[] args) {
        var n0 = new Node(new Cat(2011, "John"), null);
        var n1 = new Node(new Cat(2005, "George"), null);
        var n2 = new Node(new Cat(2003, "Harald"), null);

        var linkedList = new LinkedList();

        System.out.println(linkedList.addFirst(n0.getCat()));
        System.out.println(linkedList.addLast(n1.getCat()));
        System.out.println(linkedList.addLast(n2.getCat()));

        System.out.println("\n");

        System.out.println(linkedList.sortedImplemend(n0));

        System.out.println("\n");

        System.out.println(linkedList.sortedImplemend(n1));

        System.out.println("\n");

        linkedList.printWithIterator();

        System.out.println("\n");

        linkedList.printRekursiv();

        System.out.println("\n");

    }
}

class Cat {
    private int age;
    private String name;

    public Cat(int age, String name) {
        setAge(age);
        setCat(name);
    }

    public void setCat(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Cat{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}