/*
 * Copyright (c) 2022-2023 Stefan Psutka
 * All rights reserved
 */

package school.homework.lab07;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings(value = "unused")
public class Table {
    private final TreeMap<LocalDate, Integer> reservations;
    private String designation;
    private int seats;

    public Table(String designation, int seats) throws TableException {
        setDesignation(designation);
        setSeats(seats);
        reservations = new TreeMap<>();
    }

    @Contract("null -> fail")
    public static @NotNull Table createTisch(String line) throws TableException {
        if (line == null || line.isEmpty()) {
            throw new TableException("empty text not valid");
        } else {
            String[] values = line.split(";");
            if (values.length < 2) {
                throw new TableException("Text format not applicable");
            } else {
                try {
                    return new Table(values[0], Integer.parseInt(values[1]));
                } catch (NumberFormatException nfe) {
                    throw new TableException("wrong format");
                }
            }
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) throws TableException {
        if (seats >= 1) {
            this.seats = seats;
            return;
        }
        throw new TableException("invalid count of seats: " + seats);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) throws TableException {
        if (designation != null && designation.length() > 0) {
            this.designation = designation;
            return;
        }
        throw new TableException("invalid table designation! " + designation);
    }

    public String reserve(@NotNull LocalDate date, int anz) {
        if (date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now())) {
            if (anz <= getSeats()) {
                reservations.put(date, anz);
            } else {
                return null;
            }
        } else {
            return null;
        }
        return Table.this.getDesignation();
    }

    public boolean isReservedAt(LocalDate date) {
        return reservations.get(date) != null;
    }

    public boolean noReservations() {
        return reservations.size() == 0;
    }

    public int cancelReservation(LocalDate date) {
        int countPerson = 0;
        if (date == null) {
            for (Integer i : reservations.values()) {
                countPerson += i;
            }
            reservations.clear();
            return countPerson;
        }
        return reservations.containsKey(date) ? reservations.remove(date) : valueOf(0);
    }

    @Override
    public String toString() {
        return "Table{" + "designation='" + designation + '\'' + ", seats=" + seats + ", reservations=" + reservations + '}';
    }

    public String printInfo() {
        return Table.this.toString();
    }


    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Table table = (Table) o;
            result = getSeats() == table.getSeats() && Objects.equals(getDesignation(), table.getDesignation()) && Objects.equals(reservations, table.reservations);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDesignation(), getSeats(), reservations);
    }
}

@SuppressWarnings(value = "unused")
class Restaurant {
    List<Table> tables;

    @Contract(pure = true)
    public Restaurant() {
        tables = new ArrayList<>();
    }

