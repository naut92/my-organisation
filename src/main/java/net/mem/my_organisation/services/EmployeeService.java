package net.mem.my_organisation.services;

import net.mem.my_organisation.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Collection<Employee> getAllEmployees();

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    List<Employee> findEmployeeByPositionId(Long positionId);
}
