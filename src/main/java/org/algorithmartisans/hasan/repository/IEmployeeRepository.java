package org.algorithmartisans.hasan.repository;

import org.algorithmartisans.hasan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByName(String name);

    boolean existsByLastName(String lastName);
    @Query(value = "from Employee",nativeQuery = false)
    List<Employee> findAllEmployee();

}
