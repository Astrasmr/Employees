package ru.skypro.employees.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.employees.TestHelper;
import ru.skypro.employees.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;


    @Test
    @DisplayName("Находит сотрудника с самой большой зарплатой по департаментам")
    void findMaxSalaryEmployeeByDepartment() {
        int department = 3;
        Employee firstEmployee = TestHelper.getEmployee(400000,department);
        Employee secondEmployee = TestHelper.getEmployee(350000,department);
        Employee thirdEmployee = TestHelper.getEmployee(600000,1);
        List<Employee> allEmployee = List.of(secondEmployee,thirdEmployee,firstEmployee);

        Mockito.when(employeeService.findAll()).thenReturn(allEmployee);
        //test
        Employee actual = departmentService.findMaxSalaryEmployeeByDepartment(department);
        //check
        Assertions.assertThat(actual).isEqualTo(firstEmployee);


    }

    @Test
    @DisplayName("Находит сотрудника с самой маленькой зарплатой по департаментам")
    void findMinSalaryEmployeeByDepartment() {
            int department = 3;
            Employee firstEmployee = TestHelper.getEmployee(500000,department);
            Employee secondEmployee = TestHelper.getEmployee(350000,department);
            Employee thirdEmployee = TestHelper.getEmployee(100000,1);
            List<Employee> allEmployee = List.of(secondEmployee,thirdEmployee,firstEmployee);

            Mockito.when(employeeService.findAll()).thenReturn(allEmployee);
            //test
            Employee actual = departmentService.findMinSalaryEmployeeByDepartment(department);
            //check
            Assertions.assertThat(actual).isEqualTo(secondEmployee);
    }

    @Test
    @DisplayName("Находит сотрудников по департаментам")
    void findAllEmployeeByDepartment() {
        int department = 3;
        Employee firstEmployee = TestHelper.getEmployee(500000,department);
        Employee secondEmployee = TestHelper.getEmployee(350000,department);
        Employee thirdEmployee = TestHelper.getEmployee(120000,1);
        List<Employee> allEmployee = List.of(secondEmployee,thirdEmployee,firstEmployee);

        Mockito.when(employeeService.findAll()).thenReturn(allEmployee);
        //test
        Collection <Employee> actual = departmentService.findAllEmployeeByDepartment(department);
        //check
        Assertions.assertThat(actual).containsExactlyInAnyOrder(firstEmployee, secondEmployee);
    }

    @Test
    @DisplayName("Находит всех сгруппированных сотрудников по департаментам")
    void findAllEmployeeGroupByDepartment() {
        int department = 1;
        int departmentA = 2;
        Employee firstEmployee = TestHelper.getEmployee(500000,department);
        Employee secondEmployee = TestHelper.getEmployee(350000,departmentA);
        Employee thirdEmployee = TestHelper.getEmployee(100000,department);
        Employee fourthEmployee = TestHelper.getEmployee(150000,departmentA);
        List<Employee> allEmployee = List.of(secondEmployee,thirdEmployee,firstEmployee,fourthEmployee);
        Mockito.when(employeeService.findAll()).thenReturn(allEmployee);
        //test
        Map<Integer, List<Employee>> actual = departmentService.findAllEmployeeGroupByDepartment();
        //check
        Assertions.assertThat(actual)
                .hasSize(2)
                .containsEntry(departmentA,List.of(secondEmployee,fourthEmployee))
                .containsEntry(department, List.of(thirdEmployee, firstEmployee));
    }

    @Test
    @DisplayName("Находит сумму зарплат всех сотрудников по департаменту")
    void sumEmployeeSalaryByDepartment() {
        int departmentS = 2;
        Employee firstEmployee = TestHelper.getEmployee(500000,2);
        Employee secondEmployee = TestHelper.getEmployee(350000,2);
        Employee thirdEmployee = TestHelper.getEmployee(600000,1);
        List<Employee> allEmployee = List.of(secondEmployee,thirdEmployee,firstEmployee);

        Mockito.when(employeeService.findAll()).thenReturn(allEmployee);
        //test
        Integer actual = departmentService.sumEmployeeSalaryByDepartment(departmentS);
        //check
        Assertions.assertThat(actual).isEqualTo(firstEmployee.getSalary()+secondEmployee.getSalary());


    }
}