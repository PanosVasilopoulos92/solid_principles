package org.viators.invalidexample;

// A basic printer that has to implement all methods declared in the interface,
// even though it cannot implement most of these methods/functionalities.
// A clear violation of the ISP.
public class BasicPrinter implements OfficeMachine{
    @Override
    public void print(String document) {
        System.out.println("BasicPrinter: Printing " + document);
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot scan");
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot fax");
    }

    @Override
    public void photocopy(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot photocopy");
    }

    @Override
    public void staple(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot staple");
    }

    @Override
    public void bind(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot bind");
    }

    @Override
    public void sortPages(String document) {
        throw new UnsupportedOperationException("BasicPrinter cannot sort pages");
    }

    @Override
    public void emailDocument(String document, String recipient) {
        throw new UnsupportedOperationException("BasicPrinter cannot email documents");
    }

    @Override
    public int getRemainingPaper() {
        return 100;
    }

    @Override
    public int getRemainingInk() {
        return 10;
    }

    @Override
    public void orderSupplies() {
        System.out.println("BasicPrinter: Ordering supplies");
    }

    @Override
    public void generateUsageReport() {
        throw new UnsupportedOperationException("BasicPrinter cannot generate usage reports");
    }
}
