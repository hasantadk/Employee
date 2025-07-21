package org.algorithmartisans.hasan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.algorithmartisans.hasan.dto.request.EmployeeRequest;
import org.algorithmartisans.hasan.dto.response.EmployeeResponse;
import org.algorithmartisans.hasan.exception.model.BusinessException;
import org.algorithmartisans.hasan.exception.model.NotFoundException;
import org.algorithmartisans.hasan.model.Employee;
import org.algorithmartisans.hasan.repository.IEmployeeRepository;
import org.algorithmartisans.hasan.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Override
    public boolean addEmployee(EmployeeRequest employeeRequest)  throws BusinessException {
        if (employeeRequest.getName() == null || employeeRequest.getLastName() == null) {
            throw new BusinessException("isim ya da soy isim alanları boş olamaz");
        }

        else if (employeeRepository.existsByName(employeeRequest.getName()) && employeeRepository.existsByLastName(employeeRequest.getLastName())) {
            throw new BusinessException("aynı isim soysimde kışı olduğu için kayıt işlemi gerçekleşmedi");

        }
        else if (!employeeRepository.existsByName(employeeRequest.getName()) || !employeeRepository.existsByLastName(employeeRequest.getLastName())) {
            Employee addEmployee = new Employee();
            addEmployee.setName(employeeRequest.getName());
            addEmployee.setLastName(employeeRequest.getLastName());
            employeeRepository.save(addEmployee);
            return true;
        }
        else {
            throw new BusinessException("herhangi bir nedenden dolayı kayıt işlemi geröekleşmedi");
        }
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAllEmployee().stream().map(employee -> new EmployeeResponse(employee.getId(), employee.getName(), employee.getLastName())).toList();

    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employeeRepository.findById(id).map(employee -> {
            employeeRepository.deleteById(id);
            return true;
        }).orElseThrow(() -> new NotFoundException("Employee not found"));
    }

    @Override
    public boolean updateEmployee(Long id, EmployeeRequest employeeRequest) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeRequest.getName());
            employee.setLastName(employeeRequest.getLastName());
            employeeRepository.save(employee);
            return true;
        }).orElseThrow(() -> new NotFoundException(+id+":id değerine sahip kullanıcı bulunamadı"));


    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        return employeeRepository.findById(id).map(employee -> new EmployeeResponse(employee.getId(), employee.getName(), employee.getLastName())).orElseThrow(() -> new NotFoundException("ID: " + id + " değerine sahip çalışan bulunamadı"));
    }


}
