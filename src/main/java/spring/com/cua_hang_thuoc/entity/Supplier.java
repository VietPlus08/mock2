package spring.com.cua_hang_thuoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @Column(columnDefinition = "varchar(25)")
    String supplierCode;

    @Column(columnDefinition = "nvarchar(25)")
    String supplierName;

    @Column(columnDefinition = "nvarchar(50)")
    String address;

    @Column(columnDefinition = "varchar(11)")
    String numberPhone;

    @Column(columnDefinition = "varchar(25)")
    String mail;

    @Column(columnDefinition = "nvarchar(50)")
    String description;

    @Column(columnDefinition = "bit default 1")
    boolean status = true;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    List<SupplierInvoice> supplierInvoiceList;
}
