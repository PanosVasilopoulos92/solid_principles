package org.viators.invalidexample;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void saveEmployeeToDB(Employee employee) {
        // will need code here in order to save in DB
        System.out.printf("Employee with name %s was successfully saved to database"
                .formatted(employee.name));
    }

    public void generateEmployeeInfo(Employee employee) {
        // will need code here in order to generate the report
        System.out.printf("""
                Name: %s
                Age: %d
                """.formatted(employee.name, employee.age));
    }

}
