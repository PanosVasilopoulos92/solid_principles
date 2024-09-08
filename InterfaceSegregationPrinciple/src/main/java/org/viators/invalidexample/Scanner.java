package org.viators.invalidexample;

// A scanner that only scans, also violating ISP
public class Scanner implements OfficeMachine {
    @Override
    public void print(String document) {
        throw new UnsupportedOperationException("Scanner cannot print");
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanner: Scanning " + document);
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("Scanner cannot fax");
    }

    @Override
    public void photocopy(String document) {
        throw new UnsupportedOperationException("Scanner cannot photocopy");
    }

    @Override
    public void staple(String document) {
        throw new UnsupportedOperationException("Scanner cannot staple");
    }

    @Override
    public void bind(String document) {
        throw new UnsupportedOperationException("Scanner cannot bind");
    }

    @Override
    public void sortPages(String document) {
        throw new UnsupportedOperationException("Scanner cannot sort pages");
    }

    @Override
    public void emailDocument(String document, String recipient) {
        System.out.println("Scanner: Emailing scanned " + document + " to " + recipient);
    }

    @Override
    public int getRemainingPaper() {
        throw new UnsupportedOperationException("Scanner does not use paper");
    }

    @Override
    public int getRemainingInk() {
        throw new UnsupportedOperationException("Scanner does not use ink");
    }

    @Override
    public void orderSupplies() {
        throw new UnsupportedOperationException("Scanner does not need regular supplies");
    }

    @Override
    public void generateUsageReport() {
        System.out.println("Scanner: Generating usage report");
    }
}
