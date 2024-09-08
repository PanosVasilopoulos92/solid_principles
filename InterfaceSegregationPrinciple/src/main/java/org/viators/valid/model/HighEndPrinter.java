package org.viators.valid.model;

import org.viators.valid.interfaces.*;

// HighEndPrinter class now will implement only the interfaces that it wants to use.
public class HighEndPrinter implements Printable, Scanable, Faxable,
        Copyable, DocumentFinisher, Emailable, SupplyManageable, Reportable {
    @Override
    public void print(String document) {
        System.out.println("HighEndPrinter: Printing " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("HighEndPrinter: Scanning " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("HighEndPrinter: Faxing " + document);
    }

    @Override
    public void photocopy(String document) {
        System.out.println("HighEndPrinter: Photocopying " + document);
    }

    @Override
    public void staple(String document) {
        System.out.println("HighEndPrinter: Stapling " + document);
    }

    @Override
    public void bind(String document) {
        System.out.println("HighEndPrinter: Binding " + document);
    }

    @Override
    public void sortPages(String document) {
        System.out.println("HighEndPrinter: Sorting pages of " + document);
    }

    @Override
    public void emailDocument(String document, String recipient) {
        System.out.println("HighEndPrinter: Emailing " + document + " to " + recipient);
    }

    @Override
    public int getRemainingPaper() {
        return 180;
    }

    @Override
    public int getRemainingInk() {
        return 44;
    }

    @Override
    public void orderSupplies() {
        System.out.println("HighEndPrinter: Ordering supplies");
    }

    @Override
    public void generateUsageReport() {
        System.out.println("HighEndPrinter: Generating usage report");
    }
}
