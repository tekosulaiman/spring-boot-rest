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
public class EmployeeRestControllerWithMessage {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Retrieve all data at table database Employees
     */
    @GetMapping("/api/v1/employees")
    public ResponseEntity<Object> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data", employees);
        map.put("message","Successfully retrieved data all Employees");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    /**
     * Get data With specific ID
     */
    @GetMapping("/api/v1/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data",employeeOptional.get());
        map.put("message","ID "+id+" Found");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * Create Data Employee
     */
    @PostMapping("/api/v1/employees")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee){
        Employee e = employeeRepository.save(employee);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data", e);
        map.put("message","Successfully added data Employee");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    /**
     * Update Data Employee
     */
    @PutMapping("/api/v1/employees/{id}")
    public ResponseEntity<Object> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") long id){
        Optional <Employee> e = employeeRepository.findById(id);
        e.get().setName(employee.getName());

        employeeRepository.save(e.get());

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data", e);
        map.put("message","Successfully udate data Employee");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    /**
     * Delete data employee with specific ID
     */
    @DeleteMapping("/api/v1/employees/{id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable("id") long id){
        employeeRepository.deleteById(id);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data", id);
        map.put("message","Successfully delete data Employee");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    /**
     * Delete data All employee
     */
    @DeleteMapping("/api/v1/employees")
    public ResponseEntity<Object> deleteAllEmployee(){
        employeeRepository.deleteAll();;

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data", "");
        map.put("message","Successfully delete all data Employee");
        map.put("status", HttpStatus.OK);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}