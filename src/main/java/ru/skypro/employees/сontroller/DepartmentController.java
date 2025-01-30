package ru.skypro.employees.сontroller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.employees.model.Employee;
import ru.skypro.employees.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService service) {
        this.departmentService = service;
    }
    @GetMapping ("/{id}/salary/max")
    public Employee findMaxSalaryEmployeeByDepartment (@PathVariable ("id") int departmentId) {
        return departmentService.findMaxSalaryEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/{id}/salary/min")
    public Employee findMinSalaryEmployeeByDepartment (@PathVariable ("id") int departmentId) {
        return departmentService.findMinSalaryEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/{id}/employees")
    public Collection<Employee> findAllEmployeeByDepartment (@PathVariable ("id") int departmentId) {
        return departmentService.findAllEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/employees")
    public Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment (){
        return departmentService.findAllEmployeeGroupByDepartment();
    }
    @GetMapping ("/{id}/salary/sum")
    public int sumEmployeeSalaryByDepartment (@PathVariable ("id") int departmentId) {
        return departmentService.sumEmployeeSalaryByDepartment(departmentId);

    }

}
