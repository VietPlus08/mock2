package spring.com.cua_hang_thuoc.handleValidate;

import spring.com.cua_hang_thuoc.handleValidate.anotationValidate.SupplierCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SupplierCodeValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SupplierCodeConstraint {
    String message() default "Mã nhà cung cấp đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
