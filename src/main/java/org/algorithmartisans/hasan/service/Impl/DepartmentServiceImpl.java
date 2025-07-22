package org.algorithmartisans.hasan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.algorithmartisans.hasan.dto.request.DepartmentRequest;
import org.algorithmartisans.hasan.dto.response.DepartmentResponse;
import org.algorithmartisans.hasan.exception.model.BusinessException;
import org.algorithmartisans.hasan.exception.model.NotFoundException;
import org.algorithmartisans.hasan.model.Department;
import org.algorithmartisans.hasan.repository.DepartmentRepository;
import org.algorithmartisans.hasan.service.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public boolean addDepartment(DepartmentRequest departmentRequest) throws BusinessException {
        if (departmentRequest == null) {
            throw new BusinessException("Departman request objesi boş olamaz");
        }

        if (departmentRequest.getDepartmentName() == null || departmentRequest.getDepartmentName().trim().isEmpty()) {
            throw new BusinessException("Departman ismi boş kayıt yapılamıyor");
        }

        if (departmentRepository.existsByDepartmentName(departmentRequest.getDepartmentName().trim())) {
            throw new BusinessException(departmentRequest.getDepartmentName() +
                    " adında bir departman bulunmaktadır, tekrar kayıt yapamazsınız");
        }

        try {
            Department department = new Department();
            department.setDepartmentName(departmentRequest.getDepartmentName().trim());
            departmentRepository.save(department);
            return true;
        } catch (Exception e) {
            throw new BusinessException("Departman kaydedilirken bir hata oluştu: " + e.getMessage());
        }
    }


    @Override
    public boolean deleteDepartment(Long id) throws NotFoundException {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException(+id + " değerine sahip departman bulunamadı.");
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest departmentRequest) throws BusinessException {
        if (departmentRequest.getDepartmentName() == null || departmentRequest.getDepartmentName().isBlank()) {
            throw new BusinessException("departman adı boş olamaz");
        }
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " ID'li departman bulunamadı"));

        return new DepartmentResponse(department.getId(), department.getDepartmentName());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) throws BusinessException {
        if (!departmentRepository.existsById(id)) {
            throw new NotFoundException(id + " ID'li departman bulunamadı");
        }
        Department department = departmentRepository.findById(id).get();
        return new DepartmentResponse(department.getId(), department.getDepartmentName());
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() throws BusinessException {
        if (departmentRepository.findAll().isEmpty()) {
            throw new BusinessException("Repositoryde deger bulunmuyor");
        }
        return departmentRepository.findAll().stream().map(department -> new DepartmentResponse(department.getId(), department.getDepartmentName())).toList();
    }

}
