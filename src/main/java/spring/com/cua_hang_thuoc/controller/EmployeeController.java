package spring.com.cua_hang_thuoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.com.cua_hang_thuoc.dto.EmployeeDto;
import spring.com.cua_hang_thuoc.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> getList() {
        return ResponseEntity.ok().body(employeeService.findAllDto());
    }

    @PostMapping("")
    public ResponseEntity<?> saveItem(@RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok().body(employeeService.save(employeeDto));
    }

    @PutMapping("")
    public ResponseEntity<?> updateItem(@RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok().body(employeeService.update(employeeDto));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteItem(@RequestParam String id) {
        return ResponseEntity.ok().body(employeeService.delete(id));
    }
}
