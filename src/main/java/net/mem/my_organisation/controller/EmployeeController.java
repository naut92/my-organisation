package net.mem.my_organisation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.services.EmployeeService;
import net.mem.my_organisation.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Api(value = "Employees App Management System", description="Operations pertaining to employee in Employees App Management System")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService s, PositionService ps) {
        this.employeeService = s;
        this.positionService = ps;
    }

    //for dev-mode only:
    @ApiOperation(value = "View a list of available employees", response = List.class)
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //for dev-mode only:
    @ApiOperation(value = "View a list of available positions", response = List.class)
    @GetMapping("/positions")
    public Collection<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/position/{positionId}")
    public List<Employee> findEmployeeByPositionId(@PathVariable("positionId") Long positionId) {
        log.info("Employee find: positionId={}", positionId);
        return employeeService.findEmployeeByPositionId(positionId);
    }

}
