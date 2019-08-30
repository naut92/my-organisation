package net.mem.my_organisation.services;

import net.mem.my_organisation.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Collection<Employee> getAllEmployees();

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    List<Employee> findEmployeeByPositionId(Long positionId);

    Employee updateEmployee(Long employeeId, Employee employee);

    Employee createEmployee(Employee employee);

    void deleteById(Long employeeId);

    Employee getEmployeeById(Long employeeId);
}
