package spring.com.cua_hang_thuoc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.com.cua_hang_thuoc.dto.SupplierDto;
import spring.com.cua_hang_thuoc.entity.Supplier;
import spring.com.cua_hang_thuoc.repo.SupplierRepo;
import spring.com.cua_hang_thuoc.service.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<SupplierDto> findAllDto() {
        return supplierRepo.findByStatusTrue().stream()
                .map(this::convertToSupplierDto)
                .peek(supplierDto -> supplierDto.getSupplierInvoiceList().forEach(i -> {
                    supplierDto.countTotalDept(i.getDept());
                }))
                .collect(Collectors.toList());
    }

    @Override
    public Supplier findById(String id) {
        return supplierRepo.findById(id).orElse(null);
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        Supplier supplier = convertToSupplier(supplierDto);
        return convertToSupplierDto(supplierRepo.save(supplier));
    }

    @Override
    public String delete(String id) {
        return String.valueOf(supplierRepo.setStatusFalse(id));
    }

    @Override
    public SupplierDto update(SupplierDto supplierDto) {
        Supplier supplier = convertToSupplier(supplierDto);
        return convertToSupplierDto(supplierRepo.save(supplier));
    }

    @Override
    public SupplierDto convertToSupplierDto(Supplier supplier) {
        return modelMapper.map(supplier, SupplierDto.class);
    }

    @Override
    public Supplier convertToSupplier(SupplierDto supplierDto) {
        return modelMapper.map(supplierDto, Supplier.class);
    }
}
