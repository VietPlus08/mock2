package spring.com.cua_hang_thuoc.dto;

import lombok.*;
import spring.com.cua_hang_thuoc.entity.SupplierInvoice;
import spring.com.cua_hang_thuoc.handleValidate.SupplierCodeConstraint;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

    @SupplierCodeConstraint(message = "Mã nhà cung cấp đã tồn tại")
    private String supplierCode;

    @NotBlank(message = "Vui lòng nhập")
    private String supplierName;

    private String address;

    private String numberPhone;

    private String mail;

    private String description;

    private long totalDept;

    private List<SupplierInvoice> supplierInvoiceList;

    public void countTotalDept(long totalDept) {
        this.totalDept += totalDept;
    }
}
