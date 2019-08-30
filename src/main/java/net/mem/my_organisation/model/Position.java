package net.mem.my_organisation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position_name;

    @Basic
    @Column(name = "department_id")
    private Long department_id;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department departmentById;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "positionById", cascade = CascadeType.ALL)
    private List<Employee> employeeById;
}
