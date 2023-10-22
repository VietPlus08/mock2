package spring.com.cua_hang_thuoc.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class NhaCungCapDto {

    String maNhaCungCap;

    String tenNhaCungCap;

    String diaChi;

    String soDienThoai;

    String mail;

    String ghiChu;

    long congNo;
}
