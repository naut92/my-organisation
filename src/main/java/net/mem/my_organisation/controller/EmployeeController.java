package net.mem.my_organisation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mem.my_organisation.model.Employee;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.services.EmployeeService;
import net.mem.my_organisation.services.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        log.info("Employee find: employeeId={}", employeeId);
        return employeeService.getEmployeeById(employeeId);
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

    //<-------- CRUD operations ----->

    @ApiOperation(value = "Update Employee")
    @PutMapping("/upd/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employee) {
        log.warn("Request to update Employee={}", employee);
        Employee result = employeeService.updateEmployee(employeeId, employee);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Add Employee")
    @PostMapping("/new/{employeeId}")
    public ResponseEntity<Employee> createEmployee
            (@Valid @RequestBody Employee employee) throws URISyntaxException {
        log.warn("Request to create Employee={}", employee);
        Employee result = employeeService.createEmployee(employee);
        return ResponseEntity.created(new URI("/employee/" + result.getId()))
                .body(result);
    }

    @ApiOperation(value = "Delete Employee")
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        log.info("Request to delete Employee={}", employeeId);
        try {
            employeeService.deleteById(employeeId);
        }catch (Exception e) {
            log.error("объект не удалён");
            e.getStackTrace();
        }
        return ResponseEntity.ok().build();
    }

}
