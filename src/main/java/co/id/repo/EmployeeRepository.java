package co.id.repo;

import co.id.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //If use List
    /* @Override
    List<Employee> findAll(); */
    Slice<Employee> findAllByName(String name, Pageable pageable);
}