package net.mem.my_organisation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    @Basic
    @Column(name = "department_id")
    private Long department_id;

    @Basic
    @Column(name = "position_name")
    private Long position_id;

    @Basic
    @Column(name = "pass")
    @Length(min = 5, max = 80, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    @JsonIgnore
    private String pass;

    @JsonIgnore
    private String passConfirm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department departmentById;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Department positionById;
}