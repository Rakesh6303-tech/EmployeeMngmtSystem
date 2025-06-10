package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    //Define GetEmployeeById Method
    EmployeeDto getEmployeeById(Long employeeId);
    // Define GetAllEmployees
    List<EmployeeDto> getAllEmployees();
    // Define UpdateEmployee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
    // Define Delete Method
    void deleteEmployee(Long employeeId);
}
