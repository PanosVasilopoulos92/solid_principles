package org.viators.valid.model;

import org.viators.valid.interfaces.Emailable;
import org.viators.valid.interfaces.Reportable;
import org.viators.valid.interfaces.Scanable;

// Scanner now implements only the interfaces it supports.
public class Scanner implements Scanable, Emailable, Reportable {

    @Override
    public void scan(String document) {
        System.out.println("Scanner: Scanning " + document);
    }

    @Override
    public void emailDocument(String document, String recipient) {
        System.out.println("Scanner: Emailing scanned " + document + " to " + recipient);
    }

    @Override
    public void generateUsageReport() {
        System.out.println("Scanner: Generating usage report");
    }
}
