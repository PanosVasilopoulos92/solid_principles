package org.viators.invalidexample;

/*
This example illustrates several problems caused by violating ISP:
1. Implementation Burden: Classes are forced to implement methods they don't use.
2. False Promises: The interface suggests capabilities that some implementers don't actually have.
3. Exception Handling Complexity: Client code must handle numerous exceptions for unsupported operations.
4. Reduced Flexibility: Adding new capabilities to the interface forces all implementers to update,
   even if they don't need the new capability.
5. Violation of Liskov Substitution Principle: Subclasses are not fully substitutable for the base interface
   due to throwing exceptions.
*/

public class MainISPViolationExample {

    public static void main(String[] args) {
        OfficeManager officeManager = new OfficeManager();

        officeManager.addMachine(new HighEndPrinter());
        officeManager.addMachine(new BasicPrinter());
        officeManager.addMachine(new Scanner());

        System.out.println("Performing maintenance...");
        officeManager.performMaintenance();

        System.out.println("\nProcessing document...");
        officeManager.processDocument("Important Report");
    }

}
