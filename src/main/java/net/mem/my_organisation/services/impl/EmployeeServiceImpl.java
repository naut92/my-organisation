package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.repository.EmployeeRepository;
import net.mem.my_organisation.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        employeeRepository = repository;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
