package org.algorithmartisans.hasan.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.algorithmartisans.hasan.dto.request.DepartmentRequest;
import org.algorithmartisans.hasan.dto.response.DepartmentResponse;
import org.algorithmartisans.hasan.service.IDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController implements org.algorithmartisans.hasan.controller.DepartmentController {
    private final IDepartmentService departmentService;


    @Override
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @Override
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @Override
    @PostMapping(path = "/add")
    public ResponseEntity<Boolean> addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.addDepartment(departmentRequest));
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentRequest));
    }
}
