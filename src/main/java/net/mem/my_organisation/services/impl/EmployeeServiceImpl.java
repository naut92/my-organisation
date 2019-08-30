package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Department;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.repository.DepartmentRepository;
import net.mem.my_organisation.repository.EmployeeRepository;
import net.mem.my_organisation.repository.PositionRepository;
import net.mem.my_organisation.services.EmployeeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository repository, DepartmentRepository dr, PositionRepository pr) {
        this.employeeRepository = repository;
        this.departmentRepository = dr;
        this.positionRepository = pr;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(Long departmentId) {
        Department d = departmentRepository.getOne(departmentId);
        if(d != null) return d.getEmployeeById();
        else throw new EntityNotFoundException();
    }

    @Override
    public List<Employee> findEmployeeByPositionId(Long positionId) {
        Position p = positionRepository.getOne(positionId);
        if(p != null) return p.getEmployeeById();
        else throw new EntityNotFoundException();
    }
}
