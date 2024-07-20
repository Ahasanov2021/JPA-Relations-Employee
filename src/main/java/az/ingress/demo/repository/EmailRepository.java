package az.ingress.demo.repository;

import az.ingress.demo.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {




}
