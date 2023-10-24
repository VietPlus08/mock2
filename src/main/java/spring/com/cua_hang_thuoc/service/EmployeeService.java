package spring.com.cua_hang_thuoc.service;

import spring.com.cua_hang_thuoc.dto.EmployeeDto;
import spring.com.cua_hang_thuoc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAllDto();
    Employee findById(String id);
    EmployeeDto save(EmployeeDto employeeDto);
    String delete(String id);
    EmployeeDto update(EmployeeDto employeeDto);
    EmployeeDto convertToEmployeeDto(Employee employee);
    Employee convertToEmployee(EmployeeDto employeeDto);
}
