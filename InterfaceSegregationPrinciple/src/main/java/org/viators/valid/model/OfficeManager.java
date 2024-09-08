package org.viators.valid.model;

import org.viators.valid.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class OfficeManager {
    private List<Object> devices = new ArrayList<>();

    public void addDevice(Object device) {
        devices.add(device);
    }

    public void performMaintenance() {
        for (Object device : devices) {
            if (device instanceof SupplyManageable supplyManageable) {
                System.out.println("Checking supplies for " + device.getClass().getSimpleName());
                int paper = supplyManageable.getRemainingPaper();
                int ink = supplyManageable.getRemainingInk();
                System.out.println("Remaining paper: " + paper + ", Remaining ink: " + ink);
                if (paper < 100 || ink < 20) {
                    supplyManageable.orderSupplies();
                }
            }

            if (device instanceof Reportable reportable) {
                reportable.generateUsageReport();
            }
        }
    }

    public void processDocument(String document) {
        for (Object device : devices) {
            if (device instanceof Printable) {
                ((Printable) device).print(document);
            }
            if (device instanceof Scanable scanable) {
                scanable.scan(document);
            }
            if (device instanceof Faxable faxable) {
                faxable.fax(document);
            }
            if (device instanceof Copyable copyable) {
                copyable.photocopy(document);
            }
            if (device instanceof DocumentFinisher docFinisher) {
                docFinisher.staple(document);
                docFinisher.bind(document);
                docFinisher.sortPages(document);
            }
            if (device instanceof Emailable emailable) {
                emailable.emailDocument(document, "panos@gmail.com");
            }
        }
    }
}
