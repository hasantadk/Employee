package org.algorithmartisans.hasan.repository;

import org.algorithmartisans.hasan.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public boolean existsByDepartmentName(String departmentName);
}
