package net.mem.my_organisation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.mem.my_organisation.model.Position;
import net.mem.my_organisation.services.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Api(value = "Employees App Management System", description="Operations pertaining to position in Employees App Management System")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService ps) {
        positionService = ps;
    }

    //for dev-mode only:
    @ApiOperation(value = "View a list of available positions", response = List.class)
    @GetMapping("/positions")
    public Collection<String> getAllPositions(){
        return positionService.getAllPositions();
    }
}
