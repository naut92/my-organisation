package net.mem.my_organisation.services.impl;

import net.mem.my_organisation.model.Department;
import net.mem.my_organisation.repository.DepartmentRepository;
import net.mem.my_organisation.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        departmentRepository = repository;
    }

    @Override
    public Collection<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
