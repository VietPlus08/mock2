package spring.com.cua_hang_thuoc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierInvoice {

    @Id
    @Column(columnDefinition = "varchar(9)")
    String invoiceCode;

    @Column(columnDefinition = "varchar(25)")
    String detailCode;

    @Column(columnDefinition = "date")
    LocalDate createDate;

    @Column(columnDefinition = "time")
    LocalTime createdTime;

    @Column(columnDefinition = "varchar(20)")
    long totalBill;

    @Column(columnDefinition = "varchar(20)")
    long dept;

    @Column(columnDefinition = "bit default 1")
    boolean status = true;

    @ManyToOne
    @JoinColumn(name = "supplierCode")
    Supplier supplier;
}
