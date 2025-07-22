package org.algorithmartisans.hasan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
