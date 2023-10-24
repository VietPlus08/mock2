package spring.com.cua_hang_thuoc.handleValidate.methodValidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import spring.com.cua_hang_thuoc.dto.SupplierDto;
import spring.com.cua_hang_thuoc.entity.Supplier;
import spring.com.cua_hang_thuoc.service.impl.SupplierServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Component
public class SupplierValidate {

    @Autowired
    SupplierServiceImpl supplierService;

    public Map<String, String> catchNotValidExceptionForUpdateCase(SupplierDto supplierDto, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Supplier supplier = supplierService.findById(supplierDto.getSupplierCode());
        if (supplier == null){
            errors.put("maNhaCungCap","Don't change");
        } else {
            errors.remove("supplierCode");
        }
        return errors;
    }
}
