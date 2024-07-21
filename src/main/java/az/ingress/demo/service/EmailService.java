package az.ingress.demo.service;

import az.ingress.demo.dto.EmailRequest;
import az.ingress.demo.dto.EmailResponse;
import az.ingress.demo.model.Email;
import az.ingress.demo.model.Employee;
import az.ingress.demo.repository.EmailRepository;
import az.ingress.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final ModelMapper modelMapper;
    private final EmailRepository emailRepository;
    private final EmployeeRepository employeeRepository;

    public EmailResponse create(Integer employeeId, EmailRequest request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with id" + employeeId + "not found!"));
        Email email = modelMapper.map(request, Email.class);
        email.setEmployee(employee);
        employee.getEmailList().add(email);
        employeeRepository.save(employee);
        emailRepository.save(email);
        return modelMapper.map(email, EmailResponse.class);
    }
}
