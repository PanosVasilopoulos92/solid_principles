package org.viators.properway;

// The class is only responsible for interaction with database
public class EmployeeDatabase {
    public void saveEmployee(Employee employee) {
        // will need code here in order to save in DB
        System.out.printf("Employee with name %s was successfully saved to database"
                .formatted(employee.name()));
    }
}
