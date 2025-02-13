package ru.skypro.employees;

import com.github.javafaker.Faker;
import ru.skypro.employees.model.Employee;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class TestHelper {
    public static Employee getEmployee () {
        return getEmployee(nextInt(0,1000000), nextInt(1,100));
    }
    public static Employee getEmployee (int salary, int department) {
        return new Employee(randomAlphanumeric(12),
                randomAlphanumeric(12),
                salary,
                department);
    }
}
