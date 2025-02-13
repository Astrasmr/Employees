package ru.skypro.employees.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.skypro.employees.TestHelper;
import ru.skypro.employees.exception.EmployeeAlreadyAddedException;
import ru.skypro.employees.exception.EmployeeNotFoundException;
import ru.skypro.employees.exception.EmployeeStorageIsFullException;
import ru.skypro.employees.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeServiceTest {
    //тестируем объект employeeService
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    @DisplayName("Сотрудник добавлен")
    void addWorker() {
        Employee expected = TestHelper.getEmployee();
        //test
        employeeService.addWorker(expected.getName(), expected.getLastName(),
                expected.getSalary(), expected.getDepartment());
        //check
        Employee actual = employeeService.findWorker(expected.getName(), expected.getLastName());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Выбрасывается исключение если превышено максимальное количество сотрудников")
    void addWorker2() {
        Employee expected = TestHelper.getEmployee();
        for (int i = 0; i < 3; i++) {
            addEmployee();
        }
        //test
        assertThrowsExactly(EmployeeStorageIsFullException.class, () -> employeeService.addWorker(expected.getName(), expected.getLastName(),
                expected.getSalary(), expected.getDepartment()));

    }

    @Test
    @DisplayName("Выбрасывается исключение если такой сотрудник уже есть")
    void addWorker3() {
        Employee expected = addEmployee();
        //test
        assertThrowsExactly(EmployeeAlreadyAddedException.class,
                () -> employeeService.addWorker(expected.getName(),
                        expected.getLastName(),
                        expected.getSalary(), expected.getDepartment()));

    }

    @Test
    @DisplayName("Сотрудник успешно удален")
    void deleteWorker() {
        Employee expected = addEmployee();
        //test
        employeeService.deleteWorker(expected.getName(), expected.getLastName());
        //check
        Collection<Employee> all = employeeService.findAll();
        assertTrue(all.isEmpty());

    }

    @Test
    @DisplayName("Сотрудник для удаления не найден")
    void deleteWorker_2() {

        // test
        assertThrowsExactly(EmployeeNotFoundException.class,
                () -> employeeService.deleteWorker("Олег", "Бойчук"));

    }

    @Test
    @DisplayName("Сотрудник найден")
    void findWorker() {
        Employee expected = addEmployee();

        //test
        Employee actual = employeeService.findWorker(expected.getName(), expected.getLastName());

        //check
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Сотрудник не найден")
    void findWorker_2() {

        //test
        assertThrowsExactly(EmployeeNotFoundException.class,
                () -> employeeService.findWorker("Олег", "Бойчук"));
    }

    @Test
    @DisplayName("Находит всех сотрудников")
    void findAll() {
        Employee expected = addEmployee();
        Employee expected2 = addEmployee();
        Employee expected3 = addEmployee();

        //test
        Collection<Employee> actual = employeeService.findAll();


        //check
        assertThat(actual)
                .containsExactlyInAnyOrderElementsOf(List.of(expected, expected3, expected2));
    }

    private Employee addEmployee() {
        Employee expected = TestHelper.getEmployee();
        return employeeService.addWorker(expected.getName(), expected.getLastName(),
                expected.getSalary(), expected.getDepartment());

    }

}