package ru.skypro.employees.service;

import ru.skypro.employees.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addWorker(String firstName, String lastName, int salary, int department);

    Employee deleteWorker(String firstName, String lastName);

    Employee findWorker(String firstName, String lastName);

    Collection<Employee> findAll();
}
