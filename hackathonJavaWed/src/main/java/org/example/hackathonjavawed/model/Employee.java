package org.example.hackathonjavawed.model;

public class Employee {
    private String id;
    private String fullName;
    private String position;
    private Double salary;
    private String avarta;

    public Employee() {
    }

    public Employee(String id, String fullName, String position, Double salary, String avarta) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.avarta = avarta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAvarta() {
        return avarta;
    }

    public void setAvarta(String avarta) {
        this.avarta = avarta;
    }
}
