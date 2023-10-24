package spring.com.cua_hang_thuoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import spring.com.cua_hang_thuoc.entity.Supplier;

import java.util.List;

public interface SupplierRepo extends JpaRepository<Supplier, String> {

    List<Supplier> findByStatusTrue();

    @Transactional
    @Modifying
    @Query(value = "update supplier set status = 0 where supplier_code = ?1", nativeQuery = true)
    int setStatusFalse(String maNhaCungCap);
}
