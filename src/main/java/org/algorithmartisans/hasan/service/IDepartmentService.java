package org.algorithmartisans.hasan.service;

import org.algorithmartisans.hasan.dto.request.DepartmentRequest;
import org.algorithmartisans.hasan.dto.response.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {
    public boolean addDepartment(DepartmentRequest departmentRequest);

    public boolean deleteDepartment(Long id);

    public DepartmentResponse updateDepartment(Long id, DepartmentRequest departmentRequest);

    public DepartmentResponse getDepartmentById(Long id);

    public List<DepartmentResponse> getAllDepartments();
}
