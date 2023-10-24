package spring.com.cua_hang_thuoc.service;

import spring.com.cua_hang_thuoc.dto.SupplierDto;
import spring.com.cua_hang_thuoc.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierDto> findAllDto();
    Supplier findById(String id);
    SupplierDto save(SupplierDto supplierDto);
    String delete(String id);
    SupplierDto update(SupplierDto supplierDto);
    SupplierDto convertToSupplierDto(Supplier supplier);
    Supplier convertToSupplier(SupplierDto supplierDto);
}
