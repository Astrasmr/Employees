package ru.skypro.employees.service;

import org.springframework.stereotype.Service;
import ru.skypro.employees.EmployeesApplication;
import ru.skypro.employees.exception.EmployeeAlreadyAddedException;
import ru.skypro.employees.exception.EmployeeNotFoundException;
import ru.skypro.employees.exception.EmployeeStorageIsFullException;
import ru.skypro.employees.model.Employee;

import java.util.*;

import static java.util.Collections.unmodifiableCollection;

@Service
public class EmployeeService {
    private final Map<String, Employee> workers = new HashMap<>();
    private final int maxWorkersAmount = 10;

    public Employee addWorker(String firstName, String lastName, int salary, int department) {
        if (workers.size() >= maxWorkersAmount) {
            throw new EmployeeStorageIsFullException();
        }
        Employee worker = new Employee(firstName, lastName, salary, department);
        String key = getKey(worker);
        if (workers.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        workers.put(key, worker);
        return worker;


    }
    public Employee deleteWorker(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!workers.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return workers.remove(key);
    }

    public Employee findWorker(String firstName, String lastName) {
        Employee employee = workers.get(getKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public Collection<Employee> findAll() {
       return unmodifiableCollection(workers.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    private String getKey(Employee employee) {
        return getKey(employee.getName(), employee.getLastName());
    }
}
