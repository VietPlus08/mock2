package spring.com.cua_hang_thuoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.com.cua_hang_thuoc.dto.NhaCungCapDto;
import spring.com.cua_hang_thuoc.service.NhaCungCapService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/ncc")
public class NhaCungCapController {

    @Autowired
    NhaCungCapService nhaCungCapService;

    @GetMapping("")
    public ResponseEntity<List<NhaCungCapDto>> getList(){
        return ResponseEntity.ok().body(nhaCungCapService.findAllDto());
    }

    @PostMapping("")
    public ResponseEntity<NhaCungCapDto> saveItem(@RequestBody NhaCungCapDto nhaCungCapDto){
        return ResponseEntity.ok().body(nhaCungCapService.save(nhaCungCapDto));
    }

    @PutMapping("")
    public ResponseEntity<NhaCungCapDto> updateItem(@RequestBody NhaCungCapDto nhaCungCapDto){
        return ResponseEntity.ok().body(nhaCungCapService.update(nhaCungCapDto));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteItem(@RequestParam String id){
        return ResponseEntity.ok().body(nhaCungCapService.delete(id));
    }
}
