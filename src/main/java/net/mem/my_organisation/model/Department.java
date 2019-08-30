package net.mem.my_organisation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String depart_name;
    String position;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departmentById", cascade = CascadeType.ALL)
    private List<Employee> employeeById;
}
