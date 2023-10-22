package spring.com.cua_hang_thuoc.service;

import spring.com.cua_hang_thuoc.dto.NhaCungCapDto;
import spring.com.cua_hang_thuoc.entity.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {

    List<NhaCungCapDto> findAllDto();
    Optional<NhaCungCap> findById(String id);
    NhaCungCapDto save(NhaCungCapDto nhaCungCapDto);
    String delete(String id);
    NhaCungCapDto update(NhaCungCapDto nhaCungCapDto);
    NhaCungCapDto getNhaCungCapDto(NhaCungCap nhaCungCap);
    NhaCungCap getNhaCungCap(NhaCungCapDto nhaCungCapDto);
}
