package ru.skypro.employees.service;

import org.springframework.stereotype.Service;
import ru.skypro.employees.exception.EmployeeNotFoundException;
import ru.skypro.employees.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService service;
    public DepartmentServiceImpl(EmployeeService service)  {
        this.service = service;

    }

    @Override
    public Employee findMaxSalaryEmployeeByDepartment(int departmentId) {
        return service.findAll().stream()
                .filter(s->s.getDepartment()== departmentId)
                       .max(Comparator.comparingInt(Employee::getSalary))
                       .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Employee findMinSalaryEmployeeByDepartment(int departmentId) {
        return service.findAll().stream()
                .filter(s->s.getDepartment()== departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Collection<Employee> findAllEmployeeByDepartment(int departmentId) {
    return service.findAll().stream()
            .filter(x -> x.getDepartment() == departmentId)
            .toList();

    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment() {
        return service.findAll().stream()
                .collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.toList()));
    }
    @Override
    public int sumEmployeeSalaryByDepartment(int departmentId) {
        return service.findAll().stream()
                .filter(x -> x.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();

    }
}


