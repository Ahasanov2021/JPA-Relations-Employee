package az.ingress.demo.controller;

import az.ingress.demo.dto.EmailRequest;
import az.ingress.demo.dto.EmailResponse;
import az.ingress.demo.dto.EmployeeRequest;
import az.ingress.demo.dto.EmployeeResponse;
import az.ingress.demo.service.EmailService;
import az.ingress.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/{employeeId}")
    public EmailResponse create(@PathVariable Integer employeeId, @RequestBody EmailRequest request){
        return emailService.create(employeeId, request);
    }


}
