package ru.skypro.employees;

import com.github.javafaker.Faker;
import ru.skypro.employees.model.Employee;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class TestHelper {
    private static final Faker faker = new Faker();
    public static Employee getEmployee () {
        return new Employee (faker.funnyName().name(),faker.artist().name(), nextInt(), nextInt());
    }
}
