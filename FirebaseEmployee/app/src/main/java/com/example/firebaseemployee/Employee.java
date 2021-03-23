package com.example.firebaseemployee;

public class Employee {
    private String lastName, firstName;

    public Employee() {
        this.lastName = "empty";
        this.firstName = "empty";
    }

    Employee(String lName, String fName) {
        this.lastName = lName;
        this.firstName = fName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(String empID) {
        return "Employee #: "+ empID + "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName +"\n \n";
    }
}