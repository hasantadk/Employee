package org.algorithmartisans.hasan.controller;

import org.algorithmartisans.hasan.dto.request.DepartmentRequest;
import org.algorithmartisans.hasan.dto.response.DepartmentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentController {
    ResponseEntity<List<DepartmentResponse>> getAllDepartments();

    ResponseEntity<DepartmentResponse> getDepartmentById(Long id);

    ResponseEntity<Boolean> addDepartment(DepartmentRequest departmentRequest);

    ResponseEntity<Boolean> deleteDepartment(Long id);

    ResponseEntity<DepartmentResponse> updateDepartment(Long id, DepartmentRequest departmentRequest);
}
