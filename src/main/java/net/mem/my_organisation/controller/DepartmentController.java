package net.mem.my_organisation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mem.my_organisation.model.Department;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Api(value = "Employees App Management System", description="Operations pertaining to department in Employees App Management System")
public class DepartmentController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService service) {
        departmentService = service;
    }

    //for dev-mode only:
    @ApiOperation(value = "View a list of available departments", response = List.class)
    @GetMapping("/departments")
    public Collection<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
}
