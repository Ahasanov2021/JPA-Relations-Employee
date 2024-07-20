package az.ingress.demo.repository;

import az.ingress.demo.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {


}
