package spring.com.cua_hang_thuoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import spring.com.cua_hang_thuoc.entity.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    List<Employee> findByStatusTrue();

    @Transactional
    @Modifying
    @Query(value = "update employee set status = 0 where emp_code = ?1", nativeQuery = true)
    int setStatusFalse(String maNhaCungCap);

    @Query("select e.empCode from Employee e")
    List<String> getEmployeeCode();
}
