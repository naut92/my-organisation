package net.mem.my_organisation.services.impl;


import net.mem.my_organisation.model.Department;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository repository;

    @Test
    public void updateEmployee() {
        Employee sampleEmployee = new Employee();
        sampleEmployee.setFirstname("Susan");
        sampleEmployee.setLastname("Ivanova");
        sampleEmployee.setEmail("testemail@emeil.com");
        sampleEmployee.setPosition_id(1l);
        sampleEmployee.setDepartment_id(2l);

        Department department = new Department();
        Position position = new Position();
        sampleEmployee.setDepartmentById(department);
        sampleEmployee.setPositionById(position);


        when(repository.getOne(1L)).thenReturn(sampleEmployee);

        Employee e = employeeService.updateEmployee(1l, sampleEmployee);
        String fullName = e.getFirstname() + " " + e.getLastname();
        assertEquals("true", "Susan Ivanova", fullName);
    }

    @Test
    public void createEmployee() {
        Employee sampleEmployee = new Employee();
        sampleEmployee.setFirstname("Susan");
        sampleEmployee.setLastname("Ivanova");
        sampleEmployee.setEmail("testemail@emeil.com");
        sampleEmployee.setPosition_id(1l);
        sampleEmployee.setDepartment_id(2l);

        Department department = new Department();
        Position position = new Position();
        sampleEmployee.setDepartmentById(department);
        sampleEmployee.setPositionById(position);


        when(repository.getOne(1L)).thenReturn(sampleEmployee);

        Employee e = employeeService.createEmployee(sampleEmployee);
        String fullName = e.getFirstname() + " " + e.getLastname();
        assertEquals("true", "Susan Ivanova", fullName);
    }

    @Test
    public void deleteById() {

    }
}
