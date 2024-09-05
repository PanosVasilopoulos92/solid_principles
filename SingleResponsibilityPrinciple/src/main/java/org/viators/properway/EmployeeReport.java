package org.viators.properway;

// The class is only responsible for generating reports
public class EmployeeReport {
    public void generateEmployeeInfo(Employee employee) {
        // will need code here in order to generate the report
        System.out.printf("""
                Name: %s
                Age: %d
                """.formatted(employee.name(), employee.age()));
    }
}
