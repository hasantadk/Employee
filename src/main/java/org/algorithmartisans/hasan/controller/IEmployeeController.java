package org.algorithmartisans.hasan.controller;

import org.algorithmartisans.hasan.dto.request.EmployeeRequest;
import org.algorithmartisans.hasan.dto.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeController {
    ResponseEntity<List<EmployeeResponse>> getAllEmployees();

    ResponseEntity<Boolean> addEmployee(EmployeeRequest employeeRequest);

    ResponseEntity<Boolean> deleteEmployee(Long id);

    ResponseEntity<Boolean> updateEmployee(Long id, EmployeeRequest employeeRequest);

    ResponseEntity<EmployeeResponse> getEmployeeById(Long id);

}
