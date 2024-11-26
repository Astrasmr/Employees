package ru.skypro.employees.сontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping ("/max-salary")
    public Employee findMaxSalaryEmployeeByDepartment (@RequestParam ("departmentId")
                                                           int departmentId) {
        return departmentService.findMaxSalaryEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/min-salary")
    public Employee findMinSalaryEmployeeByDepartment (@RequestParam ("departmentId")
                                                       int departmentId) {
        return departmentService.findMinSalaryEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/all")
    public Collection<Employee> findAllEmployeeByDepartment (@RequestParam ("departmentId")
                                                       int departmentId) {
        return departmentService.findAllEmployeeByDepartment(departmentId);

    }
    @GetMapping ("/all")
    public Map<Integer, List<Employee>> findAllEmployeeGroupByDepartment (){
        return departmentService.findAllEmployeeGroupByDepartment();
    }
}
