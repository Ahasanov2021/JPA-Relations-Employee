package az.ingress.demo.service;

import az.ingress.demo.dto.EmployeeRequest;
import az.ingress.demo.dto.EmployeeResponse;
import az.ingress.demo.model.Employee;
import az.ingress.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    @Transactional
    public EmployeeResponse get(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with id" + employeeId + "not found!"));
        return modelMapper.map(employee, EmployeeResponse.class);

    }
}
