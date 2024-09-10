package org.viators.valid.lowlevelmodulesinterfaces;

import java.util.List;

public interface Database {
    void connect();
    void executeQuery(String query);
    List<String> fetchResults(String query);
}
