package spring.com.cua_hang_thuoc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.com.cua_hang_thuoc.dto.EmployeeDto;
import spring.com.cua_hang_thuoc.entity.Employee;
import spring.com.cua_hang_thuoc.generator.Generator;
import spring.com.cua_hang_thuoc.repo.EmployeeRepo;
import spring.com.cua_hang_thuoc.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> findAllDto() {
        return employeeRepo.findByStatusTrue().stream()
                .map(this::convertToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(String id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = convertToEmployee(employeeDto);
        employee.setEmpCode(Generator.getEmployeeCode(employeeRepo.getEmployeeCode()));
        return convertToEmployeeDto(employeeRepo.save(employee));
    }

    @Override
    public String delete(String id) {
        employeeRepo.setStatusFalse(id);
        return String.valueOf(id);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = convertToEmployee(employeeDto);
        return convertToEmployeeDto(employeeRepo.save(employee));
    }

    @Override
    public EmployeeDto convertToEmployeeDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public Employee convertToEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
}
