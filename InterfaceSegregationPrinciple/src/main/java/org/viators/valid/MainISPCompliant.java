package org.viators.valid;

import org.viators.valid.model.BasicPrinter;
import org.viators.valid.model.HighEndPrinter;
import org.viators.valid.model.OfficeManager;
import org.viators.valid.model.Scanner;

/*
   Interface Segregation Principle (ISP):
   This principle states that no client should be forced to depend on methods it does not use. In other words,
   many client-specific interfaces are better than one general-purpose interface.

   What we achieve with this approach (following the Interface Segregation Principle):
1. Separated Interfaces: Instead of one large OfficeMachine interface, we now have several smaller,
   focused interfaces (Printable, Scanable, Faxable, etc.). Each interface represents a single responsibility.
2. Flexible Implementation: Each device class (HighEndPrinter, BasicPrinter, Scanner) now implements only the
   interfaces relevant to its capabilities. This eliminates the need for throwing UnsupportedOperationException
   for unsupported methods.
3. No Forced Implementation: The BasicPrinter and Scanner classes no longer need to implement methods they
   don't support, adhering to ISP.
4. Enhanced Extensibility: New functionalities can be added by creating new interfaces without affecting existing
   classes that don't need those functionalities.
5. Reduced Exception Handling.
6. Flexibility: It's easier to add new types of devices or new functionalities without breaking existing code.
7. Maintainability: Changes to one functionality (e.g., printing) don't affect unrelated functionalities (e.g., scanning).
8. Testability: It's easier to mock and test individual functionalities.
*/

public class MainISPCompliant {

    public static void main(String[] args) {
        OfficeManager manager = new OfficeManager();

        manager.addDevice(new HighEndPrinter());
        manager.addDevice(new BasicPrinter());
        manager.addDevice(new Scanner());

        System.out.println("Performing maintenance...");
        manager.performMaintenance();

        System.out.println("\nProcessing document...");
        manager.processDocument("Important Report");
    }
}
