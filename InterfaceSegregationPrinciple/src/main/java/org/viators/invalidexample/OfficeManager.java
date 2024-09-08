package org.viators.invalidexample;

import java.util.ArrayList;
import java.util.List;

public class OfficeManager {
    private final List<OfficeMachine> machines = new ArrayList<>();

    public void addMachine(OfficeMachine officeMachine) {
        machines.add(officeMachine);
    }

    // processDocument method tries to perform all possible operations on each machine,
    // catching exceptions for unsupported operations.
    public void processDocument(String document) {
        for (OfficeMachine machine : machines) {
            try {
                machine.print(document);
                machine.scan(document);
                machine.fax(document);
                machine.photocopy(document);
                machine.staple(document);
                machine.bind(document);
                machine.sortPages(document);
                machine.emailDocument(document, "panos@gmail.com");
            } catch (UnsupportedOperationException e) {
                System.out.println("Operation skipped: " + e.getMessage());
            }
        }
    }

    // performMaintenance method attempts to use methods that are not supported by all machines.
    public void performMaintenance() {
        for (OfficeMachine officeMachine : machines) {
            try {
                System.out.println("Checking paper levels...");
                int paper = officeMachine.getRemainingPaper();
                System.out.println("Remaining paper: " + paper);

                System.out.println("Checking ink levels...");
                int ink = officeMachine.getRemainingInk();
                System.out.println("Remaining ink: " + ink);

                if (paper < 100 || ink < 20) {
                    officeMachine.orderSupplies();
                }

                officeMachine.generateUsageReport();
            } catch (UnsupportedOperationException e) {
                System.out.println("Maintenance partially skipped: " + e.getMessage());
            }
        }
    }


}
