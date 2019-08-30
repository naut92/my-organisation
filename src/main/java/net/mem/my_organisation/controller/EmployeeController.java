package net.mem.my_organisation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Api(value = "Employees App Management System", description="Operations pertaining to employee in Employees App Management System")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        employeeService = service;
    }

    //for dev-mode only:
    @ApiOperation(value = "View a list of available employees", response = List.class)
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
