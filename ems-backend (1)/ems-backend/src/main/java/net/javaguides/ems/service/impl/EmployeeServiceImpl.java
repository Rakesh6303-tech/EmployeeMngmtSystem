package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service    //This Annotation tells spring  conatiner to create spring bean for EmployeeServiceImpl class
public class EmployeeServiceImpl implements EmployeeService {
    //inject Dependencies EmployeeReposistory
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // convert employeedto into employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        // Convert Saved EmployeeJpa Entity into EmployeeDto

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    // Implemented getEmployeeById()
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee  employee = employeeRepository.findById(employeeId)
                // Createad Lamda Expression
                .orElseThrow(() ->   // returns employee object
                        new ResourceNotFoundException("Employee is not exists with given id:" +employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // Convert List of Employees Jpa entity int EmployeeDto
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:"+employeeId)
                );

                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setLastName(updatedEmployee.getLastName());
                employee.setEmail(updatedEmployee.getEmail());

                // Save()--> it will save and update

                Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
    // Delete Employe ID()
    @Override
    public void deleteEmployee(Long employeeId) {
        // if Employee Id is'nt there it will get Exception
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:"+employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
