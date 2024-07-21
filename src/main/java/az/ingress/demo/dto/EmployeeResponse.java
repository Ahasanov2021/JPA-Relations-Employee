package az.ingress.demo.dto;

import az.ingress.demo.model.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {

    Integer id;

    String name;

    String lastname;

    Integer age;

    Gender gender;

}
