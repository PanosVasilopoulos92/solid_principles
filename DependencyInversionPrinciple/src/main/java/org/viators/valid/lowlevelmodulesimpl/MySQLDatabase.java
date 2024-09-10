package org.viators.valid.lowlevelmodulesimpl;

import org.viators.valid.lowlevelmodulesinterfaces.Database;

import java.util.List;

// Concrete implementation of a low level interface (Database)
public class MySQLDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    @Override
    public List<String> fetchResults(String query) {
        System.out.println("Fetching results for query: " + query);
        return List.of("Result1", "Result2", "Result3");
    }
}
