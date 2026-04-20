package org.example.hackathonjavawed.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {
    private String id;

    @NotBlank(message = "Ho ten bat buoc nhap")
    @Size(min = 5, max = 50, message = "Ho ten phai tu 5 den 50 ky tu")
    private String fullName;

    @NotBlank(message = "Chuc vu khong duoc de trong")
    private String position;

    @NotNull(message = "Luong bat buoc nhap")
    @DecimalMin(value = "0.0", inclusive = false, message = "Luong phai lon hon 0")
    private Double salary;

    private String avarta;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String id, String fullName, String position, Double salary, String avarta) {
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
