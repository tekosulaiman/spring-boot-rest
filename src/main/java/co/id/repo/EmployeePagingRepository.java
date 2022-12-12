package co.id.repo;

import co.id.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository*/
public interface EmployeePagingRepository extends CrudRepository<Employee, Long> {
    // If use Page
    /* Page<Employee> findPages(Pageable pageable);
    Page<Employee> findByNameContaining(String title, Pageable pageable); */
}