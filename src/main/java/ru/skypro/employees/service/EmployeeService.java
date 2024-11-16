package ru.skypro.employees.service;

import org.springframework.stereotype.Service;
import ru.skypro.employees.exception.EmployeeAlreadyAddedException;
import ru.skypro.employees.exception.EmployeeNotFoundException;
import ru.skypro.employees.exception.EmployeeStorageIsFullException;
import ru.skypro.employees.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> workers = new ArrayList<>();
    private final int maxWorkersAmount = 2;

    public Employee addWorker(String firstName, String lastName) {
        if (workers.size()>=maxWorkersAmount){
            throw new EmployeeStorageIsFullException();
        }
Employee worker = new Employee(firstName, lastName);
        if (workers.contains(worker)){
            throw new EmployeeAlreadyAddedException();
        }

        workers.add(worker);
        return worker;


    }


    public Employee deleteWorker(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        if (!workers.contains(worker)){
            throw new EmployeeNotFoundException();
        }
         workers.remove(worker);
         return worker;
    }

    public Employee findWorker(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        int index = workers.indexOf(worker);
        if (index<0){
            throw new EmployeeNotFoundException();
        }
        return workers.get(index);
    }

}
