package co.id.rest;

import co.id.model.Employee;
import co.id.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeRestControllerSimple {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Retrieve all data at table database Employees
     */
    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Get data With specific ID
     */
    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    /**
     * Create Data Employee
     */
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee e = employeeRepository.save(employee);

        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    /**
     * Update Data Employee
     */
    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") long id){
        Optional <Employee> e = employeeRepository.findById(id);
        e.get().setName(employee.getName());

        employeeRepository.save(e.get());

        return new ResponseEntity<>(e.get(), HttpStatus.OK);
    }

    /**
     * Delete data employee with specific ID
     */
    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") long id){
        employeeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete data All employee
     */
    @DeleteMapping("/api/employees")
    public ResponseEntity<Employee> deleteAllEmployee(){
        employeeRepository.deleteAll();;

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}