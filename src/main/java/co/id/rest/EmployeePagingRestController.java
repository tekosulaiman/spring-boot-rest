package co.id.rest;

import co.id.model.Employee;
import co.id.repo.EmployeePagingRepository;
import co.id.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeePagingRestController {

    /* @Autowired
    EmployeePagingRepository employeePagingRepository; */

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Retrieve all data at table database Employees
     */
    /*@GetMapping("/api/page/employees")
    public ResponseEntity<Object> getAllPages(
            @RequestParam(required = false)String name,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "3")int size
    ){

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeePagingRepository.findPages(pageable);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Data", employees);
        map.put("currentPage", employees.getNumber());
        map.put("totalItems", employees.getTotalElements());
        map.put("totalPages", employees.getTotalPages());


        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }*/

    @GetMapping("/api/slice/employees")
    public ResponseEntity<Object> getAllSlices(
            @RequestParam(required = false)String name,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "3")int size
    ){

        Pageable pageable = PageRequest.of(page, size);
        Slice<Employee> employees = employeeRepository.findAllByName("Harry", pageable);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Data", employees);
        map.put("currentPage", employees.getNumber());

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}