package org.viators.invalidexample.lowlevelmodules;

import java.util.List;

public class MySQLDatabase {
    public void connect(){
        System.out.println("Connecting to MySQL database...");
    }

    public void executeQuery(String query){
        System.out.println("Executing query: " + query);
    }

    public List<String> fetchResults(String query) {
        System.out.println("Fetching results for query: " + query);
        return List.of("Result1", "Result2", "Result3");
    }
}
