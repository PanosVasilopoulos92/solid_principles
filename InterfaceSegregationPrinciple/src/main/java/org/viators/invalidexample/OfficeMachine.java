package org.viators.invalidexample;

// This interface violates ISP by combining too many responsibilities
public interface OfficeMachine {
    void print(String document);
    void scan(String document);
    void fax(String document);
    void photocopy(String document);
    void staple(String document);
    void bind(String document);
    void sortPages(String document);
    void emailDocument(String document, String recipient);
    int getRemainingPaper();
    int getRemainingInk();
    void orderSupplies();
    void generateUsageReport();
}
