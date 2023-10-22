package spring.com.cua_hang_thuoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import spring.com.cua_hang_thuoc.entity.NhaCungCap;

import java.util.List;

public interface NhaCungCapRepo extends JpaRepository<NhaCungCap, String> {

    List<NhaCungCap> findByTrangThaiTrue();

    @Transactional
    @Modifying
    @Query(value = "update nha_cung_cap set trang_thai = 0 where ma_nha_cung_cap = ?1", nativeQuery = true)
    int setTrangThaiFalse(String maNhaCungCap);
}
