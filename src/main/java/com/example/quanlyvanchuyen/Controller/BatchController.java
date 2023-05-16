package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
    @Autowired
    BatchService batchService;
    @GetMapping
    public ResponseEntity<?> getAllBactch() {
        return ResponseEntity.status(HttpStatus.OK).body(batchService.listBatch());
    }

    @PostMapping
    public ResponseEntity<?> addBacth(@RequestBody Batchdto batchdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(batchService.addBatch(batchdto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBacth(@RequestBody Batchdto batchdto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(batchService.updateBatch(batchdto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBacth(@PathVariable Long id){
        if(batchService.deleteBatch(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
