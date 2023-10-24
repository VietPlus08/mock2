package spring.com.cua_hang_thuoc.handleValidate.anotationValidate;

import org.springframework.beans.factory.annotation.Autowired;
import spring.com.cua_hang_thuoc.handleValidate.SupplierCodeConstraint;
import spring.com.cua_hang_thuoc.service.impl.SupplierServiceImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SupplierCodeValidator implements ConstraintValidator<SupplierCodeConstraint, String> {

    @Autowired
    SupplierServiceImpl supplierService;

    @Override
    public void initialize(SupplierCodeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field!=null && !field.isEmpty() && supplierService.findById(field) == null;
    }
}
