package net.mem.my_organisation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    @Basic
    @Column(name = "pass")
    @Length(min = 5, max = 80, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    @JsonIgnore
    private String pass;

    @JsonIgnore
    private String passConfirm;
}