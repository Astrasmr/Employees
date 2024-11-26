package ru.skypro.employees.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.employees.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    public Employee findMaxSalaryEmployeeByDepartment(
    int departmentId) {
        return null;

    }
    public Employee findMinSalaryEmployeeByDepartment(
                                                       int departmentId) {
        return null;

    }
    public Collection<Employee> findAllEmployeeByDepartment (
                                                             int departmentId) {
        return null;

    }

    public Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment (){
        return null;
    }

}


