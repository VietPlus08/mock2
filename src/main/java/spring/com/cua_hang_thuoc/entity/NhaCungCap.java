package spring.com.cua_hang_thuoc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class NhaCungCap {

    @Id
    @Column(columnDefinition = "varchar(25)")
    String maNhaCungCap;

    @Column(columnDefinition = "nvarchar(25)")
    String tenNhaCungCap;

    @Column(columnDefinition = "nvarchar(50)")
    String diaChi;

    @Column(columnDefinition = "varchar(11)")
    String soDienThoai;

    @Column(columnDefinition = "varchar(25)")
    String mail;

    @Column(columnDefinition = "nvarchar(50)")
    String ghiChu;

    @Column(columnDefinition = "bit default 1")
    boolean trangThai = true;
}
