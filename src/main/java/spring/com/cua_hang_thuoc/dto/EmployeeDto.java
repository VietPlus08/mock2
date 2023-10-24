package spring.com.cua_hang_thuoc.dto;

import lombok.*;
import javax.persistence.Column;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @Column(columnDefinition = "varchar(5)")
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
}
