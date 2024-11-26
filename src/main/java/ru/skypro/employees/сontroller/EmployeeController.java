package ru.skypro.employees.сontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.employees.model.Employee;
import ru.skypro.employees.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/add")
    public Employee addWorker(@RequestParam ("firstName") String firstName,
                              @RequestParam ("lastName") String lastName,
                              @RequestParam ("salary") int salary,
                              @RequestParam ("department") int department)
            {
        return employeeService.addWorker(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee deleteWorker(@RequestParam ("firstName") String firstName,
                                 @RequestParam ("lastName") String lastName) {
        return employeeService.deleteWorker(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findWorker(@RequestParam ("firstName") String firstName,
                               @RequestParam ("lastName") String lastName) {
        return employeeService.findWorker(firstName, lastName);
    }


}
