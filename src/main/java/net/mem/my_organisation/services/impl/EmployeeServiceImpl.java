package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Department;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.repository.DepartmentRepository;
import net.mem.my_organisation.repository.EmployeeRepository;
import net.mem.my_organisation.repository.PositionRepository;
import net.mem.my_organisation.services.EmployeeService;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        if(employee != null) return employee;
        else throw new EntityNotFoundException();
    }

    @Override
    public Employee findEmployeeByEmail(String employeeEmail) {
        return employeeRepository.findEmployeeByEmail(employeeEmail);
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

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employeeUPD = employeeRepository.getOne(employeeId);
        Position position = positionRepository.getOne(employee.getPosition_id());
        Department department = departmentRepository.getOne(employee.getDepartment_id());

        employeeUPD.setPositionById(position);
        employeeUPD.setDepartmentById(department);
        employeeUPD.setFirstname(employee.getFirstname());
        employeeUPD.setLastname(employee.getLastname());
        employeeUPD.setEmail(employee.getEmail());
        employeeUPD.setDepartment_id(employee.getDepartment_id());
        employeeUPD.setPosition_id(employee.getPosition_id());

        String encPassword = "12A34";
        //BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        //String encPassword = pe.encode(employee.getPass());

        //System.out.println("encPassword: " + encPassword);
        employeeUPD.setPass(encPassword);

        Employee e = employeeRepository.save(employeeUPD);
        System.out.println("new Employee pass: " + employeeRepository.getOne(employeeId).getPass());

        return employeeUPD;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setDepartment_id(employee.getDepartment_id());
        employee.setPosition_id(employee.getPosition_id());
        //BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        //String encPassword = pe.encode(employee.getPass());
        //employee.setPass(encPassword);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
