package org.algorithmartisans.hasan.service;

import org.algorithmartisans.hasan.dto.request.EmployeeRequest;
import org.algorithmartisans.hasan.dto.response.EmployeeResponse;

import java.util.List;


public interface IEmployeeService {
    public List<EmployeeResponse> getAllEmployees();
    public boolean addEmployee(EmployeeRequest employeeRequest);
    public boolean deleteEmployee(Long id);
    public boolean updateEmployee(Long id ,EmployeeRequest employeeRequest);
    public EmployeeResponse getEmployeeById(Long id);

}
