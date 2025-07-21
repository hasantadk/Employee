package org.algorithmartisans.hasan.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.algorithmartisans.hasan.controller.IEmployeeController;
import org.algorithmartisans.hasan.dto.request.EmployeeRequest;
import org.algorithmartisans.hasan.dto.response.EmployeeResponse;
import org.algorithmartisans.hasan.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor()
public class EmployeeController implements IEmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping(path = "/Add")
    public ResponseEntity<Boolean> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeRequest));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequest));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

}
