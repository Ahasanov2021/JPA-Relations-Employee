package az.ingress.demo.controller;

import az.ingress.demo.dto.EmployeeRequest;
import az.ingress.demo.dto.EmployeeResponse;
import az.ingress.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest request){
        return employeeService.create(request);
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse get(@PathVariable Integer employeeId) {
        return employeeService.get(employeeId);
    }

}
