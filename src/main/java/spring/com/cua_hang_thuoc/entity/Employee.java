package spring.com.cua_hang_thuoc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(columnDefinition = "varchar(25)")
    String empCode;

    @Column(columnDefinition = "nvarchar(25)")
    String empName;

    @Column(columnDefinition = "nvarchar(50)")
    String address;

    @Column(columnDefinition = "varchar(11)")
    String numberPhone;

    @Column(columnDefinition = "date")
    LocalDate createdDate;

    @Column(columnDefinition = "varchar(25)")
    String account;

    @Column(columnDefinition = "varchar(25)")
    String position;

    @Column(columnDefinition = "bit default 1")
    boolean status = true;

}
