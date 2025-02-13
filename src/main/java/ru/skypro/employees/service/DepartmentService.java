package ru.skypro.employees.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.employees.exception.EmployeeNotFoundException;
import ru.skypro.employees.model.Employee;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService service;
    public DepartmentService (EmployeeService service)  {
        this.service = service;

    }

    public Employee findMaxSalaryEmployeeByDepartment(int departmentId) {
        return service.findAll().stream()
                .filter(s->s.getDepartment()== departmentId)
                       .max(Comparator.comparingInt(Employee::getSalary))
                       .orElseThrow(EmployeeNotFoundException::new);
    }
    public Employee findMinSalaryEmployeeByDepartment(int departmentId) {
        return service.findAll().stream()
                .filter(s->s.getDepartment()== departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    public Collection<Employee> findAllEmployeeByDepartment(int departmentId) {
    return service.findAll().stream()
            .filter(x -> x.getDepartment() == departmentId)
            .toList();

    }

    public Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment() {
        return service.findAll().stream()
                .collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.toList()));
    }
}