    public static void main(String[] args) throws TableException {
        Restaurant r = new Restaurant();
        try {
            r.setUpTables(new Table("Table1", 5));
            r.setUpTables(new Table("Table2", 10));
            System.out.println(r.reserveTable(LocalDate.of(2023, 1, 5), 4));
            System.out.println(r.reserveTable(LocalDate.of(2023, 1, 5), 3));
            System.out.println(r.printEveryReservation(LocalDate.now(), "Table1"));
        } catch (TableException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTableDesigantion(int i) {
        return i >= 0 && i <= tables.size() ? tables.get(i).getDesignation() : "Not Found!";
    }

    public String print() {
        return tables.toString();
    }

    public void setUpTables(Table table) throws TableException {
        assert table != null : "Nothing was provided";
        assert tables.contains(table) : "Table is already in use";
        tables.add(table);
    }

    public String reserveTable(LocalDate date, int anz) throws TableException {
        for (Table t : tables) {
            if ((t.getSeats() >= anz) && !t.isReservedAt(date)) {
                return t.reserve(date, anz);
            }
        }
        throw new TableException("Out of tables!");
    }

    public int cancelReservation(String designation, LocalDate date) {
        for (Table t : tables)
            if (Objects.equals(t.getDesignation(), designation)) return t.cancelReservation(date);
        return 0;
    }

    public void removeUnusedTables() {
        tables.removeIf(Table::noReservations);
    }

    public List<Table> printEveryReservation(LocalDate date, String designation) {
        // This is going to be our returned ordered List
        List<Table> ordered = new ArrayList<>();

        // This is our sorting "algorithm" (few lines of code)
        List<String> ss;
        ss = this.tables.stream().map(Table::getDesignation).toList();

        ss.forEach(name -> tables.stream().filter(table -> table.getDesignation().equalsIgnoreCase(designation)).forEachOrdered(ordered::add));

        return ordered;
    }

    public void saveTables(String fileName) throws IOException {
        try (var fw = new FileWriter(fileName)) {
            for (Table t : tables) fw.write(t.toString() + System.lineSeparator());
        }
    }

    public void loadTables(String fileName) throws IOException, TableException {
        Restaurant r = new Restaurant();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            tables.clear();
            String line;
            while ((line = br.readLine()) != null) {
                r.setUpTables(Table.createTisch(line));
            }
        } catch (IOException e) {
            throw new IOException(e);
        } catch (TableException e) {
            throw new TableException(e.getMessage());
        }
    }

    public void saveSerialize(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tables);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void loadSerialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tables = (ArrayList<Table>) ois.readObject();
        } catch (IOException e) {
            throw new IOException(e);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(e.getMessage());
        }
    }
}

@SuppressWarnings(value = "unused")
class TestTable {
    Table t1;
    Table t2;
    Table t3;


    @BeforeEach
    void setUp() throws TableException {
        try {
            t1 = new Table("Table1", 4);
            t2 = new Table("Table2", 6);
            t3 = new Table("Table3", 3);
        } catch (TableException e) {
            throw new TableException(e.getMessage());
        }
    }

    @Test
    void TestT1GetDesignation() {
        assertEquals("Table1", t1.getDesignation());
    }

    @Test
    void TestT2GetDesignation() {
        assertEquals("Table2", t2.getDesignation());
    }

    @Test
    void TestT3GetDesignation() {
        assertEquals("Table3", t3.getDesignation());
    }

    @Test
    void TestT1GetSeats() {
        assertEquals(4, t1.getSeats());
    }

    @Test
    void TestT2GetSeats() {
        assertEquals(6, t2.getSeats());
    }

    @Test
    void TestT3GetSeats() {
        assertEquals(3, t3.getSeats());
    }

    @Test
    void TestReserve() {
        var t = t1.reserve(LocalDate.of(2023, 1, 3), 2);
        assertEquals("Table1", t);
    }

    @Test
    void TestIsReservedAt() {
        TestReserve(); // so that I don't have to rewrite my code in TestReserve() function
        assertTrue(t1.isReservedAt(LocalDate.of(2023, 1, 3)));
    }

    @Test
    void TestNoReservations() {
        assertTrue(t1.noReservations());
    }

    @Test
    void TestCancelReservation() {
        TestReserve(); // so that I don't have to rewrite my code in TestReserve() function
        assertEquals(2, t1.cancelReservation(LocalDate.of(2023, 1, 3)));
    }

    @Test
    void TestPrintInfo() {
        assertEquals("Table{designation='Table1', seats=4, reservations={}}", t1.printInfo());

    }

    @Test
    void TestSetDesignation() throws TableException {
        try {
            t1.setDesignation("Table11");
            assertEquals("Table11", t1.getDesignation());
        } catch (TableException e) {
            throw new TableException(e.getMessage());
        }
    }

    @Test
    void TestSetSeats() throws TableException {
        try {
            t1.setSeats(5);
            assertEquals(5, t1.getSeats());
        } catch (TableException e) {
            throw new TableException(e.getMessage());
        }
    }

}

@SuppressWarnings(value = "unused")
class TableException extends Exception {
    public TableException(String message) {
        super(message);
    }
}