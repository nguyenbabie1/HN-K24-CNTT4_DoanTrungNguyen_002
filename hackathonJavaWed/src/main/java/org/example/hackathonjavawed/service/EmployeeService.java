package org.example.hackathonjavawed.service;

import org.example.hackathonjavawed.dto.EmployeeDTO;
import org.example.hackathonjavawed.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private final Map<String, Employee> employeeMap = new LinkedHashMap<>();
    private int nextNumber = 1;

    public EmployeeService() {
        addSeed("Doan Trung Nguyen", "Fresher", 1000.0);
        addSeed("Vu Thu Trang", "Tester", 2000.0);
        addSeed("Hoang Thai Minh", "FullStack", 3000.0);
    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee findById(String id) {
        return employeeMap.get(id);
    }

    public EmployeeDTO toDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFullName(employee.getFullName());
        dto.setPosition(employee.getPosition());
        dto.setSalary(employee.getSalary());
        dto.setAvarta(employee.getAvarta());
        return dto;
    }

    public void add(EmployeeDTO dto) {
        String id = "NV" + String.format("%03d", nextNumber++);
        Employee employee = new Employee(id, dto.getFullName(), dto.getPosition(), dto.getSalary(), dto.getAvarta());
        employeeList.add(employee);
        employeeMap.put(id, employee);
    }

    public boolean update(String id, EmployeeDTO dto) {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            return false;
        }

        employee.setFullName(dto.getFullName());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());
        employee.setAvarta(dto.getAvarta());
        return true;
    }

    public boolean delete(String id) {
        Employee employee = employeeMap.remove(id);
        if (employee == null) {
            return false;
        }

        employeeList.removeIf(item -> item.getId().equals(id));
        return true;
    }

    private void addSeed(String fullName, String position, Double salary) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFullName(fullName);
        dto.setPosition(position);
        dto.setSalary(salary);
        dto.setAvarta("");
        add(dto);
    }
}
