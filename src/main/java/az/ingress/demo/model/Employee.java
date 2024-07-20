package az.ingress.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String lastname;

    Integer age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Phone> phoneList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Email> emailList;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    List<Role> roles;

}
