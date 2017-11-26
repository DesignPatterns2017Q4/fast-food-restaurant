package restaurant.service;

import java.util.concurrent.atomic.AtomicBoolean;

import restaurant.util.Constants;
import restaurant.util.Logger;
import restaurant.util.Random;

public class Table implements Comparable<Table> {
    private static int tableCounter = 0;
    private volatile AtomicBoolean free = new AtomicBoolean(true);
    private int tableSize;
    private final String name;

    public Table(int size) {
        tableSize = size;
        name = "Table" + tableCounter;
        Logger.logToConsole(toString() + " is created.");
    }

    public Table() {
        tableCounter++;
        setTableSize(Random.randInt(Constants.MIN_CLIENT_GROUP_SIZE, Constants.MAX_CLIENT_GROUP_SIZE));
        name = "Table" + tableCounter;
        Logger.logToConsole(toString() + " is created.");
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    @Override
    public int compareTo(Table table) {
        return tableSize - table.getTableSize();
    }

    public synchronized boolean isFree() {
        return free.get();
    }

    public synchronized void setFree(boolean free) {
        this.free.set(free);
    }

    @Override
    public String toString() {
        return name + "(Size: " + tableSize + ")";
    }

}
