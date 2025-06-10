package net.javaguides.ems.controller;

import jakarta.annotation.Resources;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is Capable to handle Http Requests
// RequestMapping-> Extract Http requests from json and converts Objects
// CrossOrigin ---> All the clients enable to call employee Rest api 
@CrossOrigin("*")
@AllArgsConstructor
//@Resources
@RestController
@RequestMapping("/api/employees") // To define base url for the all restful apis with in this controller
public class EmployeeController {
    private EmployeeService employeeService;

    // Build  Add Employee Rest API
    // Return type of the method       // Method Name
    @PostMapping // used for the to map Incoming Post Requests to This Below Method
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        //Returning the and Http Status code Created
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
    // Build Get Employee Rest API
    // pass the url template variable to this method
    @GetMapping("{id}") // Maps incoming get requests to this method
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build GET ALL EMployees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Employee REST API

    // @RequestBody --> extract the json from the request and converts into employeedto java object
    // Lets us make this method using spring annotation
    @PutMapping("{id}")   // maps incoming put requests to this method
    public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,
                                                       @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee REST API
         // Return type   // Type
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
