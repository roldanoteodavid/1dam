package org.example.employeescollections;

public class Employee {
        private final String firstName;
        private final String lastName;
        public Employee(String firstName, String lastName) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
