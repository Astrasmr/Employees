package ru.skypro.employees.service;

import ru.skypro.employees.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryEmployeeByDepartment(int departmentId);

    Employee findMinSalaryEmployeeByDepartment(int departmentId);

    Collection<Employee> findAllEmployeeByDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment();

    int sumEmployeeSalaryByDepartment(int departmentId);
}
