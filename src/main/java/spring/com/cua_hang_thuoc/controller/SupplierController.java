package spring.com.cua_hang_thuoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.com.cua_hang_thuoc.dto.SupplierDto;
import spring.com.cua_hang_thuoc.handleValidate.methodValidate.SupplierValidate;
import spring.com.cua_hang_thuoc.service.SupplierService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/ncc")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierValidate supplierValidate;

    @GetMapping("")
    public ResponseEntity<List<SupplierDto>> getList() {
        return ResponseEntity.ok().body(supplierService.findAllDto());
    }

    @PostMapping("")
    public ResponseEntity<?> saveItem(@RequestBody @Valid SupplierDto supplierDto) {
        return ResponseEntity.ok().body(supplierService.save(supplierDto));
    }

    @PutMapping("")
    public ResponseEntity<?> updateItem(@RequestBody @Valid SupplierDto supplierDto, BindingResult bindingResult) {
        Map<String, String> errors = supplierValidate.catchNotValidExceptionForUpdateCase(supplierDto, bindingResult);
        if (errors.isEmpty()) {
            return ResponseEntity.ok().body(supplierService.update(supplierDto));
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteItem(@RequestParam String id) {
        return ResponseEntity.ok().body(supplierService.delete(id));
    }
}
